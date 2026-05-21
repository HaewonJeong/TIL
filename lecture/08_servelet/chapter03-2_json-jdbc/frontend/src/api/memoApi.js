// 1. 메모 목록 조회
export async function getMemos() {

    //이전에 작성한 config파일의 rewrite를 사용해
    // 'http://localhost:8000/api/:path*'로 보내 서블릿이 처리할 수 있게 된다.
    const response = await fetch('/api/memos');

    if (!response.ok) {
        throw new Error('메모 목록을 불러오지 못했습니다.');
        //get 요청 보냄 > 서블릿의 doget 동작 > memo 객체에 든 static List를 반환
    }
    //Javascript 데이터로 변환해서 반환
    //반환값은 Memo 객체들이 들어있는 배열
    return response.json();
}

// 2. 메모 등록
// Api 8080으로 POST 요청을 보냄 > 서블릿의 doPost가 동작
export async function createMemos(content) {
    const response = await fetch('/api/memos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        //JSON 문자열로 바꿔 Body에 담는다.
        body: JSON.stringify({content}),
    });

    if (!response.ok) {
        throw new Error('메모 등록 실패');
    }
    //서버가 저장 후 돌려준 메모 객체 반환
    //{id: 3, content: '새 메모'}
    return response.json();
}