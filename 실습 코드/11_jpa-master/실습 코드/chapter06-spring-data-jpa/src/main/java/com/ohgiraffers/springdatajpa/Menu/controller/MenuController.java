package com.ohgiraffers.springdatajpa.Menu.controller;

import com.ohgiraffers.springdatajpa.Menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.Menu.dto.MenuRequestDTO;
import com.ohgiraffers.springdatajpa.Menu.dto.MenuResponseDTO;
import com.ohgiraffers.springdatajpa.Menu.entity.Menu;
import com.ohgiraffers.springdatajpa.Menu.repository.MenuRepository;
import com.ohgiraffers.springdatajpa.Menu.service.MenuService;
import com.sun.net.httpserver.HttpsServer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final MenuRepository menuRepository;

    @GetMapping("/{menuCode}")
    public ResponseEntity<MenuResponseDTO> findMenuByCode(@PathVariable int menuCode){
        MenuResponseDTO resultMenu = menuService.findMenuByMenuCode(menuCode);

        return ResponseEntity.ok(resultMenu);

    }

    // 데이터를 페이지로 끊어서 가져온다.
    // GET /api/v1/menus?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<MenuResponseDTO>> findMenuList(
            @PageableDefault(size=30, sort = "menuCode") Pageable pageable){

        Page<MenuResponseDTO> menuList = menuService.findMenuList(pageable);

        return ResponseEntity.ok(menuList);
    }

    /*메뉴 가격으로 메뉴 목록 조회*/
//    @GetMapping("/search")
//    public ResponseEntity<List<MenuResponseDTO>> findByMenuPrice(@RequestParam Integer menuPrice){
//        List<MenuResponseDTO> menuList = menuService.findByMenuPrice(menuPrice);
//
//        return ResponseEntity.ok(menuList);
//    }

    /*메뉴 가격으로 메뉴 목록 조회(페이징 적용)*/
    @GetMapping("/search")
    public ResponseEntity<Page<MenuResponseDTO>> findByMenuPrice(@RequestParam Integer menuPrice,
                                                                 Pageable pageable){
        Page<MenuResponseDTO> menuList = menuService.findByMenuPriceSort(menuPrice, pageable);

        return ResponseEntity.ok(menuList);
    }

    /*모든 카테고리 목록 조회*/
    @GetMapping("/categories")
    public ResponseEntity<List <CategoryDTO>> findCategoryList(){
        List<CategoryDTO> categoryList = menuService.findAllCategory();

        return ResponseEntity.ok(categoryList);
    }

    /* 메뉴 등록 */
    @PostMapping
    public ResponseEntity<MenuResponseDTO> registMenu(@RequestBody MenuRequestDTO requestDTO){
        MenuResponseDTO newMenu = menuService.registMenu(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);

    }
    /*메뉴 수정*/
    @PutMapping("/{menuCode}")
    public ResponseEntity<MenuResponseDTO> modifyMenu(@PathVariable int menuCode, @RequestBody MenuRequestDTO requestDTO )
    {
        MenuResponseDTO updatedMenu = menuService.modifyMenu(menuCode, requestDTO);

        return ResponseEntity.ok(updatedMenu);
    }
//    /*메뉴 삭제*/
//    @Transactional
//    public void deleteMenu(int menuCode){
//        if(!menuRepository.existsById(menuCode)){
//            throw new IllegalArgumentException("삭제할 메뉴가 존재하지 않습니다.");
//
//            menuRepository.deleteById(menuCode);
//
//        }
//    }
/* 메뉴 삭제 */
    @DeleteMapping("/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int menuCode) {
        menuService.deleteMenu(menuCode);

        return ResponseEntity.noContent().build();
    }




}
