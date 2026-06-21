package com.ohgiraffers.section01.intenum;

public class Application {
    static void main() {

        int subject1 = Subject.JAVA;
        int subject2 = Subject.HTML;


        /*상수를 사용할 때 문제점들*/
        //문제 1 : 값이 같아서 다른 과목인데 '같다'고 판단
        if (subject2 == subject1){
            System.out.println("두 과목은 같은 과목입니다.");
        }

        //문제 2 : 타입 안정성 없음
        printSubject(2);
        printSubject(Subject.MYSQL);
        printSubject(100);

        /*
        * 문제상황: 이름이 겹칠 경우 접두어를 붙여야 해서 코드가 지저분해짐
        * BACKEND_JAVASCRIPT
        * FRONTEND_JAVASCRIPT
        * */
        //문제 3 : 전체 순회 불가하다.

    }

    public static void printSubject(int subjectNumber) {
        String subject = "";
        switch (subjectNumber){
            case Subject.JAVA -> subject = "JAVA";
            case Subject.MYSQL -> subject = "MYSQL";
            case Subject.JDBC -> subject = "JDBC";
        }
        System.out.println("전달받은 과목: "+subject);
    }
}
