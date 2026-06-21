package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        MethodParameterTest pt = new MethodParameterTest();

        // 기본 자료형 테스트 (값 자체가 복사되어 메서드 안에서 아무리 바꿔도 원본은 불변)
        int num = 20;
        System.out.println("호출 전 main의 num : " + num);
        pt.testPrimitiveType(num);
        System.out.println("호출 후 main의 num : " + num);

        // 배열 테스트 (주소값 복사되어 원본에도 영향을 준다)
        int[] iarr = {1, 2, 3, 4, 5};
        System.out.println("ㅎ출 전: "  + Arrays.toString(iarr));
        pt.testArrayParameter(iarr);
        System.out.println("ㅎ출 후: "  + Arrays.toString(iarr));

        // 객체 테스트 (주소값 복사되어 원본에도 영향을 준다)
        Rectangle r1 = new Rectangle(12.5, 22.5);
        System.out.println("호출 전 너비: " +  r1.getWidth());
        pt.testObjectParameter(r1);
        System.out.println("호출 후 너비: " +  r1.getWidth());

        // 가변인자 테스트
        pt.orderPizza("홍길동");
        pt.orderPizza("유관순", "불고기");
        pt.orderPizza("이순신", "치즈", "페퍼로니", "올리브");
    }
}
