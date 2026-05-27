package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;

    //final로 선언했기때문에 생성자로 초기화
    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems(){
        return items;
    }

}
