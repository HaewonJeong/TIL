/**
 * 명시적 타입 변환
 * 개발자의 의도에 따라 값의 타입을 변환하는 것
 */

//문자열 타입으로 변환

// 1. String 생성자 함수를 new 연산자 없이 호출
// 어떤 값이 들어올지 모를 때 가장 안전하게 쓸 수 있는 방법
console.log(String(10)); //"10"
console.log(String(true)); //"true"
console.log(String(null));

//2. toString 메서드 사용
console.log((10).toString()); // "10"
//console.log((null).toString()); 

//숫자 타입으로 변환

//1. Number 생성자 함수를 new 연산자 없이 호출(완벽히 숫자일 때만)
console.log(Number('10.01')); //10.01
console.log(Number('10원')); //Nan
console.log(Number(true));  //1
console.log(Number(false)); //0

//2. parseInt, parsFloat 함수 이용 (문자열 -> 숫자만 가능)
console.log(parseInt('10.01'));
console.log(parseFloat('10.01'));

//논리 타입으로 변환
// 1. boolean 생성자 함수를 new 연산자 없이 호출하는 방법
/**
 * Falsy 6총사(false, undefined, null, 0, Nan, '')는 false로,
 * 나머지는 true로 바꿔주는 방법
 */

console.log(Boolean('JS'));
console.log(Boolean(0));
console.log(Boolean(NaN));

//2. ! 부정 논리 연산자를 두 번 사용하는 방법
console.log(!true); //false

console.log(!!' '); //false
console.log(!!1); //true
console.log(!!0); //false