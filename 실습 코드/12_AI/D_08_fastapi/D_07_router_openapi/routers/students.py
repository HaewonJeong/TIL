# 파이썬에서 import 경로에 쓰는 폴더명은 변수명 규칙을 따른다. 숫자로 시작 불가능 하다.
# 가공되지 않은 API 스키마 확인 - http://127.0.0.1:8000/openapi.json

from typing import Annotated
from fastapi import APIRouter, HTTPException, Query

from D_08_fastapi.D_07_router_openapi.schemas import (
    Level,
    StudentCreate,
    StudentResponse
)

router = APIRouter(prefix="/students", tags=["students"])
students: dict[int, StudentResponse] = {
    1: StudentResponse(id=1, name="수진", level="beginner"),
    2: StudentResponse(id=2, name="민수", level="intermediate")
}

@router.get("", response_model=list[StudentResponse])
def list_students(
    level: Level | None = None,
    keyword: Annotated[str | None, Query(min_lenght=1)] = None
) -> list[StudentResponse]:
    result = list(students.values())
    if level is not None:
        result = [student for student in result if student.level == level]
    if keyword is not None:
        result = [student for student in result if keyword in student.name]
    return result
    

