package com.ohgiraffers.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> usingPagingAPI(int offset, int limit){
        String jpql = "SELECT m FROM Section04Menu m ORDER BY m.menuCode DESC"; //내림차순 정렬
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class)
                .setFirstResult(offset)     // 조회를 시작할 위치 예시)10개를 뛰어 넘어라
                .setMaxResults(limit);      // 조회할 데이터의 개수 예시)5개만 출력해라
        List<Menu> pagingMenuList = query.getResultList();
        return pagingMenuList;
    }

}