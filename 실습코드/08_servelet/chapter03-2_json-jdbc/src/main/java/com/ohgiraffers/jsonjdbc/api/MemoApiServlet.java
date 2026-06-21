package com.ohgiraffers.jsonjdbc.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
 * res ----> server -> service -> DAO -> DB
 * req <----
 *   method 'url'
 * */
@WebServlet("/api/memos")
public class MemoApiServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();
    private final MemoService memoService = new MemoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");

        if (!"/api/memos".equals(req.getServletPath())) {
            //잘못된 메서드 요청 시 405 Method Not Allowed 에러 코드를 보내고 응답에 대한 값을 만들어둔 Error 객첼 반환
            //GET /api/memos로 오세요!" 라고 에러 메시지를 JSON으로 쏘아붙이고 쫓아내는 철벽 수비 코드
            resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            mapper.writeValue(resp.getWriter(), new ErrorResponse("GET /api/memos를 사용하세요."));
            return;
        }

        //주소 검사를 무사히 통과하면, 지휘관인 MemoService 한테 "야, 디비 문 열어서 메모 목록 싹 긁어와!" 하고 명령을 내려서 메모들이 가득 담긴 상자(memos)
        List<MemoDTO> memos = memoService.findsAllMemos();
        mapper.writeValue(resp.getWriter(), memos);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        registMemo(req, resp);
    }


    private void registMemo(HttpServletRequest req, HttpServletResponse resp)
            throws IOException { //getReader() 예외 처리를 위해 method signature에 Throws 선택

        MemoDTO requestMemo = mapper.readValue(req.getReader(), MemoDTO.class);
        String content = requestMemo.getContent() == null ? "" : requestMemo.getContent().trim();

        if (content.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mapper.writeValue(resp.getWriter(), new ErrorResponse("content가 필요합니다."));
            return;
        }
        MemoDTO savedMemo = memoService.registMemo(content);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        mapper.writeValue(resp.getWriter(), savedMemo);

    }
}
