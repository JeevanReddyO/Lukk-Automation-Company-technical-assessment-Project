from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from typing import List
from .. import models, schemas, database

router = APIRouter(prefix="/robots", tags=["Robots"])

# --- 1. Robot Registration API ---
@router.post("/", response_model=schemas.RobotResponse, status_code=201)
def register_robot(robot: schemas.RobotCreate, db: Session = Depends(database.get_db)):
    # Idempotency check: does robot exist?
    db_robot = db.query(models.Robot).filter(models.Robot.id == robot.id).first()
    if db_robot:
        raise HTTPException(status_code=400, detail="Robot ID already registered")
    
    new_robot = models.Robot(**robot.dict())
    db.add(new_robot)
    db.commit()
    db.refresh(new_robot)
    return new_robot

# --- 2. Robot Retrieval APIs ---
@router.get("/", response_model=List[schemas.RobotResponse])
def get_all_robots(skip: int = 0, limit: int = 10, db: Session = Depends(database.get_db)):
    return db.query(models.Robot).offset(skip).limit(limit).all()

@router.get("/{robot_id}", response_model=schemas.RobotResponse)
def get_robot_details(robot_id: str, db: Session = Depends(database.get_db)):
    robot = db.query(models.Robot).filter(models.Robot.id == robot_id).first()
    if not robot:
        raise HTTPException(status_code=404, detail="Robot not found")
    return robot

# --- 3. Robot Status Update API ---
@router.patch("/{robot_id}", response_model=schemas.RobotResponse)
def update_robot_status(robot_id: str, updates: schemas.RobotUpdate, db: Session = Depends(database.get_db)):
    robot = db.query(models.Robot).filter(models.Robot.id == robot_id).first()
    if not robot:
        raise HTTPException(status_code=404, detail="Robot not found")
    
    # Only update fields that were sent (exclude_unset=True)
    update_data = updates.dict(exclude_unset=True)
    for key, value in update_data.items():
        setattr(robot, key, value)
    
    db.commit()
    db.refresh(robot)
    return robot

# --- 4. Robot Logs API (Create) ---
@router.post("/{robot_id}/logs", response_model=schemas.LogResponse)
def create_log(robot_id: str, log: schemas.LogCreate, db: Session = Depends(database.get_db)):
    # Verify robot exists first
    robot = db.query(models.Robot).filter(models.Robot.id == robot_id).first()
    if not robot:
        raise HTTPException(status_code=404, detail="Robot not found - cannot log")
    
    new_log = models.Log(**log.dict(), robot_id=robot_id)
    db.add(new_log)
    db.commit()
    db.refresh(new_log)
    return new_log

# --- 5. Robot Logs API (Retrieve) ---
@router.get("/{robot_id}/logs", response_model=List[schemas.LogResponse])
def get_robot_logs(robot_id: str, db: Session = Depends(database.get_db)):
    logs = db.query(models.Log).filter(models.Log.robot_id == robot_id).all()
    return logs