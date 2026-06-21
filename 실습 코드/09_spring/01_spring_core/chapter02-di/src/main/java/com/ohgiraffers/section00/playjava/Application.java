package com.ohgiraffers.section00.playjava;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;

public class Application {

    public static void main(String[] args) {

        /*Spring 없이 직접 객체 생성 및 연결*/
        /*이 방식은 이해하기 쉽지만, 객체가 많아지면 관리하기 어렵다.
        * 또 객체 생성이 흩어지게 된다. 구현체가 바뀌면 코드마다 다바꿔줘야 한다
        * 그래서 객체 생성과 다루는 객체를 분리.
        * 직접 객체를 만들지 않는다. 외부에서 전달을 받는다.
        * 구현체 : 인터페이스 기획서를 들고 와서, 실제로 코드 구현해 낸 클래스
        * */
        Account account = new PersonalAccount(20, "110-234-567890");

        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPersonalAccount(account);

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(100000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());


    }
}
