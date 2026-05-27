package com.ohgiraffers.section01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        //이름을 지정하지 않으면 앞 글자 소문자로 Bean이름이 지정 된다.
        MemberService memberService = context.getBean("memberService", MemberService.class);

        System.out.println("==========selectMembers========");
        System.out.println(memberService.selectMembers());

        System.out.println("==========selectMember==========");
        System.out.println(memberService.selectMember(1L));

    }
}
