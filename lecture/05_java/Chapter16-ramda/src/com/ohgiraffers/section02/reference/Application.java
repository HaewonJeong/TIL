package com.ohgiraffers.section02.reference;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {

    static void main() {

        //1. 정적 메서드 참조 (클래스명::메서드명)
        //숫자 형태의 문자열을 정수로 바꾸는 Integer.parseInt() 같은 static 메서드를 부를 때 씁니다.
        Function<String, Integer> parseInt = str -> Integer.parseInt(str);

         //2. 인스턴스 메서드 참조 (객체명::메서드명)
        //이미 만들어진 특정 객체(예: System.out)의 기능을 쓸 때 씁니다
        Function<String, Integer> ref_parseInt = Integer::parseInt;

        System.out.println(parseInt.apply("123"));
        System.out.println(ref_parseInt.apply("123") * 2);

        //2. 특정 객체의 인스턴드 메서드 참조
        //객체 참조 변수 :: 인스턴스 메서드 이름
        Consumer<String> println = str -> System.out.println(str);
        Consumer<String> ref_println = System.out::println;

        println.accept("hello");
        ref_println.accept("hello lambda!!");

        //3. forEach와 메서드 참조
        List<String> subjects = Arrays.asList("java", "mysql","jdbc","css");
        //subject -> System.out.println(subject) 받은 값을 그대로 넘기기만 한다면 메소드 참조로 줄일 수 있음
        subjects.forEach(System.out::println); //메소드 참조!!

        //불특정 다수 객체의 인스턴스 메소드 참조
        //3. 임의 객체의 인스턴스 메서드 참조 (클래스명::메서드명)
        //이게 제일 헷갈리실 텐데, "첫 번째로 들어온 놈이 주어(주체), 두 번째가 대상"이 되는 방식입니다.
        //람다: (s1, s2) -> s1.equals(s2) (s1한테 s2랑 같은지 물어봐)
        //참조: String::equals (String끼리 비교하는 기능을 쓸게)
        //원리: 자바가 내부적으로 "아, 첫 번째 인자를 호출 대상으로 쓰고, 두 번째 인자를 파라미터로 쓰라는 거구나!"라고 알아듣습니다.
        BiFunction<String, String, Boolean> equals = (s1, s2) -> s1.equals(s2);

        //클래스 이름:: 인스턴스 메소드 이름
        //첫 번째 String이 주어가 되고, 두 번째 String이 비교대상이 된다.
        BiFunction<String, String, Boolean> ref_equals = String::equals;

        System.out.println(equals.apply("hello", "hello"));
        System.out.println(ref_equals.apply("hello","world"));

        //4. 생성자 참조 (클래스명::new)
        //객체를 만드는 람다식을 줄이는 문법
        //단순히 객체를 새로 찍어낼 때 씁니다.
        //Supplier<Account> : 아무 값도 받지 않고 Account 객체를 공급
        Supplier<Account> newAccount = Account::new;
        System.out.println(newAccount.get()); //.get(): 기본 생성자 실행

        Function<String, Account> newAccountWithName = Account::new;
        System.out.println(newAccountWithName.apply("홍길동"));

//        //① 매개변수가 없는 기본 생성자 (Supplier)
//        입력값은 없고 결과값(객체)만 내뱉을 때 사용합니다.
//        1. 람다식 표현
//        Supplier<Account> s1 = () -> new Account();
//
//        // 2. 생성자 참조 표현 (훨씬 간결함)
//        Supplier<Account> s2 = Account::new;
//
//        // 실제 객체 생성 시점
//        Account acc = s2.get(); // 이때 비로소 new Account()가 실행됨

        //두개의 파라미터를 받아서 1개의 값을 반환할때 - Bi
        BiFunction<String, Integer, Account> newAccountFull = Account::new;
        System.out.println(newAccountFull.apply("유관순",10000));



    }
}
