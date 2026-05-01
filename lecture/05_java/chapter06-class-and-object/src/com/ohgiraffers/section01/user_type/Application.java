package com.ohgiraffers.section01.user_type;

public class Application {
    static void main() {
        int age = 20;
        String name = "홍길동";
        /*사용자 정의 자료형 사용하기*/
        //1. 클래스(설계도) 만든다, (Member.java)
        //2. 'new' 연산자를 통해 설계도 대로 실제 객체를 메모리에 생성한다.*/
        //3. 생성된 객체의 주소값을 담을 변수(참조 변수)를 선언하고, 주소값을 저장한다.
        //자료형 변수명 = new 클래스명();

        Member member = new Member();
        //객체의 필드에 접근할때는 '.'(참조 연산자) 사용
        member.id = "user01";
        member.pwd = "pass01";
        member.age = 20;
        member.name = "홍길동";
        member.gender = '남';
        member.hobby = new String[]{"축구", "볼링", "테니스"};
        System.out.println(member.id);
        System.out.print("hobby : ");
        for(int i=0; i<member.hobby.length;i++){
            System.out.print(member.hobby[i]+ " ");
        }

    }
}
