package com.ohgiraffers.json_handling.section01.json;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/json")
public class JsonTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 클라이언트가 보낸 JSON 문자열 덩어리(Body)를 읽어오기 위한 통로 열기
        BufferedReader reader = req.getReader(); //Buffered Reader Stream을 얻는다.
        StringBuilder sb = new StringBuilder();
        //StringBuilder를 쓰는 이유 : String은 변하지 않음. String a = "안녕", a+= "하세요" -> 문자열을 합치면 새로운 메모리 객체가 생성되어 메모리 낭비

        String line;
        while( (line = reader.readLine()) != null ){
            sb.append(line);
            System.out.println("line"+line);
        }

        System.out.println("프론트엔드가 보낸 원본 JSON 문자열 : " + sb);
        // Jackson 라이브러리의 ObjectMapper를 사용해 Json 문자열을 자바 객체(UserDTO)로 변환 (역직렬화)
        ObjectMapper mapper = new ObjectMapper();

        //readValue(변환한 문자열, 변환할 자바 클래스 타입)
        UserDTO user = mapper.readValue(sb.toString(), UserDTO.class);
        //sb.toString()를 UserDTO.class로 역직렬화 해준다.

        System.out.println("자바 객체 변환 잘 변환 되었나요? : "+user);

        //응답 헤더 사용
        resp.setContentType("application/json; charset = UTF-8");

        //브라우저로 내보낼 스트림 열기
        PrintWriter out = resp.getWriter();

        //Java 객체를 다시 JSON 문자열로 변환(직렬화)
        String jsonResponse = mapper.writeValueAsString(user);

        out.print(jsonResponse);

        out.close();

    }

}
