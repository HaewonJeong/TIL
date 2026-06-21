package com.ohgiraffers.requestmapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/menus") //이 Controller안의 모든 메서드에 붙는 URL Prefix
public class MethodMappingTestController {

    /*ResponseEntity : HTTP 응답을 표현하는 객체*/
    //Status Code - 200, 201, 404
    //Header - Content Type 등
    //Body - 실제 응답 데이터(JSON)

    //GET /api/v1/menus     -- 메뉴 목록 조회
    @GetMapping //HTTP GET 요청이 들어오면 실행할 메서드
    public ResponseEntity<Map<String, String>> findMenus() {
        Map<String, String> response = Map.of("message", "메뉴 목록 조회용 핸들러 메소드 호출");

        return ResponseEntity.ok(response);
    }

    //POST /api/v1/menus 요청 -- 메뉴 등록
    @PostMapping
    public ResponseEntity<Map<String, String>> registMenu() {
        Map<String, String> response =
                Map.of("message", "신규 메뉴 등록용 핸들러 메소드 호출");
        //응답 코드를 201로 내려준다.
        return ResponseEntity.status(201).body(response);
    }

    //PUT /api/v1/menus/1 {menuCode}에는 ResponseEntity가 넣어준다.  -- 1번 메뉴 수정
    @PutMapping("/{menuCode}")
    public ResponseEntity<Map<String, String>> modifyMenu(@PathVariable int menuCode) {
        Map<String, String> response =
                Map.of("message", menuCode + "번 메뉴 수정용 핸들러 메소드 호출");
        return ResponseEntity.ok(response);
    }

    //DELETE /api/v1/menus/1  --1번 메뉴 삭제
    @DeleteMapping("/{menuCode}")
    public ResponseEntity<Map<String, String>> deleteMenu(@PathVariable int menuCode) {
        Map<String, String> response =
                Map.of("message", menuCode + "번 메뉴 삭제용 핸들러 메소드 호출");
        return ResponseEntity.ok(response);
    }

}
