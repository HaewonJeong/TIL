package com.ohgiraffers.Section03.overriding;

public class VendingMachine {
    public String vend(){
        return "밀크 커피";
    }
    private void checkStock(){
        System.out.println("자판기 재고를 확인합니다.");
    }
    private final void powerOn(){

        System.out.println("자판기 전원을 켭니다.");
    }
    protected void clean(){
        System.out.println("자판기 내부를 청소합니다");
    }
}
