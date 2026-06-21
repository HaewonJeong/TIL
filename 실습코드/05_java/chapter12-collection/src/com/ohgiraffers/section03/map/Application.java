package com.ohgiraffers.section03.map;

import java.awt.color.ICC_ColorSpace;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        /*Json 데이터 구조 Key-value 와 비슷한 자료구조*/

        /*
        * Map 인터페이스
        * - key와 value를 하나의 쌍(Entry)으로 묶어서 관리
        * - Key는 중복 저장을 허용하지 않는다.
        * - value는 중복 저장을 허용한다.
        * */

        Map<String, String> hmap = new HashMap<>();

        //put(key, value) : 저장
        hmap.put("one", "java");
        hmap.put("two", "jdbc");
        hmap.put("three", "mysql");
        hmap.put("two", "html"); //key 중복 -> 기존의 벨류값을 덮어 씀
        hmap.put("four", "java"); //value 중복은 허용

        System.out.println(hmap);
        System.out.println(hmap.size());

        //get(key) : 특정 키로 값 조회
        System.out.println(hmap.get("one"));

        //get(key) : 존재하지 않는 key로 get() 하면 null값 반환
        System.out.println(hmap.get("없는 키"));

        //containsKey(key) :실무에서의 방어 코드
        if(hmap.containsKey("three")){
            System.out.println("three 키가 존재합니다.");
        }
        //getOrDefault("없는 키", "기본값") : 키 값이 없다면 null이 아니고 전달한 기본값을 반환
        System.out.println(hmap.getOrDefault("없는 키", "기본값"));

        //remove(key) : 키-값 쌍 삭제
        hmap.remove("four");
        System.out.println(hmap);

        //Map 순회 방법
        //1. KeySet() - 키 전체를 Set으로 받아서 순회
//         Set<String> keys = hmap.keySet();
//         for(String key = keys) {
//             System.out.println(hmap.get(key));
//         }
//
//         //3. etrySet() - 키 + 쌍(Entry)을 한 번에 Map.Entry 객체로 꺼내 온다.
//        Set< Map.Entry<String, String> > entrySet = hmap.entrySet();
//        for(Map.Entry<String String> entry : entrySet){
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

    }
}
