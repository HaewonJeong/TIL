package com.ohgiraffers.section01.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean  //carpBread이름의 객체를 등록. Bean 객체는 Bread이고, 반환 타입은 Product 입니다.
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    //이 빈은 getBean으로 요청할 때 마다 새 객체를 만듣어 반환한다.
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
