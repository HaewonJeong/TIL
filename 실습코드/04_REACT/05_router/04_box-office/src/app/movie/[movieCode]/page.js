'use client'
import { useParams } from "next/navigation";
import { useState, useEffect } from "react";
import { getMenuByMovieCode } from "@/api/MovieApi";
import Link from "next/link";
import styles from "../movie.module.css";

export default function MovieDetail(){

    const {movieCode} = useParams(); //동적인 값을 읽어온다.
    console.log('movieCode',movieCode);

    const [movie, setMoiveList] = useState();

    useEffect( ()=> {
        getMenuByMovieCode(movieCode).then(res => setMoiveList(res));
          console.log('상세정보',movie);
    },[movieCode]);

    // 💡 데이터가 오기 전에는 "로딩 중" 표시 (안 하면 undefined 에러 남)
    if (!movie) return <div>로딩 중...</div>;

    return (
        <>
            <div className={styles.movieDetail}>
                <h1>{movie.movieNm}({movie.movieNmEn})</h1>
                <p>러닝 타임 : {movie.showTm}분</p>
                <p><br />국가 : {movie.nations[0].nationNm}</p>
                <p><br /><strong>출연</strong></p>
                {movie.staffs?.map((staff, index) => (
                    <p key={index}>{staff.peopleNm}</p>
                )) || <p>배우 정보가 없습니다.</p>}                
                <p><br/><Link href="/movie">목록으로</Link> </p>
            </div>
        </>
    )
d
}