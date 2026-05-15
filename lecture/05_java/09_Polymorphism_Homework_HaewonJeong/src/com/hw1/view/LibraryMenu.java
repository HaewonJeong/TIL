dpackage com.hw1.view; //화면을 보여주는 역할(View)
import com.hw1.controller.LibraryManager;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.Member;
import java.util.Scanner;

public class LibraryMenu {
    LibraryManager lm = new LibraryManager();
    Scanner sc = new Scanner(System.in);
    Book[] searchBook;
    int cnt = 0;
    int keyboard = 0;

    public void mainMenu() {
//        // 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
        System.out.print("☞ 이름: ");
        String name = sc.nextLine();
        System.out.print("☞ 나이: ");
        int age = sc.nextInt();
        System.out.print("☞ 성별: ");
        char sex = sc.next().charAt(0);
        Member member = new Member(name,age,sex);

//       // LibraryManager의 insertMember() 메소드에 전달
        lm.insertMember(member);
//        ==== 메뉴 ==== // 무한 반복 실행
//        1. 마이페이지 // LibraryManager의 myInfo() 호출하여 출력
//        2. 도서 전체 조회 // LibraryMenu의 selectAll() 호출
//        3. 도서 검색 // LibraryMenu의 searchBook() 호출
//        4. 도서 대여하기 // LibraryMenu의 rentBook() 호출
//        0. 프로그램 종료하기
        while(true){
            System.out.print("☞ 1. 마이페이지/2. 도서 전체 조회/3. 도서 검색/4. 도서 대여하기/0. 프로그램 종료하기"
                    +"\n☞ 0~4 사이 숫자를 입력 해주세요. :");
            keyboard = sc.nextInt();
            switch (keyboard){
                case 1 :
                        //System.out.println(객체)를 하면 자바는 내부적으로 그 객체의 toString()을 호출
                        System.out.println("● 회원 정보 : "+lm.myInfo());
                        break;
                case 2 :
                        selectAll();
                        break;
                case 3 :
                        searchBook();
                        break;
                case 4 :
                        rentBook();
                        break;
                case 0 :
                        System.out.println("● 프로그램을 종료합니다.");
                        return;
                default :
                        System.out.println("올바른 번호를 입력하세요.");

            }
        }
    }

    public void selectAll(){
        for(int i=0; i<lm.selectAll().length; i++){
            System.out.println("● "+i+"번 도서 : "+lm.selectAll()[i]);
        }
    }
    public void searchBook(){
        System.out.print("☞ 검색할 책 키워드 입력 : ");
        String keyword = sc.next();
        searchBook = lm.searchBook(keyword);
        cnt = 0;
        for(int i=0; i<searchBook.length; i++){
            if(searchBook[i] != null) {
                cnt++;
            }
        }
        System.out.println("● 검색 결과 총 "+cnt+"권의 책을 찾았습니다.");
        for(int j=0; j<searchBook.length; j++){
            if(searchBook[j] != null) {
                System.out.println("● "+(j+1) + "번 도서 : " + searchBook[j]);
            }
        }
    }
    public void rentBook(){
        // 도서대여를 위해 도서번호를 알아야된다.  selectAll() 메소드 호출
        searchBook = lm.selectAll();
        System.out.print("☞ 대여할 책 대여 번호 입력: ");
        keyboard = sc.nextInt();
        switch (lm.rentBook(keyboard))
        {
            case 0 :
                System.out.println("● 성공적으로 대여되었습니다.");
                break;
            case 1 :
                System.out.println("● 나이 제한으로 대여 불가능입니다.");
                break;
            case 2 :
                System.out.println("● 성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다." +
                        "\n● 마이페이지를 통해 확인하세요. :)");
                break;
        }
    }

}
