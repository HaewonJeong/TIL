from enum import StrEnum
from typing import Annotated
from fastapi import FastAPI, Path, Query
from pydantic import BaseModel

app = FastAPI(title="Request Parameters")
class ModelName(StrEnum):
    alexnet = "alexnet"
    resnet = "resnet"
    lenet = "lenet"

# API가 반환하는 데이터 구조를 정의
class ItemResponse(BaseModel):
    id: int   # 상품 ID
    name: str # 상품명
    category: str # 카테고리 

ITEMS = [ #DB가 없어서 객체를 만들었다.
    ItemResponse(id=1, name="FastAPI기초", category="python"),
    ItemResponse(id=2, name="REST API", category="web"),
    ItemResponse(id=3, name="Spring 연동", category="java"),    
    ItemResponse(id=4, name="파일 API", category="python")        
]

@app.get("/items/{item_id}", tags=["Path"])
async def read_item(
    item_id: Annotated[int, Path(ge=1, description="1 이상의 item ID")]   
) -> dict[str, int]:
    return {"item_id": item_id}

@app.get("/models/{model_name}", tags=["path"])
async def read_model(model_name: ModelName) -> dict[str, str]:
    descriptions = {
        ModelName.alexnet: "이미지 분류 모델",
        ModelName.resnet: "잔차 연결을 사용하는 이미지 모델",
        ModelName.lenet: "초기 합성곱 신경망"
    }
    return {"model_name": model_name, "description": descriptions[model_name]}

# 고정 경로는 동적 경로보다 먼저 선언해야
# "me"가 user_id로 처리되지 않습니다.
# 구체적인 경로 먼저 (이름이 정확히 "me"인 전용 창구)
@app.get("/user/me", tags=["path-order"])
async def read_current_user() -> dict[str, str]:
    return {"user_id": "me", "role": "current_user"}

# 범위가 넓은 동적 경로 나중 사용
@app.get("/user/{user_id}", tags=["path-order"])
async def read_user(user_id: str)-> dict[str, str]:
    return {"user_id": user_id, "role": "selected user"}

@app.get("/items", 
        response_model=list[ItemResponse],  #쿼리문의 응답 객체를 temResponse로 들어간다
        tags=["query"])
async def list_items(
    skip: Annotated[int, Query(ge=0)] = 0,
    limit: Annotated[int, Query(ge=1, le=10)] = 3,
    category: str | None = None #카테고리에 값이 있으면 넣어주고, 아니면 None 처리
) -> list[ItemResponse]: 
    filtered = [item for item in ITEMS if category is None or item.category == category]
    return filtered[skip : skip + limit] # 범위 슬라이싱 [start:end]


