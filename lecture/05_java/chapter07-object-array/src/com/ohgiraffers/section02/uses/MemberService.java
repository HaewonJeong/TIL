package com.ohgiraffers.section02.uses;

import java.util.Scanner;

public class MemberService {
    //회원 5명 일괄 등록
    public void signUpMebers(){
        Member[] members = {
                new Member(1,"user01","pass01",20,'남'),
                new Member(2,"user01","pass02",16,'여'),
                new Member(3,"user01","pass03",28,'남'),
                new Member(4,"user01","pass04",15,'여'),
                new Member(5,"user01","pass05",31,'남'),
        };
        //members를 Repository에 담아서 스토어에 저장
        /*store 메서드에 static이 붙어있기 때문에 생성자로 인스턴스 생성하지 않고 호출 가능!*/
        if(MemberRepository.store(members)){
            System.out.println("총 "+members.length+"명 등록 성공!");
        }else {
            System.out.println("정원 초과로 등록 실패");
        }
    }
    //전체 회원 조회
    public void showAllMembers(){
        Member[] allMembers = MemberRepository.findAllMembers();
        for (Member member : allMembers){
            if(member != null)
            {
                System.out.println(member.getInformation());
            }
        }
    }
    //아이디로 회원 검색
    public void searchMemberById(Scanner sc){
        System.out.println("검색할 아이디를 입력하세요: ");
        String searchId = sc.nextLine();

        Member[] foundMember = MemberRepository.findAllMembers();
        boolean isFound = false; //플래그 변수 설정

        for(Member member : foundMember){
            if(member != null){
                if(searchId.equals(member.getId())){
                    System.out.println("--------- 검색 결과 --------");
                    System.out.println(member.getInformation());
                    isFound = true;
                    break; //가장 가까운 반복문 탈출
                }
            }
        }
        if(!isFound){
            System.out.println("아이디 ["+searchId+"] 회원을 찾을 수 없습니다.");
        }
    }
}
