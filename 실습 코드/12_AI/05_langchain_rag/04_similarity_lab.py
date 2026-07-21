from rag_core import consine_similarity, vectorize

def compare(question: str, sentence: str)-> None:
    question_vector = vectorize(question)
    sentence_vector = vectorize(sentence)
    score = consine_similarity(question_vector, sentence_vector)

    print("\n" + "=" * 80)
    print("질문: ", question)
    print("문장: ", sentence)
    print("질문 벡터: ", dict(question_vector))
    print("문장 벡터: ", dict(sentence_vector))
    print(f"consine similarity: {score: .3f}")

# 문장에 얼마나 같은 것이 있는지 확인
def main() -> None:
    question = "수강 취소 환불 규정을 알려주세요"

    # 뜻은 비슷하지만 단어는 못찾는다. 그래서 단어를 찾아 준다.
    examples = [
        "수강 취소는 수업 시작 24시간 전까지 신청해야 전액 환불된다.",
        "토요일 실습실 운영 시간은 오전 10시부터 오후 5시까지다.", # open api의 embedding을 통해 쪼갤 예정
        "강의를 듣지 않기로 했다면 낸 비용을 돌려 받을 수 있다."
    ]

    for sentence in examples:
        compare(question, sentence)

if __name__ == "__main__":
    main()

# 결과
# D:\정해원\Songpa-TIL\실습 코드\12_AI>C:\Python312\python.exe "d:/정해원/Songpa-TIL/실습 코드/12_AI/05_langchain_rag/04_similarity_lab.py"

# ================================================================================
# 질문:  수강 취소 환불 규정을 알려주세요
# 문장:  수강 취소는 수업 시작 24시간 전까지 신청해야 전액 환불된다.
# 질문 벡터:  {'수강': 1, '취소': 1, '환불': 1, '규정을': 1}
# 문장 벡터:  {'수강': 1, '취소는': 1, '수업': 1, '시작': 1, '24': 1, '시간': 1, '전까지': 1, '신청해야': 1, '전액': 1, '환불된다': 1}
# consine similarity:  0.158

# ================================================================================
# 질문:  수강 취소 환불 규정을 알려주세요
# 문장:  토요일 실습실 운영 시간은 오전 10시부터 오후 5시까지다.
# 질문 벡터:  {'수강': 1, '취소': 1, '환불': 1, '규정을': 1}
# 문장 벡터:  {'토요일': 1, '실습실': 1, '운영': 1, '시간은': 1, '오전': 1, '10': 1, '시부터': 1, '오후': 1, '5': 1, '시까지다': 1}
# consine similarity:  0.000

# ================================================================================
# 질문:  수강 취소 환불 규정을 알려주세요
# 문장:  강의를 듣지 않기로 했다면 낸 비용을 돌려 받을 수 있다.
# 질문 벡터:  {'수강': 1, '취소': 1, '환불': 1, '규정을': 1}
# 문장 벡터:  {'강의를': 1, '듣지': 1, '않기로': 1, '했다면': 1, '낸': 1, '비용을': 1, '돌려': 1, '받을': 1, '수': 1, '있다': 1}
# consine similarity:  0.000
