'use client';
import { useQuery } from "@tanstack/react-query";
import { fetchUsers } from "../api/userApi";

export default function QueryPage(){
    /**
     * userQuery
     * queryKey : 데이터 고유 이름(캐싱의 키)
     * queryFn: 데이터를 가져올 비동기 함수
     */

    const { data, isLoading, isError, error } = useQuery( {
        queryKey: ["users"], //import
        queryFn: fetchUsers, //import
    } );

    //로딩 상태 처리
    if(isLoading) return (
        <h1>데이터를 불러오는 중입니다...</h1>
    );

    //에러상태 처리
    if(isError) return(
        <p>{error.message}</p>
    );

    return (
        <>
            <h1>유저 목록</h1>
            <ul>
                {data?.map(user=>(
                    <li key={user.id}>{user.name}</li>
                ))}
            </ul>
        </>
    )

}