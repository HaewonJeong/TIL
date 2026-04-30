package com.ohgiraffers.section2.package_and_import;
import com.ohgiraffers.section01.method.Calculator;
import static com.ohgiraffers.section01.method.Calculator.maxNumberOf;

public class Applicaton {
    public static void main(String[] args) {

        //클래스를 사용하기 위해 패키지 경로를 적으면 너무 김
        Calculator calc = new Calculator();
        int min = calc.minNumberOf(20,10);
        System.out.println(min);

        int max = Calculator.maxNumberOf(30,20);
        System.out.println(max);

        //import 사용 (non-static)
        Calculator cal2 = new Calculator(); //패키지명 생략 가능
        int min2 = calc.minNumberOf(2,5);

        //static
        int max2 = Calculator.maxNumberOf(30, 20);
        System.out.println(max2);

        //이 기능이 어디에서 온건지 한눈에 파악하기 어려워 권장하지는 않음
        int max3 = maxNumberOf(40, 10); //static import 해서 클래스명 없이 메소드 이름만으로 호출 가능


    }

}
