package com.ohgiraffers.springmybatis.menu.controller;

import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDTO;
import com.ohgiraffers.springmybatis.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") //브라우저에서 다른 주소의 api를 호출 허용 설정
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDTO>> findMenuList() {
        return ResponseEntity.ok(menuService.findAllMenu());

    }

    @GetMapping("menus/{menuCode}")
    public ResponseEntity<MenuDTO> findMenuByCode(@PathVariable int menuCode) {
        MenuDTO menu = menuService.findMenuByCode(menuCode);

        if (menu == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(menu);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> findCategoryList() {

        return ResponseEntity.ok(menuService.findAllCategory());
    }

    @PostMapping("/menus")
    public ResponseEntity<MenuDTO> registMenu(@RequestBody MenuDTO newMenu) {
        MenuDTO registMenu = menuService.registNewMenu(newMenu);
        //CREATED 201 응답 & 등록된 메뉴를 응답 body에 넣어서 반환
        //JSON-getter->DTO-setter->XML
        return ResponseEntity.status(HttpStatus.CREATED).body(registMenu);
    }

    @PutMapping("/menus/{menuCode}")
    public ResponseEntity<Void> modifyMenu(@PathVariable int menuCode, @RequestBody MenuDTO menu) {
        menu.setCode(menuCode); // Xml로 넘어가면, #{ code }는 WHERE절에서 수정 대상을 찾는 값으로 사용
        //body에는 없는 값을 DTO에 setting해줌으로써 XML의 #{code}가 그 값을 사용해서 어떤 메뉴를 수정할지 WHERE절에서 찾도록 하기 위함
        boolean isModified = menuService.modifyMenu(menu);
        if (!isModified) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }

    //실제로는 soft delete인 update를 작성한다.
    @DeleteMapping("/menus/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int menuCode) {
        boolean isDeleted = menuService.deleteMenu(menuCode);

        if (!isDeleted) {
            //실패시 400 반환
            return ResponseEntity.notFound().build();
        }
        //성공 시 204 반환, 어떤 상태 코드를 보낼지는 컨트롤러가 결정
        return ResponseEntity.noContent().build();
    }

}
