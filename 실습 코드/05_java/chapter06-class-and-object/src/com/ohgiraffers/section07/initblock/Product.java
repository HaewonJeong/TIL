package com.ohgiraffers.section07.initblock;

public class Product {

    //명시적 초기화: 필드를 선언하면서 값 할당
    //객체가 생성될 때 가장 먼저 이 값으로 초기화 된다.
    private String name = "갤럭시";
    private int price = 15000000;
    private static String brand = "삼송";
    //static 초기화 블록 -> 명시적 초기값 -> 인스턴스 초기화 블록 -> 생성자

    //인스턴스 초기화 블럭: 생성자 보다 먼저, 모든 생성자 공통 실행
    //오버로딩된 생성자가 여러 개 일 때 중복 초기화 코드를 한 곳에 모으는 용도
    {
        name = "아이폰";
        price = 1800000;
        brand = "사과";
        System.out.println("인스턴스 초기화 블럭 {} 동작함..");
    }
    //정적 초기화 블럭: 클래스가 메모리에 로드될 때 딱 한 번 실행
    //복잡한 로직(반복문, DB 조회 등)으로 static 필드를 초기화 할 때 사용
    static {
        //name = "아이뽄";
        //new를 이용해 객체를 만든 상태가 아니기 때문에,
        //아직 인스턴스가 없어 인스턴스 변수에는 접근 불가
        //brand = "헬지";
        System.out.println("정적 초기화 블럭 static{} 동작함...");
    }

    //기본 생성자
    public Product(){ //기본 생성자는 적지 않아도 자바 컴파일러가 생성해줌
        System.out.println("기본 생성자 public Product() 호출됨...");
    }

    //매개변수 있는 생성자
    public Product(String name, int price, String brand)
    {
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 있는 생성자 public Product(String name, int price, String brand) 호출됨...");
    }

    public String getInformation(){
        return this.name + ", " + this.price + ", " + Product.brand;
    }

}
