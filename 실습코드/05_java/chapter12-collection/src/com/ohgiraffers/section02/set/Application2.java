package com.ohgiraffers.section02.set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {

        //HashSet : 순서 없음 + 중복 불가
        Set<String> hset = new HashSet<>();
        hset.add("java");
        hset.add("mysql");
        hset.add("jdbc");
        hset.add("java");
        System.out.println("hset = " + hset);

        //LinkedHashSet : 중복 불가 + 순서 유지
        Set<String> lhset = new LinkedHashSet<>();
        lhset.add("mysql");
        hset.add("java");
        lhset.add("jdbc");
        lhset.add("java");
        System.out.println("lhset = " + lhset);


    }
}
