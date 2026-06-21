package com.ohgiraffers.section02.userexception;
import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws PriceNegativeException, NotEnoughMoneyException, MoneyNegativeException {
        System.out.println("가지고 계신 돈은 " +money+ "원 입니다.");

        if(price < 0 ){
            throw new PriceNegativeException("상품 가격은 음수일 수 없다.");
            //나를 호출한 곳으로 예외 위임
            //예외를 메서드 시그니처에 추가
        }
        if(money < 0){
            throw new MoneyNegativeException("가진 돈이 음수일 수 없다.");
        }
        if(money < price){
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비싸다.");
        }

        System.out.println("가진 돈이 충분합니다. 즐거운 쇼핑 하세요~");

    }

}
