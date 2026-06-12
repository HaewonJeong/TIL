package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    //entityManager 사용 가능
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public String findNameById(String memberId){
        //Table 명이 아니라 Entity 명을 기준으로 들어간다.
        //별칭이 필수
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = ' " + memberId + " ' ";
        //쿼리를 실행해 반환 받아오는 결과 리턴
        return entityManager.createQuery(jpql, String.class).getSingleResult();

    }
}
