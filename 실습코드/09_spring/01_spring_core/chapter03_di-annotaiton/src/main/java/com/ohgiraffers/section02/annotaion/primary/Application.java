package com.ohgiraffers.section02.annotaion.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("beanNames:");
        for(String beanName : beanNames){
            System.out.println(beanName);
        }
        System.out.print("pokemonService.pokemonAttack();");
        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);
        pokemonService.pokemonAttack();


    }

}
