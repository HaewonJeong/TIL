package com.ohgiraffers.section02.superkeyword;
import java.util.Date;

public class Computer extends Product{
    private String cpu;
    private int ram;

    public Computer(String cpu, int ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public Computer(String code, String brand, String name, int price, Date manufacturingDate, String cpu, int ram) {
        //super는 생성자의 반드시 가장 첫 줄에 와야 한다.
        super(code, brand, name, price, manufacturingDate); //부모의 생성자 호출하여 초기화 하고
        //자식의 변수만 고유하게 호출해서 초기화
        this.cpu = cpu;
        this.ram = ram;
        System.out.println("Computer 클래스의 모든 필드 초기화 생성자 호출");
    }

    public Computer() {
    //super();
        System.out.println("Computer 클래스의 기본 생성자 호출");
    }

    @Override
    public String getInformation() {
        //꼭 super를 붙여서 부모의 메서드 호출함을 명시. 붙이지 않으면 자기자신을 재귀 호출 하게 된다.
        String parentInfo = super.getInformation();
        String computerInfo = ", Computer [cpu="+cpu+", ram="+ram+"]";

        return parentInfo + computerInfo;
    }
}
