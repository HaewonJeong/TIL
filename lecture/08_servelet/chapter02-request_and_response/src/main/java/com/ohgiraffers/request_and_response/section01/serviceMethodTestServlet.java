package com.ohgiraffers.request_and_response.section01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request-service")
public class serviceMethodTestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String httpMethod = req.getMethod(); //getMethod(): 클라가 보낸 요청 방식을 읽어옴

        System.out.println("요청 받은 HTTP 메소드 : http Method");

        if("GET".equals(httpMethod)){
            doGet(req, resp); //URL(~/request-service)을 입력하고 엔터를 치면 실행 된다.
        }else if ("POST".equals(httpMethod)){
            doPost(req, resp); //form 태그로 버튼 클릭하면 실행 된다.
        }

    }

    //사용자에게 get,Post 요청 받았을 때 실행할 메서드
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청 처리...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청 처리...");
    }


}
