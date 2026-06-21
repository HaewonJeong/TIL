package com.ohgiraffers.springdatajpa.Menu.repository;

import com.ohgiraffers.springdatajpa.Menu.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//DB와 연동을 맡는 레포지토리
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /*전달 받은 가격을 초과하는 메뉴 목록*/
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    /*가격 기준 내림차순 정렬까지 추가*/
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);
    //호출만 해도 자동 적용된다.

    /*전달 받은 정렬 기준으로 조회 (페이징)*/
    Page<Menu> findByMenuPriceGreaterThan (Integer menuPrice, Pageable pageable);

}
