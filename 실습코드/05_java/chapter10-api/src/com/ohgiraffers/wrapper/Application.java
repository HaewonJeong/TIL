package com.ohgiraffers.wrapper;

public class Application {

    public static void main(String[] args) {

        String heightStr = "170.5";
        String weightStr = "68.2";

        System.out.println(heightStr+weightStr);

        //파싱 : 문자열 데이터를 실제 해당 타입의 기본 자료형으로 변환
        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);

        System.out.println(weight / (height / 100) * (height / 100));

        //bmi 지수 계산
        System.out.println(weight / (height / 100) * (height / 100));

        //int 20을 Interger 객체로 포장(Boxing)
        Integer age = 10; //Integer.valueOf(20) 오토 박싱
        //Integer age = new Integer(20); 예전 코드. 에러남.

        int unboxedAge = age; //age.intValue() 오토 언박싱

        //주의사항! 래퍼 클래스는 '객체'이기 때문에, 값 비교를 할 때 == 연산자를 쓰면 위험
        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println(num3 == num4);
        /*
        * 127일 때: Integer num = 127;이라고 쓰면, 자바는 미리 만들어둔 캐시 저장소에서 127이라는 객체를 꺼내서 연결해 줍니다.
        * num3와 num4가 같은 객체 주소를 가리키게 되니 == 결과가 true가 나옵니다.
        * 128일 때: 이 숫자는 캐시 범위를 벗어납니다. 그래서 자바는 new Integer(128)을 실행하듯 매번 새로운 객체를 힙 메모리에 찍어냅니다. 주소가 서로 다르니 == 결과가 false가 되는 것
        * */

        //래퍼 클래스 객체의 값이 같은지 비교할 때는 반드시 equals 사용!
        System.out.println(num3.equals(num4));

        /*
        * 숫자를 다시 문자열로!
        * 계산이 끝난 데이터를 화면에 표시하거나, 저장하려면 다시 문자열로 반환해야 한다.
        * 1. String.valueOf(값)
        * 2. 값 + "" (간편한 방법)
        * */
        double bmi = weight / ((height / 100) * (height / 100));

        String bmiStr1 = String.valueOf(bmi);
        String bmiStr2 = bmi + "";

        System.out.println("당신의 BMI는 "+ bmiStr1 + "입니다.");




    }


}
