console.log(calculateArea);
console.log(hi);


//함수의 기본 구조(함수 선언문)
function calculateArea(width, height){ //매개 변수(parameter)
    const area = width * height;
    return area; // 반환값: 호출한 곳으로 값 전달
}

//함수 호출
const result = calculateArea(10, 20); //인자(argument) 전달
console.log(result);

//함수 표현식
//JS의 함수는 객체 타입의 값으로 값의 성질을 갖는 개체를 일급 객체라고 한다.
//일급 객체이므로 함수 리터럴로 생성한 함수 객체를 변수에 할당할 수 있다.
const hi = function(name){
    return `${name}님 안녕하세요!`
}

//식별자로 함수 호출
console.log(hi('판다'));
const calc = function add(a,b){
    return a + b;
}
//console.log(add(10,20)); //함수명으로 호출 시 에러
//함수 호출은 식별자로 이루어 진다. 함수명으로 호출은 불가능하다.!!
console.log(calc(10,20));

