package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryGenerator {

    private static EntityManagerFactory factory
        = Persistence.createEntityManagerFactory("jpatest");

    //싱글톤 형태로 생성
    //외부에서 new 키워드로 EntityManagerFactoryGenerator를 생성 할 수 없게 막는다.
    private EntityManagerFactoryGenerator() {}

        public static EntityManagerFactory getInstance(){
            return factory;
        }

}
