package com.ohgiraffer.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        warrior.attack();
        wizard.attack();

        //Player player = new Player(); //추상 클래스는 new로 객체 생성 불가

        Player[] players = new Player[2];
        players[0] = new Warrior();
        players[1] = new Wizard();



    }

}
