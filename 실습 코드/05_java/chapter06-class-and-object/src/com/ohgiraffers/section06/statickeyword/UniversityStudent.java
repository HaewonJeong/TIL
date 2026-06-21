package com.ohgiraffers.section06.statickeyword;

public class UniversityStudent {

    //1. non-static field : 개인 사물함
    //new로 객체를 만들 떄 마다 Heap에 새로 생성된다. 객체마다 독립적이다.
    private int personalLocker;

    //2. static field : 공용 사물함
    //프로그램 시작 시 static 영역에 단 하나만 생성 된다. 공유 된다.
    private static int sharedLocker;

    public int getPersonalLocker(){
        return this.personalLocker; //객체에 속한 일반 변수는 this 레퍼런스 변수로 접근
    }
    public int getSharedLocker(){
        return UniversityStudent.sharedLocker; //객체에 속하지 않은 static 변수는 클래스명.필드명로 접근
    }

    public void increasePersonalLocker(){
        this.personalLocker++;
    }
    public void increaseSharedLocker(){
        UniversityStudent.sharedLocker++;
    }
}
