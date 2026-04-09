/**
 * 논리 연산자는 여러 조건을 결합하여 하나의 논리적인 결과를 도출한다.
 * AND, OR, NOT 연산자가 있다.
 */

const a = true;
const b = false;

//논리 AND (&&) : 모두 true 일때만 true 반환
console.log(a && b);

//논리 OR (||): 둘 중 하나만 true여도 true 반환
console.log(a || b);

//논리 NOT (!): true이면 false로, false이면 true로 반전
console.log(!a);
console.log(!b);

/**
 * 표현식 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
 */
//빈 값이 아니면 True
console.log('apple' || 'banana'); //apple
console.log(false || 'banana'); //banana
console.log(false && 'banana'); //false
/**
 * 자바스크립트는 true라는 불리언 값을 새로 만드는 대신, 결론을 내리게 해준 주인공인 'apple'을 그대로 던져줍니다. 그래서 결과가 'apple'입니다.
 *  */ 

//단축평가를 이용한 Null 체크!
let obj = null;
//let objValue = obj.value; // TypeError: Cannot read properties of null (reading 'value')
/**단축 평가 하여 타입 에러 발생 */

let objValue = obj && obj.value;
/**obj는 null 값으로, falsy한 값. 그래서 obj 값을 먼저 봤을때 falsy한 값이면, 뒤쪽 obj.value는 확인 안함 > 에러 안남 */

/**
 * 삼항 연산자(Ternary Operator)
 * Optional Chaining (옵셔널 체이닝)
 */

const obj1 = null;

//obj가 null 또는 undefined 인 경우 undefined 반환
//obj가 다른 Falsy한 값(0, '')인 경우 그대로 0 또는 '' 반환
//const objValue = obj?.value;
const objValue1 = obj1?.value

/**
 * null 병합 연산자
 * 에크마 스크립트 2020 ES11버전(ECMAScript 2020 ES11) 부터 도입
 * 좌항의 피연산자가 null 또는 undefined인 경우 우항을 반환, 
 * 그렇지 않으면 좌항의 피연산자를 반환 한다.
 * >> 변수에 값이 없으면 우항 값을 사용해줘!
 */
let test = null ?? '기본 값';
console.log(test);

let value1 = '' ?? '기본 값';
console.log(value1);

let value2 = 0 ?? '기본 값';
console.log(value2);