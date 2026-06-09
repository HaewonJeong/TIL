package com.ohgiraffers.springmybatis.menu.service;

import com.ohgiraffers.springmybatis.menu.model.dao.MenuMapper;
import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public MenuDTO findMenuByCode(int menuCode) {
        return menuMapper.findMenuByCode(menuCode);
    }

    public List<CategoryDTO> findAllCategory() {
        return  menuMapper.findAllCategory();
    }

    //Transitional : 예외상황없이 호출이 되면 자동 commit.&문제 상황 시 자동  rollback
    //INSERT, UPDATE, DELETE 같은 DML 작업이 성공하면 COMMIT, 실패하면 ROLLBACK 되도록 트랜잭션을 관리하는 어노테이션
    @Transactional
    public MenuDTO registNewMenu(MenuDTO newMenu) {
        menuMapper.registMenu(newMenu);
        return newMenu;
    }

    //DML 작업임으로 @Transactional을 붙여준다.
    //@Transactional 없으면 중간에 예외가 발생했을 때 일부만 반영될 수 있음
    @Transactional
    public boolean modifyMenu(MenuDTO menu) {
        //수정 잘 되면(행 갯수 1이상)이면 true, 아니면 false
        return menuMapper.modifyMenu(menu) > 0;
    }

    //delete도 DML 작업임으로 Transactional을 붙인다.
    @Transactional
    public boolean deleteMenu(int menuCode) {
        return menuMapper.deleteMenu(menuCode) > 0 ;
    }
}
