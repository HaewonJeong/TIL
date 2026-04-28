/**
 * 연산자
 */

//1. 산술 연산자
let a = 10;
let b = 3;

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b); //나눗셈
console.log(a % b); //나머지
console.log(a ** b); //거듭제곱

//2. 할당 연산자
let c = 5;
c += 3; //복합 할당 연산자 c = c+3과 같다.
console.log(c); //8

c -= 2; // c = c - 2
console.log(c);

//3. 증감 연산자
let d = 5;
console.log(d++); // 후위 증가
console.log(++d); // 전위 증가
console.log(d--); // 후위 감소
console.log(d);