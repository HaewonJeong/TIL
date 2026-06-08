package com.ohgiraffers.springmybatis.menu.model.dao;

import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    //SQL문이 실행된다. MyBatis 의존성을 설정했기때문에 sqlSession~을 안해도 된다.
    List<MenuDTO> findAllMenu();

    MenuDTO findMenuByCode(@Param("menuCode") int menuCode);

    List<CategoryDTO> findAllCategory();
}
