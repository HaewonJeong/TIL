/**
 * Parameter와 Argument
 * 함수를 정의할 때 설정하는 통로를 매개변수(parameter),
 * 실제 호출할 때 넘기는 값을 인수(Argument)라고 한다.
 */

//매개 변수의 유효 범위
function greet(name){
    console.log(name); //내부에서는 자유로움
    console.log(arguments); //2개일때 [Arguments] { '0': '판다', '1': '코알라' }
    return `${name}님 안녕하세요!`
}

//console.log(name); //ReferenceError: name은 함수 내부(지역 스코프)에서만 살아있다.

//인수 개수 불일치
console.log(greet('판다'));
console.log(greet()); //인수 없으면 undefined 할당(에러 발생X)
console.log(greet('판다', '코알라')); //첫 번째만 사용된다. > 판다님 안녕하세요!

//매개변수 기본값 활용
function hi(name='아무개'){ //함수에 기본값 넣기
    //인수가 전달되지 않거나 undefined가 들어오면 '아무개'가 기본으로 쓰임
    return `${name} 안녕?`;
}

console.log(hi()); 
console.log(hi('몽키'));

/**
 * return (반환문)
 */

function add(a, b){
    return a + b;
}

const result = add(10, 20);
console.log(result);

//함수의 종료
function sayHello(name){
    return `${name}님 안녕하세요~`;

    console.log('여기는 출력이 안된다.')
}
//반환값의 생략
function noReturn(){
    console.log('함수 호출됨');
    return;
}

console.log(noReturn());