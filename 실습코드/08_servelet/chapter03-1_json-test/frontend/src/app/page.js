//이 파일을 클라이언트 컴포넌트로 만든다고 선언
'use client'
import {useEffect, useState} from "react";
import {useMemoStore} from "../store/memoStore";

export default function Home() {

    const [content, setContent] = useState('');

    const {memos, loading, error, fetchMemos, addMemo} = useMemoStore();

    //컴포넌트가 처음 화면에 나타났을 때 메모 목록을 불러온다.
    //처음 마운트 됐을때 상태 가져오는 hook
    // fetchMemos가 변경 될 때만 useEffect 실행
    useEffect(() => {
        fetchMemos();
    }, [fetchMemos]);


    const handleSubmit = async (e) => {
        e.preventDefault(); //form 기본 새로고침 동작 막기
        //입력값이 비어있거나 공백이면 서버에 보내지 않는다.
        if (!content.trim()) {
            return;
        }
        //Zustand의 action을 호출하여 서버에 메모 등록 요청을 보냄
        await addMemo(content);
        setContent('');
    }

    return (
        <main>
            <h1>Memo API</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    placeholder="메모 내용 입력하세요."
                />
                <button type="submit">등록</button>
            </form>

            {/*&&로 loading false거나, error가 falsely(''값)일 떄*/}
            {loading && <p>불러오는중...</p>}

            {error && <p>{error}</p>}

            <ul>
                {memos.map((memo) => (
                    <li key={memo.id}> {memo.content} </li>
                ))}
            </ul>

        </main>
    )
}
