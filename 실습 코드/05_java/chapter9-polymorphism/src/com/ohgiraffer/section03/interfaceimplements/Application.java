package com.ohgiraffer.section03.interfaceimplements;

public class Application {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        Mouse mouse = new Mouse();
        Computer computer = new Computer();

        computer.connectDevice(keyboard);
        computer.connectDevice(mouse);
    }
}
