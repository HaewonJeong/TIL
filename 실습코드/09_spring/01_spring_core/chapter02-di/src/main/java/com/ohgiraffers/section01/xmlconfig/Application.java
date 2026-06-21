package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-contenxt.xml");

        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(100000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withDraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());

    }
}
