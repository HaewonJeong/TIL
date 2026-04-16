/**
 * Rest 파라미터와 스프레드 spread 문법
 * 똑같이 점 세 개 (...)를 사용하지만, 쓰이는 위치에 따라 정반대의 역할을 한다.
 * - Rest Parameter: 여러 개의 값을 하나의 배열로 '모으기'
 * - 여러개의 나머지 값들을 하나의 배열로 모을 때
 * - Spread Syntax: 하나의 배열을 여러 개의 값으로 '펼치기'
 * - 하나의 배열을 여러개의 값으로 펼치기
 */

/**
 * [ Rest Paramater ]
 * 함수의 '매개변수' 자리에 사용하며, 정해지지 않은 개수의 인수들을
 * 하나의 '배열'로 모아서 받는다.
 */

//Rest 파라미터는 반드시 매개변수 목록의 가장 마지막에 위치해야 한다.
function merge(a,b, ...args){
    console.log(a); //1
    console.log(b); //2
    console.log('나머지(배열):', args); //[ '3', '4', '5' ]
    //배열 호출 후 return문 안쓰면 undefined 출력

    let message = a+b;
    for (let arg of args){
        message += arg; //args를 하나씩 순회하며 arg를 message에 담겠다.
    }
    return message;
}

//console.log(merge('1'));
console.log(merge('1','2','3','4','5'));

/**
 * [Spread Syntax]
 * 함수의 '인수' 자리나, 배열/객체 리터럴 안에 사용하여
 * 배열의 요소들을 개별 값의 목록으로 펼쳐준다.
 */

const numbers = [10, 20, 30];
//Math.max(10,20,30): 낱개의 숫자들을 인수로 받는다.
//console.log(Math.max(numbers)); //Nan 반환

//...numbers는 [10, 20, 30]을 10, 20, 30으로 펼쳐준다.
console.log(Math.max(...numbers));

//배열 리터럴에서 사용(합치기/복사)
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const mergedArray = [...arr1, ...arr2, 7, 8]; //배열 쉽게 이어 붙이기 가능
console.log(mergedArray);

//배열 '얕은 복사'
//Spread 배열을 이용하면 값은 같지만, 복사 대상(...arr1)과 arr1Copy는 주소값이 다르다.
const arr1Copy = [...arr1]; 
console.log(arr1 === arr1Copy); //false

arr1Copy.push(4); //복사본 변경
console.log(arr1Copy);
console.log(arr1);

// 값 복사(원시값)
let a = 10;
let b = a;

//주소 복사
let c = [1,2];
let d = c;

//객체 리터럴에서 사용
const obj1 = {name: '판다', age: 5};
const obj2 = {job: '강사'};

const mergedObject = {...obj1, ...obj2, location: '서울'}; 
console.log(mergedObject);

//객체 '얕은 복사'
const obj1Copy = {...obj1};
obj1Copy.age = 3; //복사본 변경
console.log(obj1); //원본에 영향 없음

