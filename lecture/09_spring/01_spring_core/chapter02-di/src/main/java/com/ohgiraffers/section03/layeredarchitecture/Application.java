package com.ohgiraffers.section03.layeredarchitecture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        //context 컨테이너를 만듦. getBean으로 꺼낼 수 있음
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemoController memoController = context.getBean(MemoController.class);

        System.out.println(memoController.findMemos());


    }
}
