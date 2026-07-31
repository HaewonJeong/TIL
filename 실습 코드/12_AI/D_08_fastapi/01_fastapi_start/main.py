###### 테스트 코드 ######
# from fastapi import FastAPI

# app = FastAPI()

# @app.get("/") # Get 요청을 만들꺼
# async def root(): # async 비동기 요청
#     return {"message": "Hello FastAPI"} # 메세지에 있는 비동기 요청을 할꺼야.
# # uvicorn 폴더명.파일:app --reload(서버 실행해라)
# # http://localhost:8000/docs -> 문서 생성
###### 테스트 코드 ######

import asyncio # 비동기 작업  - sleep 라이브러리
import time    # 동기 방식의 대기를 사용하기 위한 표준 라이브러리 - sleep 라이브러리
from typing import Annotated # 타입 힌트 - 쿼리
from fastapi import FastAPI, Query

app = FastAPI(
    title = "01. FastAPI Start",
    description="FastAPI 객체, decorator...등을 비교",
    version= "1.0.0"    
)

# tags는 Swagger에서 API를 그룹화하는 용도
@app.get("/", tags=["start"])
async def root2() -> dict[str, str]: #dic 타입이기 때문에 key-value가 있다.
    """GET / 요청과 root 함수 연결 """
    return {"message": "Hello FastAPI"}

@app.get("/hello/{name}", tags=["start"])
async def say_hello(name: str) -> dict[str, str]:
    # Python Dictionary를 반환하면 FastAPI가 자동으로 JSON으로 변환된다.
    return {"message": f"Hello {name}"}

@app.get("/server-info", tags=["start"])
async def server_info() -> dict[str, str]:
    return {
        "framwork": "FastAPI",
        "server": "Uvicorn",
        "document": "/docs",
        "oepnapi": "/openai.json"
    }

@app.post("/echo", tags=["method"])
async def echo(message: str = "hello") -> dict[str, str]:
    """같은 URL이라도 허용하지 않은 Method로 요청하면 405에러가 발생"""
    return {"method":"POST", "message": message}

# /wait/sync 주소로 요청이 들어오면 지정한 시간만큼 멈췄다가 응답하는 동기 방식 API
@app.get("/wait/sync", tags=["async"])
def sync_wait(
    seconds: Annotated[float, Query(ge=0, le=2)] = 1 #쿼리 파라미터의 값 검증
) -> dict[str, float | str]:
    time.sleep(seconds)
    return {"type": "sync", "waited_seconds": seconds}

@app.get("/wait/async", tags=["async"])
async def sync_wait(
    seconds: Annotated[float, Query(ge=0, le=2)] = 1
) -> dict[str, float | str]:
    await asyncio.sleep(seconds)
    return {"type": "async", "waited_seconds": seconds}
