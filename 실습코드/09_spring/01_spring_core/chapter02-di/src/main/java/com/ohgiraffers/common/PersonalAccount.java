package com.ohgiraffers.common;

public class PersonalAccount implements Account {

    private final int backCode;
    private final String accNo;
    private int balance;

    public PersonalAccount(int backCode, String accNo, int balance) {
        this.backCode = backCode;
        this.accNo = accNo;
        this.balance = balance;
    }

    public PersonalAccount(int backCode, String accNo) {
        this.backCode = backCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo+ "계좌 잔액은"+this.balance+"원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String str = "";
        if(money >= 0){
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        }else{
            str = "금액이 잘못 입금되었습니다.";
        }
        return "";
    }

    @Override
    public String withDraw(int money) {

        String str = "";
        if(this.balance >= money){
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        }else{
            str = "잔액이 부족합니다.";
        }
        return "";
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "backCode=" + backCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
