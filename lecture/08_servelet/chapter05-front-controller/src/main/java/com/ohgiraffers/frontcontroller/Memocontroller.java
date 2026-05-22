package com.ohgiraffers.frontcontroller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Memocontroller {

    private final ObjectMapper mapper = new ObjectMapper();
    private final List<MemoDTO> memos = new ArrayList<>();
    private int sequence = 1;

    public Memocontroller() {
        //메모 생성과 동시에 리스트에 추가
        memos.add(new MemoDTO(sequence++, "Front Controller로 /api/* 요청 받기"));
        memos.add(new MemoDTO(sequence++, "next.js 화면 이동 프론트 라우터가 담당하기"));
    }

    //목록 조회
    public void findAll(HttpServletResponse response) throws IOException {

        //writeValue : Java->JSON으로 바꿔준다.
        //MemoDTO의 형태가 JSON의 형태로 변경되서 Front로 연결된다.
        mapper.writeValue( response.getWriter(), memos );
    }

    //메모 등록
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //key값이 형태가 같아야 잘 뽑아온다.
        MemoDTO requestMemo = mapper.readValue(req.getReader(), MemoDTO.class);
        String content = requestMemo.getContent() == null ? "" : requestMemo.getContent().trim();

        if(content.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            //메세지라는 데이터 키값의 JSON 객채가 생성되서 mapper에 응답할 수 있게 된다.
            mapper.writeValue(resp.getWriter(), new ErrorResponse("content is required."));
        }

        //프론트에서 뽑아낸 컨텐트로 새로운 MemoDTO 객체를 만든다.
        MemoDTO savedMemo = new MemoDTO(sequence++, content);
        memos.add(0, savedMemo);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        mapper.writeValue(resp.getWriter(), savedMemo);

    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //요청 본문을 만든다.
        MemoDTO requestMemo = mapper.readValue(req.getReader(), MemoDTO.class);

        //요청 본문에서 ID를 읽어온다.
        //요청 받은 아이디와 내가 가진 ID를 비교해서 같으면 리스트에서 제거하고 boolean값 반환
        boolean removed = memos.removeIf(memo -> memo.getId() == requestMemo.getId());

        //삭제 실패
        if(!removed){
            //상태를 설정해준다.
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            mapper.writeValue(resp.getWriter(), new ErrorResponse("memo를 찾을 수 없습니다."));

        }
        //삭제 성공
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

}
