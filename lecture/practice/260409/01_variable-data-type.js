// [문제 1] 변수 선언과 데이터 타입
/*
1. 이름(name), 나이(age), 주소(address)를 저장할 수 있는 변수를 선언하고 값을 할당하세요.
2. 각 변수를 콘솔에 출력하세요.
3. typeof를 이용해 데이터 타입을 확인 해보세요.
*/
let name1='해원', age=16, address="서울시";
console.log(name1);
console.log(age);
console.log(address);

// [문제 2] 객체 생성 및 속성 다루기
/*
1. 학생 정보를 저장하는 객체를 만드세요. 객체에는 다음 속성을 추가하세요:
   - 이름(name): 문자열
   - 학번(studentId): 숫자
   - 전공(major): 문자열
2. 객체의 각 속성 값을 콘솔에 출력하세요.
3. 새로운 속성 '학년(year)'을 추가하고 값을 할당하세요.
4. '전공(major)' 속성을 삭제하세요.
5. 최종 객체를 출력하세요.
*/
const student = {
    st_name : "해원",
    st_studentId : 123,
    st_major : "컴퓨터학부"
}
console.log(student.st_name);
console.log(student.st_studentId);
console.log(student.st_major);


// [문제 3] 배열과 배열 메소드 활용
/*
1. 좋아하는 음식 목록을 배열로 만드세요. 배열에는 최소 5개의 음식 이름이 들어가야 합니다.
2. 다음 작업을 수행하세요:
   - 배열에 새로운 음식을 추가하세요.
   - 배열의 마지막 음식을 제거하세요.
   - 배열의 첫 번째 음식을 제거하세요.
   - 배열의 첫 번째에 새로운 음식을 추가하세요.
3. 최종 배열을 콘솔에 출력하세요.
*/

//좋아하는 음식 목록을 배열로 만드세요. (최소 5개)
const food = ['자두','바나나','수박','두리안','사과'];
console.log('초기 배열:', food);
//배열의 맨 끝에 배열에 새로운 음식을 추가하세요. ->push
food.push('딸기');
console.log('추가 후 배열(push):', food);
//배열의 첫 번째 음식 제거 ->pop
food.pop();
console.log('끝 제거 후(pop): ',food);
//배열의 맨 첫 번째 음식을 제거 ->shift
food.shift();
console.log('첫번째 제거 후(shift): ', food); 
//배열의 맨 첫번째 새로운 음식 추가 ->unshift
food.unshift('귤');
console.log('첫번째 추가(unshift)',food);
//최종 배열 콘솔 출력
console.log('최종 배열 출력: ', food);

// [문제 4] forEach와 배열 탐색
/*
1. 숫자 배열을 만드세요. (예: [10, 20, 30, 40, 50])
2. forEach 메소드를 사용하여 각 숫자를 2배로 만들어 새로운 배열에 저장하세요.
3. 최종 배열을 콘솔에 출력하세요.

hint : 새로운 빈 배열 생성해두기
			 배열 메서드인 push()와 *(곱하기)연산자 활용
*/
// let num_arr = [10, 20, 30, 40, 50];

// function forEach(num_arr){    
//     for(let i=0; i<5; i++){
//         num_arr[i] *=2;
//     }
//     return  num_arr;
// }
// forEach(num_arr);
// console.log(num_arr);

// const arr = ["가", "나", "다"];
// arr.forEach(
//     function(element){
//         console.log(element);
//     }
// );

let num_arr = [10, 20, 30, 40, 50];
let new_arr = []; 

num_arr.forEach(function(num){
    new_arr.push(num * 2);
}
);

// [문제 5] 객체 배열 다루기
/*
1. 3명의 학생 정보를 저장하는 객체 배열을 만드세요. 각 객체는 다음 속성을 가져야 합니다:
   - 이름(name): 문자열
   - 학년(grade): 숫자
   - 점수(score): 숫자
   
2. 다음 작업을 수행하세요:
   - 모든 학생의 정보를 콘솔에 출력하세요.(foreach 활용)
   ex) 이름: 홍길동, 학년: 1학년, 점수: 75
*/

const student_arr = [
    {name : "홍길동", grade : 1,  score : 79},
    {name : "김길동", grade : 2,  score : 89},
    {name : "이길동", grade : 3,  score : 99}
];

student_arr.forEach(function(student){
    console.log(`이름: ${student.name}`,`학년: ${student.grade}, `점수: ${student.score});
});
