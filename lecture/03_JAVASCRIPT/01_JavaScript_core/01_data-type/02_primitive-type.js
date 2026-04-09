/**
 * 원시 데이터 타입(Primitive types)
 * 원시 타입은 변경 불가능한 값들이며, 자주 사용되는 원시 타입으로는
 * 숫자(Number), 문자열(string), 불린(boolean), null, undefined 등이 있다.
 */

// 1. 숫자(number)
let age = 30;
console.log(age);

// 숫자 타입은 모두 실수로 처리되므로 둘은 같다.
console.log(10 === 10.0);
console.log(10 / 4);

// 2. 문자열
// 작은 따옴표(''), 큰 따옴표(""), 또는 백틱(``)으로 텍스트를 감싼다.
let string1 = "문자열"; //'', "", `` 다 문자 취급하는 언어
let string2 = '문자열';
let string3 = `문자열`;
console.log(string1);

// 3. 불린(boolean) : 논리적 참, 거짓을 나타내는 true와 false 뿐이다.
let isStudent = true;
console.log(isStudent);

// 4. null: 명시적으로 값이 없음을 의도적으로 명시할 때 사용.
let address = null;
console.log(address);

// 5. undefined: 변수에 값이 할당되지 않았을 때 자동으로 할당되는 값
let salary;
console.log(salary);

// 6. typeof : 데이터 타입을 확인 할 때 사용
console.log(typeof age);
console.log(typeof string);
console.log(typeof isStudent);
console.log(typeof address);
console.log(typeof salary);


/**
 * 템플릿 리터럴
 * ES6부터 도입 된 멀티라인 문자열, 표현식 삽입 등의 편리한 문자열 처리 기능을 제공하는 문제열 표기법
 * 작은 따옴표, 큰 따옴표 대신 백틱(``)을 사용해 표현한다.
 * 
 */

//일반 문자열 내에서는 줄바꿈 허용되지 않음
//let str= '안녕하세요'
//반갑습니다.';

let str = '1.안녕하세요\n반갑습니다.'
console.log(str);

// 백틱을 사용하면 줄바꿈과 공백이 있는 그대로 적용됨
let multiline = `2.안녕하세요.
반갑습니다.`;
console.log(multiline);

let lastName = '3.홍';
let firstName = '길동';

console.log('4-1.제 이름은 '+lastName+firstName+' 입니다');
//표현식 삽입 : ${}
console.log(`4-2.제 이름은 ${lastName}${firstName} 입니다.`);
//백틱(`)이 아니라 '(작은 따옴표)를 사용하면 문자열 그대로 출력 되니 백틱 안쪽에 문자열 사용하도록 주의하기


