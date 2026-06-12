package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){
        //JPQL은 반드시 별칭 필수
        //SQL과 달리 JPQL은 테이블이 아닌 엔티티 객체를 대상으로 쿼리하므로, 조회하려는 객체를 식별하기 위해 별칭이 반드시 필요
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        //JPQL을 실행하려면 쿼리 객체를 만들어야한다. 반환한 타입을 명확하게 지정할 수 있으면 TypedQuery로 쿼리 객체 생성
        //EntityManager 객체에서 createQuery() 메서드를 호출하면 쿼리가 생성됩니다.
        //em.createQuery 메서드를 호출할 때 두 번째 인자로 어떤 형태로 처리할지 엔티티 클래스를 넘겨줍니다.
        //getSingleResult()를 실행하면 쿼리 실행 결과가 반환 된다.
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();

        return resultMenuName;
    }

    public List<Menu> selectMultiRowByTypedQuery(){
        //JPQL은 반드시 별칭 필수
        String jpql = "SELECT m.menuName FROM Section01Menu as m ";
        //반환 받는 TypedQuery의 제네릭을 일치 시켜준다.
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> resultMenuList = query.getResultList();

        return resultMenuList;
    }

    public List<Integer> selectUsingDistinct(){
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryList = query.getResultList();

        return resultCategoryList;
    }

    /*11, 12 카테고리 코드를 가진 메뉴 목록 조회 (IN 연산자 사용)*/
    public List<Integer> selectUsingIn(){
        String jpql = "SELECT m FROM Section01Menu m WHERE m.categoryCode IN (11, 12)";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryList = query.getResultList();
        return resultCategoryList;
    }

    /*"마늘" 이라는 문자열이 메뉴명에 포함되는 메뉴 목록 조회*/
    public List<String> selectUsingLike(){
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName LIKE '%마늘%'";
        TypedQuery<String> query =  entityManager.createQuery(jpql, String.class);
        List<String> resultCategoryList = query.getResultList();
        return resultCategoryList;
    }

}
