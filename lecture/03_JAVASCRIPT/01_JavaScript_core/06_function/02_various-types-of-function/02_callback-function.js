/**
 * 콜백 함수
 * 다른 함수의 '재료(인자)' 로 전달되어, 그 함수의 실행 시점을 제어하는 함수이다.
 */

//고차 함수 ; 함수를 잊자롤 받는 함수
function calculaotr(calculaotrCallback, a, b){
    console.log('계산을 시작합니다...');
    const result = calculaotrCallback(a,b);
    return result
}
//콜백1
function add(a, b){
    return a + b
}
//콜백2
function mitipy(a, b){
    return a * b
}

const addResult = calculaotr(add, 10, 5);
console.log(addResult);

const multiplyResult = calculater(multiplya)
console.log(multiplyResult)

const naems = [3,4,5,10]
CountQueuingStrategy