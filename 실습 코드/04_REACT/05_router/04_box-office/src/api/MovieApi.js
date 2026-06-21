// const API_KEY = 'http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=888ec68701a0ccec38dccdafd01cf9067&targetDt=20260419';

/** 일별 박스오피스 정보 조회 */

export async function getMovieList() {

    // 1. API 주소로 요청을 보내고, 데이터가 올 때까지 딱 기다려! (await)
    const ApiKey = "888ec68701a0ccec38dccdafd01cf906"
    const MyApiUrl = `http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=${ApiKey}&targetDt=20260401`
    
    const response = await fetch(MyApiUrl);
  
    // 2. 도착한 데이터를 자바스크립트가 읽을 수 있게 변환하고 기다려! (await)
    const data = await response.json();

    console.log(data);
    
    // 3. 변환된 데이터 중에서 영화 목록(배열)만 쏙 뽑아내기
    return data.boxOfficeResult.dailyBoxOfficeList; // (예시: 영진위 API 기준)

}

/** 영화 코드 전달 -> 영화 상세 정보 조회  */
export async function getMenuByMovieCode(movieCode){
    const ApiKey = "888ec68701a0ccec38dccdafd01cf906"
    const MyApiUrl2 = `http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=${ApiKey}&movieCd=${movieCode}`

    try{
        const response = await fetch(MyApiUrl2);
        const data = await response.json();
        // 상세 정보는 movieInfoResult.movieInfo 안에 들어있습니다.
        console.log('상세정보',data);
        return data.movieInfoResult.movieInfo;

    }catch(error){
        console.error("상세정보 로딩 실패:", error);
    } 
}
