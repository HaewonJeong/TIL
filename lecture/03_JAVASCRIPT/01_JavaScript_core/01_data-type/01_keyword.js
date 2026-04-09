/**
 * 변수
 * 변수는 데이터를 저장할 때 쓰이는 '이름이 붙은 저장소' 이다.
 * 변수를 생성할 때 우리는 변수를 선언한다고 표현한다.
 * 
 * 키워드 변수명;
 * 키워드 : 변수의 접근 범위를 지정
 * 변수명 : 변수를 부를 이름 설정.
 */

//var : ES5까지 사용했던 유일한 키워드

var number;
var number = 5;

//let : 값을 변경할 수 있는 변수 선언
let greeting = "Hello, Node.js!";
console.log(greeting);

greeting = "Welcome to JavaScript!";
console.log(greeting);

//const : 재할당이 금지
const num = 1;
//num = 2;
//const num1; //const 키워드로 선언한 변수는 반드시 선언과 동시에 초기화 해야 한다.

/**
 * 변수 선언 규칙과 스타일
 * - 변수 이름은 알파벳, 숫자, _, $만 사용할 수 있다.
 * - 변수 이름은 숫자로 시작 할 수 없다.
 * - 카멜 케이스(camelCase)를 사용하는 것이 일반적이다.
 * - 예약어 사용 금지
 * - 대소문자 구분: 변수 이름에서 대소문자를 구분한다. A, a는 다른 변수이다.
 * - 의미 있는 이름 사용: 변수 이름은 그 변수의 역할이나 내용을 명확하게 나타내는것이 좋다.
 */

let userName = "panda"; //카멜케이스 스타일
let userAge = 20;

console.log('사용자 이름: ' + userName + ', 나이: '+userAge);
console.log(`사용자 이름: ${userName}, 나이: ${userAge}`);

