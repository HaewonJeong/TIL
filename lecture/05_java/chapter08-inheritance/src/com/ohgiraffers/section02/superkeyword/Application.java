package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product.getInformation());

        Computer computer = new Computer("S-0123", "삼성","갤럭시", 200000, new Date(), "512", 12);
        System.out.println(computer.getInformation());

        SmartPhones smartphone = new SmartPhones("S-0123", "삼성","갤럭시", 200000, new Date(),"갤럭시");
        System.out.println(smartphone.getInformation());
    }
}
