package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository //Spring Bean으로 등록
public class ProjectionRepository {

    @PersistenceContext //필드에 Entity Manager 주입
    private EntityManager entityManager;
    /*JPQL 프로젝션*/
    /* 엔티티 프로젝션 */
    public List<Menu> singleEntityProjection(){
        String jpql = "SELECT m FROM Section03Menu m";
        //엔티티 객체 자체를 가져옴.
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    /*스칼라 프로젝션*/
    public List<Object[]> scalarTypeProjection(){
        String jpql = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    /*명령어를 활용한 프로젝션*/
    public List<CategoryInfo> newCommandProjection(){
        String jpql ="SELECT new com.ohgiraffers.jpql.section03.projection.CategoryInfo(c.categoryCode, c.categoryName)"
                + "FROM Section03Category c";
        return entityManager.createQuery(jpql, CategoryInfo.class).getResultList();
    }



}
