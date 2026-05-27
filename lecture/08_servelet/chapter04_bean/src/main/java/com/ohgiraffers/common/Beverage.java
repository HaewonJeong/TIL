package com.ohgiraffers.common;

public class Beverage extends Product{

    private int capaticy;

    public Beverage(int capaticy) {
        this.capaticy = capaticy;
    }

    public Beverage(String name, int price, int capaticy) {
        super(name, price);
        this.capaticy = capaticy;
    }

    public int getCapaticy() {
        return capaticy;
    }

    public void setCapaticy(int capaticy) {
        this.capaticy = capaticy;
    }

    @Override
    public String toString() {
        return super.toString()+"Bevergage{" +
                "capaticy=" + capaticy +
                '}';
    }
}
