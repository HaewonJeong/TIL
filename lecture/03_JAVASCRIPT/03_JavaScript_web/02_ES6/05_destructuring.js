/**
 * 구조 분해 할당
 * 배열이나 객체의 속성을 분해하여 그 값을 개별 변수에 쉽게 담을 수 있게 하는 문법
 * ---배열로 사용하는 요소를 개별 변수로 담고 싶을때 사용한다.--
 */

//기존에는 배열을 따로 담고 싶으면, 
const nameArr = ['Panda', 'Kwon'];  

//기존 방식
// const firstName = nameArr[0];
// const lastName = nameArr[1];

//구조 분해 할당 방식 - 배열은 '순서'가 기준
const [firstName, lastName] = nameArr;
console.log(`성: ${lastName}, 이름: ${firstName}`);

//쉼표를 사용해 특정 요소를 건너뛸 수 있다.
const [, name] = ['kwon', 'panda']; 
console.log(name);

//rest 파라미터로 나머지 요소들을 새로운 배열로 모을 수 있다.
const [leader, ...members] = ['팀장', '팀원1', '팀원2', '팀원3' ]
console.log(leader);
console.log(members);

//기본값 설정: 할당할 값이 없을 때 사용될 기본값 지정
const [user1, user2 = '기본값'] = ['사용자1'];
console.log(user1);
console.log(user2);

//객체 구조 분해 할당
//객체는 '키(key)이름'이 중요하다. 변수 이름과 같은 키를 찾아 값이 할당 된다.
//순서는 중요하지 않다.
const studnet = {
    name: '판다',
    age: 5,
    major: '영화감상',
}

//기존 방식
//const name1 = student.name;
//const age1 = studnet.age;

//객체 안의 키 값과 일치하게 작성해야 값을 받아옴
//const { name1, age } = student;
const { 
    name1: studentName, age
} = student;
//console.log(`이름: ${name1}, 나이: ${age}`);
console.log(`이름: ${studentName}, 나이: ${age}`);

//기본값(=) 설정
const { 
    name1: sName, job = '학생'
    //키값: 변경할 변수명
    //sName,job='학생'으로 선언해도 구조 분해가 되나, 바꿀 변수명이 있는 키값만 따로 선언한것임
} = student;
console.log(job);

//rest 파라미터로 나머지 프로퍼티들을 새로운 객체로 모을 수 있다.
const {age: studentAge, ...restInfo} = student;
console.log(restInfo);

/**
 * 함수 매개변수 구조 분해
 * 함수에 객체를 인자로 전달할 때, 구조 분해 할당을 사용하면
 * 매개변수의 순서를 신경 쓸 필요 없고, 코드의 가독성이 매우 높아진다.
 */

const product = {
    id: 'p-001',
    name: '노트북',
    price: 1500000,
    spec: {
        cpu: 'i7',
        ram: '16GB'
    }
}

// function printProductInfo(){
//     console.log(`상품아이디: ${product.id}`);
//     console.log(`가격: ${product.price}`);   
// }

function printProductInfo({id, price, spec:{ram}, producer = '삼성'}){
    console.log(`상품명 : ${id}`);
    console.log(`상품가격: ${price}`);
    console.log(`RAM: ${ram}`);
    console.log(`제조사: ${producer}`);
}
printProductInfo(product); //중괄호 사용 필요. 같은 key값을 가져와 사용한단거
