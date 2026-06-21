package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectInnerJoin(){
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }

    //외부 조인
    public List<Object[]> selectByOuterJoin(){
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c"
                    + " ORDER BY m.category.categoryCode";
        List<Object[]> menuList = entityManager.createQuery(jpql).getResultList();
        return menuList;
    }

    //컬렉션 타입의 연관 필드를 기준으로 JOIN
    public List<Object[]> selectByCollectJoin(){
        String jpql = "SELECT c.categoryName, m.menuName FROM Section06Category c LEFT JOIN c.menuList m";
        List<Object[]> categoryList = entityManager.createQuery(jpql).getResultList();
        return categoryList;
    }

    //패치 조인 - N+1 성능 문제 해결
    public List<Menu> selectByFetchJoin(){
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }

}
