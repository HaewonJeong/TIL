package com.ohgiraffers.statemanagement.section01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookietestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //rememberId라는 이름으로 user01값을 가진 쿠키를 생성
        Cookie cookie = new Cookie("rememberId", "user01");

        //쿠키 유지 시간 설정
        cookie.setMaxAge(60 * 60 * 24); //24시간 설정 - 24시간동안 로그인 상태를 쿠키에 담아서 보낼 수 있게 됨

        //어떤 경로에서 쿠키가 전송되게 할 것인지 설정
        cookie.setPath("/"); //전체 경로에서 전송

        //Http 요청으로만 접근 가능하게 설정(Document.cookie로 직접 접근 차단)
        //개인정보등은 쿠키에 담지 않는다.
        cookie.setHttpOnly(true);

        //응답에 Set-cookie를 포함
        //Cookie cookie = new Cookie(...); 하고 열심히 구운 맛있는 쿠키(예: 세션 ID나 로그인 정보)를 드디어 응답 상자(resp)에 집어넣는 순간
        //자바 서블릿이 이 코드를 실행하면, 브라우저한테 보내는 HTTP 응답 편지 헤더(머리글)에 Set-Cookie: 쿠키내용 이라는 문장
        resp.addCookie(cookie);

        //쿠키는 응답 이후 브라우저에 저장되고, 다음 요청부터 서버로 다시 전달된다.
        //어떤 경로로 리다이렉트 할지 경로 작성
        //브라우저에게 '/redirect' 주소로 다시 요청을 지시한다.
        resp.sendRedirect("redirect");

    }
}
