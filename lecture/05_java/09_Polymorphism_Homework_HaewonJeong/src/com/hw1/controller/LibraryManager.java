package com.hw1.controller; //데이터를 처리하는 역할(Controller)
import com.hw1.model.dto.AniBook;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.CookBook;
import com.hw1.model.dto.Member;

public class LibraryManager {
    private Member mem = new Member(null);
    private Book[] bList = new Book[5];

    public LibraryManager() {
    }

    //*인스턴스 초기화 블럭 : 객체가 생성될 때 마다 실행되는 초기화 블럭으로 여러 생성자들 중에서 공통된 초기화 변수가 존재할 때 사용
    {
        bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
        bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
        bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
        bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
        bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
    }

    public void insertMember(Member mem){
        // 전달받은 mem 주소 값을 해당 회원 레퍼런스(mem)에 대입
        this.mem = mem;
        //System.out.println("insertMember/ this.mem: "+this.mem);
    };
    public Member myInfo(){
        // 회원 레퍼런스(mem) 주소 값 리턴
        //System.out.println("myInfo/ mem: "+mem);
        return mem;
    }
    public Book[] selectAll(){
        // 도서 목록 레퍼런스(bList) 주소 값 리턴
        return bList;
    }
    public Book[] searchBook(String keyword){
        // 검색 결과를 담아줄 새로운 Book 객체 배열 생성
        // 검색 결과 도서 목록이 최대 5개일 수 있으니 임의로 크기 5 할당
        Book[] searchbList = new Book[5];
        // for문을 이용하여 bList 도서 목록들의 도서명과 전달받은 keyword 비교
        // 전달받은 keyword를 포함하고 있으면  HINT : String 클래스의 contains() 참고
        // 검색결과의 도서목록에 담기  HINT : count 이용
        int cnt = 0;
        for(int i = 0 ; i < searchbList.length; i++){
            if( bList[i].getTitle().contains( keyword )){
                searchbList[cnt] = bList[i];
                cnt++;
            }
        }
        // 해당 검색결과의 도서목록 주소 값 리턴
        return searchbList;
    }
    public int rentBook(int index){
        int result = 0;
        Book book = bList[index];
        System.out.println("● 대여 예정 책 : "+book);
        if(book instanceof AniBook)
        {
            if(  mem.getAge() <= ((AniBook)book).getAccessAge()){
                result = 1;
            }
        }
        if(book instanceof CookBook)
        {
            if ( ((CookBook)book).isCoupon() ){
                mem.setCouponCount(mem.getCouponCount()+1);
                result = 2;
            }
        }

        return result;
    }
}
