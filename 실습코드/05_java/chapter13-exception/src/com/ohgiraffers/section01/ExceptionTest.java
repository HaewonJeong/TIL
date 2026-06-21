package com.ohgiraffers.section01;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception{
        //throws를 통해 에러를 위임함

        System.out.println("가지고 계신 돈은 "+money+"원 입니다.");

        if(money >= price){
            System.out.println("상품 구입하기 위한 돈 충분합니다.");
        }else{
            throw new Exception("돈이 부족 합니다."); //에러 발생
        }

        System.out.println("즐거운 쇼핑 하세요~");


    }
}
