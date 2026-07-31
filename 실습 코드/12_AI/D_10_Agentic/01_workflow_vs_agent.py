"""
    workflow : 개발자가 python if문으로 tool과 실행 순서를 결정
    Agent : OpenAI모델이 질문과 Tool Schema를 보고 실행 중 결정
"""

import argparse # 터미널에서 실행할 때 옵션값
import os # getenv 환경변수를 읽기
import re # 정규 표현식 문자열에서 특정 형식을 찾거나 제거할 때 사용
from dataclasses import dataclass  # 데이터를 담는 클래스를 간단하게 만들기 위해 사용

from dotenv import load_dotenv
from langchain.agents import create_agent # 에이전트 생성
from langchain_core.tools import tool # 일반 Python 함수를 에이전트가 사용할 수 있는 도구로 등록하기 위해 사용
from langchain_openai import ChatOpenAI # LangChain에서 OpenAI의 채팅 모델을 사용하기 위해 필요

QUESTIONS = [
    ("장소", "비 오는 날 갈 실재 장소를 찾아줘"),
    ("예산", "3명이 입장료 35000원, 식비 20000원씩 쓰면 얼마야?"),
    ("도구 없음", "즐거운 여행이 되라고 인사해줘"),
    (
        "복합 요청",
        "실내 장소를 찾고, 3명이 입장료 35000원과"
        "식비 20000원씩 쓰는 예산도 계산해줘"
    )
]

# 이거 하나 호출해서 workflow에 넣어줄 예정
# @tool : 일반 Python 함수를 LangChain 에이전트가 호출할 수 있는 도구로 등록
@tool 
def search_destination(condition: str) -> str:
    """여행 데이터에서 요청 조건에 맞는 장소를 검색"""
    if "실내" in condition:
        return(
            "롯데 월드 아쿠아리움: 실내, 입장료 35,000원\n"
            "서울스카이: 실내, 입장료 31,000원"
        )
    if "무료" in condition or "산책" in condition:
        return "석촌호수: 야외 산책, 무료"
    return "검색 결과 없음"

#인원수, 1인당 입장료, 1인당 식비를 숫자로 추출한 뒤 하루 전체 예산을 계산하는 에이전트 도구
@tool
def estimate_day_budget(request: str)-> str:
    """하루 예산을 계산"""
    numbers = [int(value) for value in re.findall(r"\d+", request)] #숫자를 찾아서 정수로 변환

    if len(numbers) < 3:
        return "계산에 필요한 인원, 입장료, 식비가 부족합니다."
    travelers, ticket_price, meal_budget = numbers[:3]
    total = travelers * (ticket_price + meal_budget)
    return f"{travelers}명 하루 예산 비용: {total:,}원"

@dataclass
class workflowResult:
    """개발자가 미리 정의한 workflow 실행 기록"""
    path: list[str]
    observations: list[str]

def run_workflow(question: str) -> workflowResult:
    needs_destination = any(word in question for word in ("장소", "실내", "관광지"))
    needs_budget = any(
        word in question for word in ("비용", "예산", "얼마", "입장료", "계산")
    )

    path: list[str] = []
    observations: list[str] = []

    if needs_destination:
        path.append("search_destination")
        observations.append(search_destination.invoke({"condition": question}))
    if needs_budget:
        path.append("estimate_day_budget")
        observations.append(estimate_day_budget.invoke({"request": question}))
    path.append("write_answer")
    if not observations:
        observations.append("Tool 없이 일반 답변")
    return workflowResult(path=path, observations=observations)

def build_agent():
    load_dotenv()
    if not os.getenv("OPENAI_API_KEY"):
        raise SystemExit(".env에 OPENAI_API_KEY를 설정한 뒤 --run을 사용하세요.")
    model = ChatOpenAI(model="gpt-4o-mini", temperature=0)    
    return create_agent(
        model=model,
        tools=[search_destination, estimate_day_budget],
        system_prompt=(
            "너는 여행 도우미다. 필요한 경우에만 tool을 사용한다."
            "복합 요청에는 필요한 Tool을 모두 사용하고 Tool 결과로 답한다."
        )
    )

def extract_tool_calls(message: list) -> list[dict]:
    """Agent 메세지에서 모델이 실제로 만든 tool_calls 모음"""
    return [
        tool_call
        for message in message
        for tool_call in getattr(message, "tool_calls", [])
    ]

def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument(
        "--run", # --run 옵션이 있는지 확인하고, 있을 때만 실제 OpenAI Agent를 생성
        action="store_true",
        help="같은 질문을 실제 OpenAI Agent에도 보내서 비교"
    )
    args = parser.parse_args()
    agent = build_agent() if args.run else None

    for label, question in QUESTIONS:
        workflow = run_workflow(question)
        print(f"\n{'=' * 80}")
        print(f"[{label}] {question}")
        print("\nWorkflow 결정 주체: 개발자")
        print("Workflow path:", "-> ".join(workflow.path))
        for observation in workflow.observations:
            print("workflow 결과: ", observation)

        if agent is None:
            print("\nAgent: --run을 붙이면 실제 모델의 tool_calls를 확인한다.")
            continue

        result = agent.invoke({"messages":[{"role": "user", "content": question}]})
        tool_calls = extract_tool_calls(result["messages"])
        print("\nAgent 결정 주체 : 모델")
        if tool_calls:
            for tool_call in tool_calls:
                print(
                    "Agent tool_call:",
                    tool_call["name"],
                    "/ args=",
                    tool_call["args"]
                )
        else:
            print("Agent tool_call: 없음")
        print("Agent 최종 답변:", result["messages"][-1].content)

    print(f"\n{'=' * 80}")

if __name__ == "__main__":
    main()

    