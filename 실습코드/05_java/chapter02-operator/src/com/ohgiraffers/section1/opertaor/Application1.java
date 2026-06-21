package com.ohgiraffers.section1.opertaor;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.SortedMap;

public class Application1 {
    public static void main(String[] args) {
        /*산술 연산자(+,-,*,/,%)
        * 피연산자들의 연산 방향은 왼쪽에서 오른쪽이다.
        *
        * '%' : 왼쪽의 피연산자를 오른쪽의 피연산자로 나눈 나머지를 반환
        * */

        /*
        * 산술 복합 대입 연산자(+=, -=, *=, /=, %=)
        * 왼쪽의 피연산자에 오른쪽의 피연산자를 산술 한 결과를 왼쪽의 피연산자에 대입
        * */

        int num = 12;
        num += 3; //num = num + 3;
        /* 증감 연산자(++,--)
        * '++' : 1 증가
        * '--' : 1 감소
        * */
        num++; //다른 연산을 먼저 진행하고 마지막에 1증가
        ++num; //피연산자의 값을 먼저 1증가 시킨 후 다른 연산 진행

        int firstNum = 20;
        int result = ++firstNum * 3; //먼저 증가를 시킨 다음에 y값에 대입을 하는 연산

        System.out.println("result: "+result);
        System.out.println(firstNum);

        /*비교 연산자 (==, !=, >, <, >=, <=)
        * 피연산자 사이에서 상대적 크기를 판단하여 참 or 거짓 반환
        * 참고)Java는 '===' 연산자 없음
        * */

        int num1 = 10;
        int num2 = 20;
        System.out.println(num1 == num2); //false(같음을 비교)
        System.out.println(num1 != num2); //true(같지 않음을 비교)

        char ch1 = 'a'; //97
        char ch2 = 'A'; //65

        System.out.println(ch1 >= ch2);

        /*문자열, 논리값 비교*/
        //String pool(문자열 상수 풀)에서 같은 문자열이면 재사용하여 str1과 str2의 주소값은 같다.
        String str1 = "java";
        String str2 = "java";
        System.out.println("str 논리값 비교 "+(str1 == str2));

        //new String()은 항상 새로운 주소의 객체를 생성하여 str3과 str4의 주소값은 다르다.
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("new str 논리값 비교 "+(str3 == str4));
        //이유는 자바에서 == 연산자는 글자 내용이 아니라 '메모리 주소(위치)'가 같은지를 비교하기 때문이다.
        //문자열 값 비교를 하고 싶을때는 .equals()를 사용 한다.

        //문자열 값 비교는 무조건 .equals() 사용 (값 비교)
        System.out.println(str1.equals(str4));
        System.out.println(str3.equals(str4));

        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println(bool1 == bool2);

        /*논리 연산자
        * 1. 논리 연결 연산자
        * - &&(AND) : 두 개의 논리식 모두 참이면 참, "한개"라도 거짓인 경우 거짓 반환
        * - || (OR) : 두 개의 논리식 중 하나라도 참이면 참, 둘 다 거짓인 경우 fales 반환
        *
        * 2. 논리 부정 연산잔
        * - !(NOT) : 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환
        * */
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        System.out.println("결과"+ (a < b && c > d));
        System.out.println("결과"+ (a > b && c > d));

        int num3 = 29;
        System.out.println(num3 >=1 && num3 > 100);

        /*논리식 && 논리식 : 앞의 결과가 fales이면 뒤를 실행 안함
        * 논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함*/

        /*삼항 연산자
        * (조건식)? true일 때 사용할 값 : false일 때 사용 할 값
        * */

        int num5 = 10;
        int num4 = -20;

        String result1 = (num5 > 0) ? "양수다." : "양수가 아니다.";
        System.out.println(result1);

        int num6 = 10;
        int result2 = (false && ++num3 > 0 ) ? num6 : num6;
        //and일때 첫번째 항이 f이므로 뒤항은 실행되지 않음. 결과는 10.
        System.out.println("result2: "+result2);

    }
}
