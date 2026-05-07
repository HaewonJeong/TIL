package com.ohgiraffers.section02.uses;

//멤버를 조회, 저장
public class MemberRepository {

    //static 배열: 프로그램 전체에서 하나의 저장소를 공유
    //배열을 참조 값을 절대 바꿀수 없게 바꿈
    private final static Member[] members;
    private static int count;

    static {
        members = new Member[10];
    }

    //회원의 배열을 저장소에 저장
    public static boolean store(Member[] newMembers){
        // 현재 인원 + 새로 들어올 인원이 배열 크기(10)보다 크면 false 반환
        if(count + newMembers.length > members.length) {
            return false;
        }
        for(int i = 0 ; i < newMembers.length; i++){
            members[count++] = newMembers[i];
        }
        return true;
    }

    //저장된 전체 회원 배열 반환
    public static Member[] findAllMembers(){
        return members;
    }


}
