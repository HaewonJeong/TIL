package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration //스프링 설정 클래스
public class ContextConfiguration {

    @Bean  //carpBread이름의 객체를 등록. Bean 객체는 Bread이고, 반환 타입은 Product 입니다.
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean  //carpBread이름의 객체를 등록. Bean 객체는 Bread이고, 반환 타입은 Product 입니다.
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean  //carpBread이름의 객체를 등록. Bean 객체는 Bread이고, 반환 타입은 Product 입니다.
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean  //carpBread이름의 객체를 등록. Bean 객체는 Bread이고, 반환 타입은 Product 입니다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

}
