from sqlalchemy import Column, Integer, String, ForeignKey, DateTime, Float
from sqlalchemy.orm import relationship
from .database import Base
from datetime import datetime

class Robot(Base):
    __tablename__ = "robots"

    id = Column(String, primary_key=True, index=True) # UUID
    name = Column(String, index=True)
    type = Column(String)
    status = Column(String, default="offline") # online, offline
    battery_level = Column(Integer, default=100)
    location_x = Column(Float, default=0.0)
    location_y = Column(Float, default=0.0)
    mode = Column(String, default="idle") # idle, active, charging, error
    
    # Relationship to logs
    logs = relationship("Log", back_populates="robot")

class Log(Base):
    __tablename__ = "logs"

    id = Column(Integer, primary_key=True, index=True)
    robot_id = Column(String, ForeignKey("robots.id"))
    timestamp = Column(DateTime, default=datetime.utcnow)
    message = Column(String)
    level = Column(String, default="INFO") # INFO, WARN, ERROR

    robot = relationship("Robot", back_populates="logs")