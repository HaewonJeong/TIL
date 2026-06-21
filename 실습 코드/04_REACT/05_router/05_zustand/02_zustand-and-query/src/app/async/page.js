'use client'
import { useUserStore } from "@/store/useUserStore";
import { useEffect } from "react";

export default function AsyncPage(){
    const { user, loading, fetchUser } = useUserStore();

    //컴포넌트가 처음 나나탈때 데이터를 가져온다.
    useEffect(() => {
        fetchUser();
    },[fetchUser]);

    if(loading) return <h1>데이터 로딩중 ...</h1>

    return(
        <>
            {user ? (
                <div>
                    <h3>이름: {user.name}</h3>
                    <p>이메일: {user.email}</p>
                </div>
            ) : (
            <p>유저 정보가 없습니다.</p>)}

            <button onClick={() => fetchUser()}>데이터 다시 불러오기</button>
        </>
    )
}