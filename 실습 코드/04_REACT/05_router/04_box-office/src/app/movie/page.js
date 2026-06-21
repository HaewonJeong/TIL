'use client';
import { useState, useEffect } from 'react';
import styles from './movie.module.css';
import { getMovieList } from '@/api/MovieApi';
import MovieItem from '@/components/MovieItem';

export default function Movie() {

    const [movieList, setMoiveList] = useState();

    useEffect(() => {
        //getMovieList();
        getMovieList().then(res => setMoiveList(res));
        //promise로 받아온 객체를 사용하려면 .then chaining을 써야 함(중요)

    },[]);
    console.log('movie',movieList);

  return (

    <div className={styles.movieBoard}>
        {movieList?.map(movie => <MovieItem key={movie.rank} movie={movie}  />)}
    </div>

  );
}

