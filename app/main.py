from fastapi import FastAPI, Depends, HTTPException, Security
from fastapi.security.api_key import APIKeyHeader
from . import models, database
from .routers import robots

# Create DB tables
models.Base.metadata.create_all(bind=database.engine)

app = FastAPI(title="LUKK Automation Robot API")

API_KEY = "lukk-secret-key-123"
api_key_header = APIKeyHeader(name="X-API-Key", auto_error=False)

async def get_api_key(api_key_header: str = Security(api_key_header)):
    if api_key_header == API_KEY:
        return api_key_header
    else:
        # Allow open access for assessment demo, but warn or block in production
        # raise HTTPException(status_code=403, detail="Could not validate credentials")
        return None

# Register Routers
app.include_router(robots.router) # Protect with dependencies=[Depends(get_api_key)] if needed

@app.get("/")
def read_root():
    return {"message": "LUKK Automation API is running. Go to /docs for Swagger UI."}