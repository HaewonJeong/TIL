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

    //영향을 받은 행의 갯수 반환
    int registMenu(MenuDTO newMenu);

    int modifyMenu(MenuDTO menu);

    //Mapper XML에서 #{ menuCode }라는 이름으로 사용할 수 있도록 매개변수에 이름을 지정한다.
    //실제로는 soft delete인 update를 작성한다.
    int deleteMenu(@Param("menuCode") int menuCode);

}
