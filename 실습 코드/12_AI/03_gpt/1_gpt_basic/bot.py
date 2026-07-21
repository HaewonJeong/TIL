#python -u bot.py 입력 > 실행 > 명령어 입력하여 실행 
from __future__ import annotations  # 파이썬 타입 힌트
import os  # 파일을 읽고 쓸때 필요한 모듈
from dotenv import load_dotenv  # dotenv 모듈
import openai  # openapi Key 사용 관련 모듈


load_dotenv() # .env 파일을 환경변수로 등록
API_KEY = os.getenv("OPENAI_API_KEY")  # API 키 설정
if not API_KEY:
    print("환경변수 OPENAI_API_KEY를 설정하세요. 예: .env 파일에 값을 넣거나 환경변수로 설정합니다.")
    raise SystemExit(1)

openai.api_key = API_KEY


def chat_loop():
    print("간단한 챗봇입니다. 'exit' 또는 'quit' 입력 시 종료됩니다.")
    system_prompt = "당신은 친절한 한국어 도우미입니다."  # 톤앤 매너. 지침.
    history: list[dict[str, str]] = []
    while True:
        try:
            user_input = input("You: ").strip()  # trim()과 유사. strip() 메서드를 사용하여 입력값의 앞뒤 공백 제거. 
        except (EOFError, KeyboardInterrupt):
            print("\n종료합니다.")
            break
        if not user_input:
            continue
        if user_input.lower() in ("exit", "quit"):
            print("종료합니다.")
            break

        history.append({"role": "user", "content": user_input})
        # keep a short window of conversation to save tokens
        messages = [{"role": "system", "content": system_prompt}] + history[-10:] # 대화 히스토리

        # temperature 0 : 항상 비슷한 답을 요청해줘
        # temperature 0.3 : 조금 다양한 답
        # temperature 0.7 : 일반적인 대화
        # temperature 1 : 다양하고 창의적인 답

        try:
            resp = openai.ChatCompletion.create(
                model="gpt-3.5-turbo", # GPT 버전. 
                messages=messages,
                max_tokens=500,
                temperature=0.7, 
            )
            reply = resp["choices"][0]["message"]["content"].strip()
            print("Bot:", reply)
            history.append({"role": "assistant", "content": reply})
        except Exception as e:
            print("에러 발생:", e)


if __name__ == "__main__":
    chat_loop()
