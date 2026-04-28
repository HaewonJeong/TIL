'use client'; // persist/page.js : persist에 왔을때 렌더링 될 페이지 생성
import { useState, useEffect } from "react";
import { usePersistStore } from "@/store/usePersistStore";

export default function PersistPage(){
    const { theme, toggleTheme } = usePersistStore();// 1Zustand 스토어에서 데이터 가져오기
    const [isMounted, setIsMounted] = useState(false);// 2. 마운트 상태 관리 (Hydration 에러 방지)
    useEffect( ()=>{
        setIsMounted(true);
    },[]);
    
    
    if(!isMounted)
        return <div>로딩중...</div>;   

    return(
        
         // dark 테마가 true면 #333, 그렇지 않으면 #fff
        <div style={ {background: theme === "dark" ? "#333":"#fff", height:"100vh", padding:"20px"} }>
            <p>현재 테마: {theme}</p>
            <button onClick={toggleTheme}>테마 변경</button>
        </div>
    )
    

}