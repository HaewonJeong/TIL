package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    //조회하고 싶은 메뉴 코드를 받아서 조회 (code = 5면, menu_code = 5를 조회하겠다는 뜻)
    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code){
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu){
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu){
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code){
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }
}
