package com.ohgiraffers.frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

//컨트롤러에서 사용할 공통 분기를 담당할 서블릿
//이 서블릿이 '/api'로 시작하는 모든 요청을 받는다.
@WebServlet("/api/*")
public class ApiDispatcherServlet extends HttpServlet {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Memocontroller memocontroller = new Memocontroller();

    //GET, POST 같은 여러 HTTP method 요청이 들어왔을 때 공통으로 실행되는 메서드
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //요청에 대해서 인코딩해서 받는다.
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        String method = req.getMethod();
        String path = req.getPathInfo();

        System.out.println(method + " " + path);

        if (path == null) {
            sendError(resp, HttpServletResponse.SC_NOT_FOUND, "Unknwon API path");
            return;
        }

        if ("GET".equals(method) && "/memos".equals(path)) {
            memocontroller.findAll(resp);
            return;
        }
        if ("POST".equals(method) && "/memo".equals(path)) {
            memocontroller.regist(req, resp);
            return;
        }
        if ("POST".equals(method) && "/memos/delete".equals(path)) {
            memocontroller.remove(req, resp);
            return;
        }
        sendError(resp, HttpServletResponse.SC_NOT_FOUND, "Unknwon API path" + method + " " + path);
    }


    private void sendError(HttpServletResponse resp, int status, String message) throws IOException {
        resp.setStatus(status);
        mapper.writeValue(resp.getWriter(), new ErrorResponse(message));
    }
}
