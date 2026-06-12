package com.ohgiraffers.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimpleJPQLRepositoryTests {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일 컬럼 조회 테스트")
    @Test
    void testSelectedSingleMenuByTypedQuery(){
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("TypedQuery를 이용한 다중행 조회 테스트")
    @Test
    void testSelectedMultiRowByTypedQuery(){
        List<Menu> menuList = simpleJPQLRepository.selectMultiRowByTypedQuery();
        System.out.println("menuList: " + menuList);
        assertNotNull(menuList);
    }

    @DisplayName("DISTINCT 연산자 사용 조회 테스트")
    @Test
    void testSelectUsingDistinct(){
        List<Integer> categoryList = simpleJPQLRepository.selectUsingDistinct();
        System.out.println("categoryList: " + categoryList);
        assertNotNull(categoryList);

    }

    @DisplayName("11, 12 카테고리 코드를 가진 메뉴 목록 조회 (IN 연산자 사용)")
    @Test
    void testSelectUsingIn(){
        List<Integer> categoryList = simpleJPQLRepository.selectUsingIn();
        System.out.println("categoryList: " + categoryList);
        assertNotNull(categoryList);
    }

    @DisplayName("\"마늘\" 이라는 문자열이 메뉴명에 포함되는 메뉴 목록 조회")
    @Test
    void selectUsingLike(){
        List<String> categoryList = simpleJPQLRepository.selectUsingLike();
        System.out.println("categoryList: " + categoryList);
        assertNotNull(categoryList);
    }

}
