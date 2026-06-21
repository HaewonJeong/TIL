package com.ohgiraffers.section01.string;

public class Application {

    public static void main(String[] args) {

        String rawData = " [PROD-001] Apple iPhone 17 Pro | a17 bionic";
        System.out.println(rawData);

        //trim() : 앞 뒤 공백 제거
        String trimmedData = rawData.trim();
        System.out.println(trimmedData);

        //toUpperCase(): 대문자 변환(검색/비교 시 대소문자 통일)
        String upperData = trimmedData.toUpperCase();
        System.out.println("uuperData" + upperData);

        //indexOf() : 특정 문자의 인덱스 찾기
        int codeStart = upperData.indexOf('[') + 1;
        int codeEnd = upperData.indexOf(']');
        int nameEnd = upperData.indexOf('|');

        //존재하지 않으면 -1 반환
        int name = upperData.indexOf('*');
        System.out.println("name = "+ name);

        if(codeStart == -1 || codeEnd == -1 ){
            System.out.println("데이터 형식이 올바르지 않습니다.");
            return;
        }

        //substring(start, end) : 특정 구간 잘라내기
        String productCode = upperData.substring(codeStart, codeEnd);
        System.out.println("productCode = "+ productCode);
        String productName = upperData.substring(codeEnd + 1, nameEnd);
        System.out.println("productName = "+productName);

        //replace(): 특정 문자열 치환
        String replaced = productName.replace("APPLE IPHONE 17 PRO", "GALAXY S26 ULTRA");
        System.out.println("replaced"+replaced);

        // '==' vs equals
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2 비교하기 "+ (str1 == str2) );
        System.out.println(str1 == str2); //true
        System.out.println(str3 == str4); //false
        System.out.println(str3.equals(str4));

        //불변성 확인
        str2 += "mysql";
        System.out.println(str1 == str2);

        //split(): 문자열 분리하기
        String emp = "100/홍길동/서울/영업부";
        String[] empArr = emp.split("/");
        for(String info : empArr){
            System.out.println(info.isEmpty() ? "정보 없음" : info);
        }

        //이스케이프 문자
        System.out.println("안녕하세요.\n 저는 개발자입니다.");
        System.out.println("주특기는 \t'java'와 \"Spring\"입니다.");
        System.out.println("파일 경로: C:\\Users\\student");


    }

}
