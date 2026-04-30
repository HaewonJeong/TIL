package com.greedy.level01.basic;

public class Calculator2 {
    public static void main(String[] args) {
        return ;
    }
    public void chechMethod(){
        System.out.println("chechMethod 함수가 호출 되었습니다~~!");
        return ;
    }
    //1부터 10까지 수를 더하여 값을 리턴함
    public int sum1to10(){
        int sum=0;
        for(int i=1; i<=10; i++){
            sum += i;
        }
        return sum;
    }
    public void checkMaxNumber(int a, int b){
        System.out.println("큰 값: "+ (a>=b? a:b));
        return ;
    }
    public int sumTwoNumber(int a, int b){
        return a+b;
    }
    public int minusTwoNumber(int a, int b){
        return a-b;
    }
}
