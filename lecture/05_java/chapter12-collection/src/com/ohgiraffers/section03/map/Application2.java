package com.ohgiraffers.section03.map;

import java.util.Properties;

public class Application2 {

    public static void main(String[] args) {

        /*
        * Properties : HashMap을 상속받은 특수 map
        * key와 value를 모두 반드시 String
        * 주 용도 : 프로그램 설정 정보(DB 연결 정보, 환경설정 값) 관리
        * */

        Properties prop = new Properties();

        //setProperty(String key, String value) - key-value 쌍 형태로 삽입한다. 단 String 형태만 가능하다.
        prop.setProperty("driver", "com.mysql.cj.jdvc.Drive");
        prop.setProperty("url", "jdbc:mysql://localhost/menu");
        prop.setProperty("user","ohgiraffers");
        prop.setProperty("password","ohgiraffers");

        System.out.println(prop);
        //getProperty(String key) - key값으로 꺼낸다.
        String driver = prop.getProperty("driver");
        String user = prop.getProperty("user");
        System.out.println(driver);
        System.out.println(user);
        System.out.println("없는 설정 : " +prop.getProperty("없는 설정키","기본 설정"));




    }
}
