from pydantic import BaseModel
from typing import Optional, List
from datetime import datetime

# --- Log Schemas ---
class LogBase(BaseModel):
    message: str
    level: str = "INFO"

class LogCreate(LogBase):
    pass

class LogResponse(LogBase):
    id: int
    robot_id: str
    timestamp: datetime
    class Config:
        orm_mode = True

# --- Robot Schemas ---
class RobotBase(BaseModel):
    name: str
    type: str

class RobotCreate(RobotBase):
    id: str # User or System defines UUID

class RobotUpdate(BaseModel):
    # All optional because PATCH updates only specific fields
    status: Optional[str] = None
    battery_level: Optional[int] = None
    location_x: Optional[float] = None
    location_y: Optional[float] = None
    mode: Optional[str] = None

class RobotResponse(RobotBase):
    id: str
    status: str
    battery_level: int
    location_x: float
    location_y: float
    mode: str
    
    class Config:
        orm_mode = True