import os
from pathlib import Path

import streamlit as st
from dotenv import load_dotenv
from openai import OpenAI


st.set_page_config(
    page_title="AI 상담 챗봇",
    page_icon="💬",
    layout="centered",
)

SYSTEM_PROMPT = "너는 사용자의 고민을 친절하게 들어주고 도움을 주는 상담사야."
PROJECT_ROOT = Path(__file__).resolve().parent.parent
load_dotenv(PROJECT_ROOT / ".env")


@st.cache_resource
def get_openai_client(api_key: str) -> OpenAI:
    return OpenAI(api_key=api_key)


def get_ai_response(client: OpenAI, messages: list[dict[str, str]]) -> str:
    response = client.chat.completions.create(
        model="gpt-4o-mini",
        temperature=0.9,
        messages=messages,
    )
    return response.choices[0].message.content or "답변을 생성하지 못했습니다."


def reset_messages() -> None:
    st.session_state.messages = [
        {"role": "system", "content": SYSTEM_PROMPT}
    ]


st.title("💬 AI 상담 챗봇")
st.caption("고민이나 궁금한 내용을 입력하면 AI가 답변합니다.")

api_key = os.getenv("OPENAI_API_KEY")
if not api_key:
    st.error(
        "OPENAI_API_KEY를 찾을 수 없습니다. "
        "프로젝트 루트의 .env 파일에 API 키를 설정해 주세요."
    )
    st.stop()

client = get_openai_client(api_key)

if "messages" not in st.session_state:
    reset_messages()

with st.sidebar:
    st.header("대화 설정")
    if st.button("대화 내용 초기화", use_container_width=True):
        reset_messages()
        st.rerun()

for message in st.session_state.messages:
    if message["role"] == "system":
        continue

    with st.chat_message(message["role"]):
        st.markdown(message["content"])

if user_input := st.chat_input("메시지를 입력해 주세요."):
    user_message = {"role": "user", "content": user_input}
    st.session_state.messages.append(user_message)

    with st.chat_message("user"):
        st.markdown(user_input)

    with st.chat_message("assistant"):
        with st.spinner("답변을 생성하고 있습니다..."):
            try:
                ai_response = get_ai_response(
                    client,
                    st.session_state.messages,
                )
            except Exception as error:
                st.error(f"OpenAI API 호출 중 오류가 발생했습니다: {error}")
            else:
                st.markdown(ai_response)
                st.session_state.messages.append(
                    {"role": "assistant", "content": ai_response}
                )
