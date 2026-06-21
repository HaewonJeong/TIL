package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

//양방향 참조 관계
@Repository
public class BiDirectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //Menu를 menuCode로  찾아와라.
    public Menu findMenu(int menuCode){
        return entityManager.find(Menu.class, menuCode);
    }

    //Category를 categoryCode로 찾아와라.
    public Category findCategory(int categoryCode){
        return entityManager.find(Category.class, categoryCode);
    }

}
