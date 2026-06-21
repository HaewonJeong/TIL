package com.ohgiraffers.request_and_response.section02;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parameter")
public class parameterTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name"); //getParameter(): key값을 이용해 Value를 가져옴

        //http://localhost:8080/parameter?name=홍길동 주소창 입력 > 클라이언트가 보낸 이름 : 홍길동 출력
        //http://localhost:8080/parameter?name=홍길동&name=유관순 : 1. 키값이 여러개면 첫번째 값만 가져옴 2.Key가 여러개일때는 맨 앞 값만 가져옴
        //getParameterValues : Key가 여러개일때 씀
        System.out.println("클라이언트가 보낸 이름 : " + name);
        String[] values = req.getParameterValues("name");

        if (values != null) {
            for(String value : values){
                System.out.println(value);
            }
        }

        System.out.println("user-Agent 헤더 정보 : " + req.getHeader("User-Agent"));

        // 1. 응답할 문서의 타입과 인코딩 설정
        // - [가장 먼저] 브라우저야, 한글 깨지지 말고 HTML로 예쁘게 읽어라! (세팅)
        resp.setContentType("text/html; charset=UTF-8");

        // 2. 클라이언트 브라우저와 연결된 스트림(길) 열기
        PrintWriter out = resp.getWriter();

        // 3. 스트림을 통해 HTML 태그를 문자열로 밀어넣기
        out.println("<h1>안녕 서블릿! 반가워~~~</h1>");

        out.close();

    }
}
