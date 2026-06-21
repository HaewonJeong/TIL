package com.ohgiraffers.jacksonjson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/api/v1/members") //회원에 대한 요청을  이 jackson controller가 받는다고 알려줌
public class JacksonController {

    private final List<MemberDTO> memberList;

    public JacksonController(){
        memberList = new ArrayList<>();
        memberList.add(new MemberDTO(1, "판다", 3, new Date(System.currentTimeMillis())));
        memberList.add(new MemberDTO(2, "코알라", 5, new Date(System.currentTimeMillis())));
        memberList.add(new MemberDTO(3, "원숭이", 7, new Date(System.currentTimeMillis())));
    }

    /*Java List<MemberDTO>를 JSON 배열로 응답 해주는 형태*/
    //1. Java List<MemberDTO> -> JSON 배열
    @GetMapping
    public ResponseEntity<List<MemberDTO>> findMembers(){
        return ResponseEntity.ok(memberList);
    }

    //2. java MemberDTO -> JSON 객체
    @GetMapping("/{memberNo}")
    public ResponseEntity<MemberDTO> findMember(@PathVariable int memberNo){
        MemberDTO foundMember = memberList.stream()
                .filter(member -> member.getNo() == memberNo)
                .findFirst()
                .orElseThrow( () -> new IllegalArgumentException("해당 번호의 회원이 없습니다.") );

        return ResponseEntity.ok(foundMember);
    }

    //3. JSON 요청 본문 -> MemberDTO
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMember(@RequestBody MemberDTO member){
        memberList.add(member);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "회원 등록 요청 성공");
        response.put("member", member);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //4.message + data 응답 구조
    @GetMapping("/response-wrapper")
    public ResponseEntity<Map<String, Object>> findMemberWithWrapper(){
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("해쉬 키 1 message", "회원 목록 조회 성공");
        response.put("해쉬 키 2 count", memberList.size());
        response.put("data", memberList);

        return ResponseEntity.ok(response);

    }

    // 5. ObjectMapper 직접 변환 확인
    @GetMapping("/object-mapper")
    public ResponseEntity<Map<String, Object>> objectMapperTest(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(memberList); //Java 객체 -> Json 모양의 "문자열" 변환
        // 출력 :
        // {
        //  "message": "ObjectMapper 직접 변환 결과",
        //  "jsonString": "[{\"age\":3,\"enrollDate\":\"2026-05-29 10:50:49\",\"main\":\"판다\",\"no\":1},{\"age\":5,\"enrollDate\":\"2026-05-29 10:50:49\",\"main\":\"코알라\",\"no\":2},{\"age\":7,\"enrollDate\":\"2026-05-29 10:50:49\",\"main\":\"원숭이\",\"no\":3}]"
        //}
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "ObjectMapper 직접 변환 결과");
        response.put("jsonString", jsonString);

        return ResponseEntity.ok(response);


    }
}
