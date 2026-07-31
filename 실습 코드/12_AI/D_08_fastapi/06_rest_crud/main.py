from typing import Annotated, Literal

from fastapi import FastAPI, HTTPException, Query, Response, status
from pydantic import BaseModel, Field

app = FastAPI(title="REST CRUD")

class TaskResponse(BaseModel):
    id: int
    title: str
    description: str | None
    priority: Literal["low", "normal", "high"] # 허용할 값을 정해둔다.
    completed: bool

class TaskReplace(BaseModel):
    title: str = Field(min_length=1, max_length=100)
    description: str | None = Field(default=None, max_length=300)
    priority: Literal["low", "normal", "high"]
    completed: bool

#PATH는 리소스 일부만 수정
class TaskUpdate(BaseModel):
    title: str | None = Field(default=None, min_length=1, max_length=100)
    description: str | None = Field(default=None, max_length=300)
    priority: Literal["low", "normal", "high"] | None = None
    completed: bool | None = None

tasks: dict[int, TaskResponse] = {
    1: TaskResponse(
        id=1,
        title="FastAPI 문서열기",
        description="/docs에서 endpoint 확인",
        priority="high",
        completed=False
    ),
    2: TaskResponse(
        id=2,
        title="Patch와 Query 복습",
        description=None,
        priority="normal",
        completed=True
    )
}

def find_task_or_404(task_id: int) -> TaskResponse:
    task = tasks.get(task_id)
    if task is None:
        raise HTTPException(status_code=404, detail="해당 task를 찾을 수 없습니다.")
    return task

@app.get("/api/v1/tasks", response_model=list[TaskResponse], tags=["tasks"])
def list_tasks(
    completed: bool | None = None,
    priority: Literal["low", "normal", "high"] | None = None,
    keyword: Annotated[str | None, Query(min_length=2)] = None
) -> list[TaskResponse]:
    result = list(tasks.values())
    if completed is not None:
        result = [task for task in result if task.completed == completed]
    if priority is not None:
        result = [task for task in result if task.priority == priority]
    if keyword is not None:
        result = [task for task in result if result if keyword.lower() in task.title.lower()]
    return result

# 가변은 고정보다 뒤에 있어야 한다.
@app.get("/api/v1/tasks/{task_id}", response_model=TaskResponse, tags=["tasks"])
def get_task(task_id: int)-> TaskResponse:
    return find_task_or_404(task_id)

@app.put("/api/v1/tasks/{task_id}", response_model=TaskResponse, tags=["tasks"])
def replace_task(task_id: int, request: TaskReplace) -> TaskResponse:
    """PUT은 ID를 유지하면서 나머지 자원 표현 전체를 교체"""
    find_task_or_404(task_id)
    replaced = TaskResponse(id=task_id, **request.model_dump())
    tasks[task_id] = replaced # PUT으로 보낸 요청을 GET 할때 받아 올 수 있도록 담는다.
    print(tasks)
    return replaced

@app.patch("/api/v1/tasks/{task_id}", response_model=TaskResponse, tags=["tags"])
def update_task(task_id: int, request: TaskUpdate) -> TaskResponse:
    """exclude_unset=True로 클라이언트가 보낸 필드만 수정"""
    task = find_task_or_404(task_id)
    changed_field = request.model_dump(exclude_unset=True)
    updated = task.model_copy(update=changed_field)
    tasks[task_id] = updated
    return updated
