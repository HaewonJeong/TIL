package com.ohgiraffers.section06.statickeyword;

public class CampusActivity {
    //non-static : 개인
    private int personalLocker;

    //non-static 메소드
    public void openPersonalLocker(){
        this.personalLocker++;
        System.out.println("개인 사물함을 열었습니다. 사용 횟수 : "+this.personalLocker);
    }

    //static 메소드
    //객체 없이 존재하는 메소드이기 때문에 나 자신이 존재하지 않으므로 this 키워드 사용할 수 없다.
    public static void libararyAnnouncement(){
        //this.personalLocker++;
    }
}
