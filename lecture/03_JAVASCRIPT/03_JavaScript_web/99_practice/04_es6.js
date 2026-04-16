
/*
1. Rest 파라미터와 Spread 문법 활용
- 두 개의 함수 sumAll과 mergeArrays를 작성하세요.
  1. sumAll 함수는 가변 인수를 받아 모든 숫자의 합을 반환합니다.
  2. mergeArrays 함수는 두 개의 배열을 인수로 받아 두 배열을 합친 새 배열을 반환합니다.
- 두 함수를 각각 호출하여 결과를 출력하세요.

예시 출력:
합계: 15
병합된 배열: [1, 2, 3, 4, 5, 6]
*/

function sumAll(args){
    let sum = 0;
    for(let arg of args){
        sum += arg;//agrs를 하나씩 순회하며 arg를 sum에 담는다.
    }
    return sum;
}
arr = [1,2,3];
console.log("합계: ",sumAll(arr));


arr1 = [1,2,3];
arr2 = [4,5,6];
function mergeArrays(arr1, arr2){
    let mergedArray = [...arr1, ...arr2];
    return mergedArray;
}
console.log("병합된 배열: ",mergeArrays(arr1,arr2));


/*
2. 구조분해 할당 활용
- user 객체를 생성하고 name, age, location 속성을 초기화합니다.
- 구조분해 할당을 사용하여 name과 age를 추출하고 이를 이용해 "name은 age살입니다." 형태의 문장을 출력하세요.

임의의 배열을 리터럴로 생성하고,
- 구조분해 할당을 사용하여 배열에서 첫 번째 요소와 나머지 요소를 분리하여 출력하세요.

예시 출력:
홍길동은 30살입니다.
첫 번째 요소: 1
나머지 요소: [2, 3, 4, 5]
*/

const student = {
    u_name: '해언',
    age: 33,
    location: '석촌',
    //키값: 변경할 변수명
}

const { 
    u_name: name1, age 
     //u_name,age='학생'으로 선언해도 구조 분해가 되나, 바꿀 변수명이 있는 키값만 따로 선언한것임
} = student;
console.log(`${name1}은 ${age}살 입니다.`);


const temp_arr = [1,2,3,4,5];
const [a, ...last] = temp_arr;
console.log(`첫 번째 요소: ${a}, 나머지 요소: ${last}`);

/*
3. 클래스와 구조분해 할당을 활용한 학생 관리 시스템
- Student 클래스를 정의하고 name, age, score 속성을 추가하세요.
- 3명의 학생 데이터를 가진 배열 students를 생성하세요. (객체 배열) - new 키워드 사용
- 구조분해 할당을 사용하여 학생들의 이름과 점수만 배열로 추출하여 출력하세요. (map 또는 for...of 사용)

예시 출력:
학생 이름: [유관순, 홍길동, 장보고]
학생 점수: [90, 80, 70]
*/

class Student {
    constructor(name, age, score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    introduce(){
        console.log(`안녕하세요`);
    }
}

let students = [
    new Student("홍길동1",10,10),
    new Student("홍길동2",20,100),
    new Student("홍길동3",30,1000)
];

//map 사용
//const name_result = students.map( ( student )=> student.name  );
//const score_result = students.map( ( student )=> student.score  );

const name_result = students.map( ({name}) => name);
const score_result = students.map( ({score}) => score);


console.log("학생 이름:",name_result);
console.log("학생 점수:",score_result);