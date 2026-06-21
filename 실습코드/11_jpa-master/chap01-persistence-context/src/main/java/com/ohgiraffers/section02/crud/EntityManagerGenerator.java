package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerFactoryGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {

    //최초 실행 시
    // persistence.xml 읽기
    //↓
    //DB 연결
    //↓
    //EntityManagerFactory 생성
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerGenerator() {
    }

    public static EntityManager getInstance() {

        return factory.createEntityManager();
    }

}
