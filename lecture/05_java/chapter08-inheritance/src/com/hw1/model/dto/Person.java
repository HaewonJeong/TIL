package com.hw1.model.dto;
/*
+ (Public): 클래스 외부, 내부 어디서든 접근 가능.
# (Protected): 동일 패키지 혹은 상속받은 자식 클래스에서 접근 가능.
~ (Package/Default): 명시하지 않을 경우, 동일 패키지 내에서만 접근 가능.
- (Private): 해당 클래스 내부에서만 접근 가능.
* */
public class Person {
    protected String name;
    private int age;
    private double height;
    private double weight;

    public Person() {
    }

    public Person(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    public String information(){
        return "나이: "+age+", 키: "+height+", 몸무게: "+weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
