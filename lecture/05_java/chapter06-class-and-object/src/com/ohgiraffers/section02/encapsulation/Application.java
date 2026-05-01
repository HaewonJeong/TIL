package com.ohgiraffers.section02.encapsulation;

public class Application {
    static void main() {
        Children child1 = new Children();
        //child1.age = 5; //호출 불가
        child1.setAge(-5);
        //System.out.println(child1.age); //호출 불가
        System.out.println(child1.getAge());

    }
}
