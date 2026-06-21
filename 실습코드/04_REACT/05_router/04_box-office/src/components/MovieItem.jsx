import Link from "next/link";
import styles from "./movieItem.module.css";

export default function MovieItem({movie}){
    return(
        <>
            <div className={styles.movieCard}>
                {/*동적 링크*/} 
                <Link href={`/movie/${movie.movieCd}`}>
                    <div>
                        <p>순위 : {movie.rank}</p>
                        <h2>{movie.movieNm}</h2> 
                        <p>개봉일 : {movie.openDt}</p>
                        <p>누적 관객수 : {movie.audiAcc}명</p>    
                    </div>
                </Link>
            </div>
        </>

    )
}