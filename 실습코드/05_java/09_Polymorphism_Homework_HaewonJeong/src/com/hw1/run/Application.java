package com.hw1.run;
import com.hw1.controller.LibraryManager;
import com.hw1.view.LibraryMenu;

public class Application {
    public static void main(String[] args) {
        LibraryMenu lm = new LibraryMenu();
        try{
            lm.mainMenu();
        }catch (Exception e){
            System.out.println("♨ 죄송합니다. 에러가 발생하였습니다. 프로그램을 종료합니다.");
            System.out.println(e);
        }
    }
}
