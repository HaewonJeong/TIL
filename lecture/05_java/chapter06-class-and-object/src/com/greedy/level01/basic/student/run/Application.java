package com.greedy.level01.basic.student.run;
import com.greedy.level01.basic.student.model.dto.StudentDTO;
import java.util.Scanner;

/*최대 10명의 학생 정보를 기록할 수 있게
객체 배열을 할당하고
반복문을 사용하여 키보드로 학생 정보를
입력 받도록 구현
3명의 학생 정보를 입력 받아, 각 객체에
저장, 현재 기록된 학생들의 정보와 각 학
생의 평균 점수를 출력
*/
public class Application {
    public static void main(String[] args) {

        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO[] studentDTOS = new StudentDTO[10];
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        while(cnt < 10){
            //안하면 null point exception 발생
            studentDTOS[cnt] = new StudentDTO();
            System.out.print("학년 : ");
            studentDTOS[cnt].setGrade( sc.nextInt() );
            System.out.print("반 : ");
            studentDTOS[cnt].setClassroom( sc.nextInt() );
            System.out.print("이름 : ");
            studentDTOS[cnt].setName( sc.next() );
            System.out.print("국어점수 : ");
            studentDTOS[cnt].setKor( sc.nextInt() );
            System.out.print("영어점수 : ");
            studentDTOS[cnt].setEng( sc.nextInt() );
            System.out.print("수학점수 : ");
            studentDTOS[cnt].setMath( sc.nextInt() );

            System.out.print("계속 추가할 겁니까 ? (y/n)");
            String iskeepAdd;
            iskeepAdd = sc.next();
            if(iskeepAdd.equals("n")) {
                break;
            }else {
                cnt++;
            }
        }
        // 한 명씩 추가 될 때마다 카운트함
        // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
        // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        // 학생들의 정보를 모두 출력 (평균 포함)
        for(int i = 0; i <= cnt; i++){
            //학년=1, 반=5, 이름=홍길동, 국어=40, 영어=60, 수학=70, 평균=56
            System.out.println("학년="+studentDTOS[i].getGrade()
                             +", 반="+studentDTOS[i].getClassroom()
                             +", 이름="+studentDTOS[i].getClassroom()
                    +", 국어="+studentDTOS[i].getKor()
                    +", 영어="+studentDTOS[i].getEng()
                    +", 수학="+studentDTOS[i].getMath()
                    +", 평균="+( (studentDTOS[i].getKor()+studentDTOS[i].getEng()+studentDTOS[i].getMath())/3)
            );
        }

    }
}
