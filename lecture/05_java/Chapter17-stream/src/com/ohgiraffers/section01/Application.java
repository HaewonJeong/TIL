package com.ohgiraffers.section01;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Application {
    static void main() {
        /* Stream API
        *  컬렉션에 들어있는 여러 데이터를 조건에
        * */

        List<String> names = Arrays.asList("홍길동", "유관순", "신사임당", "장보고","김철수","이성계","이가가","이다다");
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("-----------");

        //Stream 방식 - forEach를 사용한 내부 만족
        names.stream().forEach(name -> System.out.println(name));

        /*이름이 3글자인 사람만 찾아서, "[홍길동]"과 같은 형태로 반환하여 출력*/
        for(String name : names){
            if (name.length() == 3){
                String decorateName = "[" + name + "]";
                System.out.println(decorateName);
            }
        }

        System.out.println("---------------");

        names.stream()
                .filter(name -> name.length() == 3)
                .map(name -> "[" + name + "]")
                .forEach(decoratedName -> System.out.println(decoratedName));

        //결과물(새로운 List) 만들기
        //1)성이 '이' 씨인 사람들 중, 2)알파벳 순서로 정렬 3)새로운 List로 만들어라
        List<String> leeFamily = names.stream() //파이프 라인  시작
                .filter(name -> name.startsWith("이"))
                .sorted(Comparator.reverseOrder())  //가나다 역순으로 정렬
                .collect(Collectors.toList() ); //최종 결과물들을 새로운 List로 수집

        System.out.println(leeFamily);

        //1. count() : 조건에 맞는 요소의 개수 세기
        long leeCount = names.stream()
                .filter(name -> name.startsWith("이"))
                .count(); //반환타입 Long
        System.out.println(leeCount);

        //2. anyMatch() : 조건에 맞는 요소가 하나로 있는지 확인
        boolean hasJang = names.stream()
                .anyMatch(name -> name.equals("장보고")); //하나라도 조건 만족하면 true
        System.out.println(hasJang);

        //3. allMatch() : 모든 요소가 조건을 만족하는지 확인
        boolean isAllThreeLetters = names.stream()
                .allMatch(name -> name.length() == 3);
        System.out.println(isAllThreeLetters);



    }
}
