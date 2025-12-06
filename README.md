# LUKK Automation - Robot Management API

## Overview
This is a RESTful API service built for the LUKK Automation Technical Assessment. It provides endpoints to register robots, manage their status (telemetry), and retrieve activity logs.

**Tech Stack:**
* **Framework:** FastAPI (Python)
* **Database:** SQLite (SQLAlchemy ORM)
* **Validation:** Pydantic
* **Containerization:** Docker

---

## Project Structure
''''''''''''
/lukk-robot-api
│
├── app/
│   ├── main.py              # Application Entry & Configuration
│   ├── models.py            # Database Models (SQLAlchemy)
│   ├── schemas.py           # Pydantic Response/Request Schemas
│   ├── database.py          # DB Connection Logic
│   └── routers/
│       ├── robots.py        # Robot CRUD Endpoints
│       └── logs.py          # Logging Endpoints
│
├── Dockerfile               # Docker Image Configuration
├── requirements.txt         # Python Dependencies
└── README.md                # Documentation






# LUKK Robot Management API

A RESTful API built with FastAPI to manage robot registration, status telemetry, and activity logs.

## Features
- **Register Robots**: Create new entities with IDs and Types.
- **Update Status**: PATCH endpoints for efficient battery/location updates.
- **Logs**: Store and retrieve activity logs per robot.
- **Documentation**: Automatic interactive docs via Swagger UI.

## Setup & Running

### Option 1: Docker (Recommended)
1. Build the image:
   `docker build -t lukk-api .`
2. Run the container:
   `docker run -d -p 8000:80 lukk-api`
3. Access API at `http://localhost:8000`

### Option 2: Local Python
1. Install dependencies: `pip install -r requirements.txt`
2. Run app: `uvicorn app.main:app --reload`
3. Open `http://localhost:8000/docs` to test endpoints interactively.

