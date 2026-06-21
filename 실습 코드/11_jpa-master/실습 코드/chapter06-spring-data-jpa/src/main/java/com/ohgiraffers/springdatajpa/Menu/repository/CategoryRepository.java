package com.ohgiraffers.springdatajpa.Menu.repository;

import com.ohgiraffers.springdatajpa.Menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //기본 작성 시 에러 발생. Native Query 작성으로 알아들음
    //@Query(value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code")

    //@Query(value = "SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code", nativeQuery = true)

    @Query("SELECT c FROM Category c ORDER BY c.categoryCode") //JPQL 작성 방식

    @NativeQuery("SELECT category_code, category_name, ref_category_code FROM tbl_category ORDER BY category_code")

    List<Category> findAllCategory();

}
