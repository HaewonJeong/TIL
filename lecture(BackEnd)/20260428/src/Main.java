//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*문자의 연산*/
        System.out.println('a'+'b'); //내부적으로 숫자 취급을 한다(아스키코드와 유니코드)

        /*문자열의 연산*/
        //문자열과 문자열의 '+' 연산 결과는 문자열 합치기가 된다.
        System.out.println("hello"+"world");

        System.out.println("hello"+123);
        System.out.println("hello"+'a');

        /*논리값의 연산*/
        //모든 연산자 사용 불가
        //System.out.println(true+false); //에러
        //System.out.println(true+1); //에러

        //JDK 안에, JRE안에, JVM가 있다~


    }
}