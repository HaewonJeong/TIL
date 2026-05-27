package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        //context Confi를 읽어 Bean이 생성
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        //등록한 Bean 이름 확인
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames){
            System.out.println(beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread); //붕어빵
        cart1.addItem(milk); //딸기우유

        System.out.println("** cart1 : "+ cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water); //지리산암반수

        System.out.println("** cart2 : " + cart2.getItems());
        /*Cart1과 Cart2의 출력 값이 같다.
        * 만들어진 빈 객체를 공유 하게 된다.
        *  */

        System.out.println(cart1.hashCode());
        System.out.println(cart2.hashCode());

        /*Bean의 기본 스코프는 Singleton 이다.
        * 하나의 객체를 여러곳에서 공유한다.
        * 그래서 상태를 가지는 객체를 singleton으로 만들면 의도하지 않은 공유 문제가 생길 수 있음*/



    }
}
