package com.ohgiraffers.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBindingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /*jpql에 파라미터를 바인딩 하는 방법*/
    //1) 이름 기준 파라미터(named parameters) 바인딩 : 다음에 이름 기준 파라미터를 지정한다
    public List<Menu> selectMenuByBindingName(String menuName){
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                                                    .setParameter("menuName", menuName)
                                                    .getResultList();
        return resultMenuList;
    }
    //2)위치 기준 파라미터(positional parameters) 바인딩으로 ? 다음에 위치 값을 주는데 위치 값은 1부터 시작
    public List<Menu> selectMenuByBindingPosition(String menuName){
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        List<Menu> resultMenuList = entityManager.createQuery(jpql, Menu.class)
                                                    .setParameter(1, menuName)//1번 위치에 값을 넣겠다.
                                                    .getResultList();
        return resultMenuList;
    }
}
