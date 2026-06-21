package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /*  특정 메뉴 코드로 메뉴 조회 */
    public Menu findMenuByMenuCode(int menuCode) {
        //entity Manager를 요청때마다 새로 생성한다.
        entityManager = EntityManagerGenerator.getInstance();
        // find(엔티티타입, PK)
        // Menu 엔티티 중에서 PK(menuCode)가 4인 행을 찾아라
        return entityManager.find(Menu.class, menuCode);
    }

    /*새로운 메뉴 저장*/
    public Long saveAndReturnAllCount(Menu newMenu) {
        //Entity Manager를 요청때마다 새로 생성한다.
        entityManager = EntityManagerGenerator.getInstance();
        //저장(persist)하기전에 Transaction 객체를 가져온다.
        EntityTransaction entityTransaction = entityManager.getTransaction();
        //Transaction을 시작
        entityTransaction.begin();
        // 영속성 컨텍스트에 엔티티를 저장(Persist)한다.
        entityManager.persist(newMenu);
        // 트랜잭션 커밋
        // 이 시점에 INSERT SQL이 실행되어 DB에 반영된다.
        entityTransaction.commit();

        return getCount(entityManager);
    }


    /*메뉴의 총 갯수 조회*/
    private Long getCount(EntityManager entityManager) {
        /*JPQL 문법 -> 나중에 별도의 챕터에서 다룰 예정*/
        //Mybatis는 SQL문을 직접 썼지만 JPA는 JPQL을 사용
        //FROM절 뒤에 테이블이 아닌 엔티티명이 옴
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /*메뉴 이름 수정하기*/
    public Menu modifyMenuName(int menuCode, String MenuName) {
        //EntityManager를 새로 생성한다.
        entityManager = EntityManagerGenerator.getInstance();
        //PK에 해당하는 메뉴 entity를 하나 찾아와 영속성 컨텍스트에 보관
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        //변화를 감지하기 위해 Transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //찾아온 메뉴의 이름을 내 메뉴 이름으로 수정
        foundMenu.setMenuName(MenuName);
        //트랜잭션 commit
        transaction.commit();

        return foundMenu;
    }

    public Long removeAndReturnAllCount(int menuCode){
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(foundMenu);

        transaction.commit();

        return getCount(entityManager);
    }

}