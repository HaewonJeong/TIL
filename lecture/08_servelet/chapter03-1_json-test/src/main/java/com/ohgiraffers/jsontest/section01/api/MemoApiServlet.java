package com.ohgiraffers.jsontest.section01.api;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/memos")
public class MemoApiServlet extends HttpServlet {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final List<MemoDTO> memos = new ArrayList<>();
    private static int sequence = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        if(memos.isEmpty()){
            memos.add(new MemoDTO(sequence++, "React에서 Servlet API 호출하기"));
            memos.add(new MemoDTO(sequence++, "다음 과제에서는 static List를 JDBC로 교체하기"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        //writeValue(출력 대상, 자바객체)
        mapper.writeValue(resp.getWriter(), memos); //memos 객체를 Json으로 바꿔 HTTP 객체로 출력
        /*
        * 1. mapper는 "저장소"가 아니라 "변환기"야!
        우리가 맨 위에 private static final ObjectMapper mapper = new ObjectMapper(); 라고 선언해 둔 거 기억나지?
        여기서 mapper는 데이터를 담아두는 가방이나 변수가 아니야. 그냥 "자바 객체를 넣으면 JSON 문자열로 바꿔서 파이프라인으로 쏴주는 똑똑한 기계"를 한 대 설치해 둔 것뿐이야.
        그래서 mapper 안에는 memos 리스트나 데이터가 전혀 저장되지 않고, 요청이 들어올 때마다 매번 중간에서 일만 해주는 거란다.
        * 2.mapper.writeValue(파이프라인, 객체) (어떻게 작동하는가?)
        * 잭슨 아저씨(mapper)가 memos 자바 객체를 슥 가져와서 그 자리에서 [{"id":1, "content":"..."}, ...] 형태의 JSON 글자로 바꿉니다.
        * 그리고 그 바뀐 JSON 글자를 resp.getWriter()라는 파이프라인에다가 실시간으로 줄줄줄 흘려보내서(write) 브라우저한테 전송해 버리는 거야!
        * */

    }

    //HttpServletRequest (req) = 손님이 보낸 요청(Request) 편지 📥
    //HttpServletResponse (resp) = 내가 손님한테 보낼 응답(Response) 편지 📤
    //클라이언트가 서버로 Json으로 요청을하면, 메모를 등록하기 위해 -> 그럼 dopost가 동작 -> Json으로 온것을 Java 객체로 변환
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8"); //Json으로 온것을 Java 객체로 변환

        //들어온 컨텐츠가 있는지 공백 확인
        MemoDTO requestMemo = mapper.readValue(req.getReader(), MemoDTO.class);
        String content = requestMemo.getContent() == null ? "" : requestMemo.getContent().trim(); //사용자가 공백 입력 시 처리

        //실패한 경우
        if(content.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); //SC_BAD_REQUEST : 400
            mapper.writeValue(resp.getWriter(), new ErrorResponse("content is required") ) ;
        }

        //성공한 경우
        //공백이 없고 잘 들어온 경우에, 메모를 저장하기 위해 memoDTO를 하나 더 만들고, 내가 가지고 있는 Static DB에 임시로 추가함.
        MemoDTO savedMemo = new MemoDTO(sequence++, content);
        memos.add(savedMemo);

        //다시 가진 응답을 getWriter를 이용해 JSON으로 바꿔 응답
        resp.setStatus(HttpServletResponse.SC_CREATED);
        mapper.writeValue(resp.getWriter(), savedMemo);

    }

    static class ErrorResponse{
        private final String message;

        ErrorResponse(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }


}
