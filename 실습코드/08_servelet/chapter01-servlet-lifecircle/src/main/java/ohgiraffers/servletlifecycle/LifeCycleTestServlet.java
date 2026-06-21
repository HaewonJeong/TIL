package ohgiraffers.servletlifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Servlet
* - Serve + Applet를 합친 단어 (작은 애플리케이션)
* - HTTP 요청을 처리 할 수 있는 자바 클래스.
*
* - HttpServlet (웹 요청을 처리하는데 필요한 설정을 가진 클래스) 상속해서 커스텀 서블릿을 생성 할 수 있다.
* - HttpServlet 상속구조
*    - Servlet interface
*        - GenericServlet Class
*            - HTTP Servlet Class (웹 http 요청 처리용 클래스)
*               - CustomServlet
* - Tomcat은 요청별로 Servlet 객체를 관리한다. (Servlet /JSP Container)
* - Tomcat은 Servlet 객체를 Singleton 패턴으로 관리한다.
* - url별 첫 번째 요청에 tomcat은 Servlet 객체를 생헝하고, init(servletConfig)메소드를 실행한다.
* - 실제 요청을 처리하는 것은 Service 메서드 들이다.
*       1. 요청이 오면, service(ServletRequest, ServletResponse)가 호촐된다.
*       2. 전송방식별로 그에 상응하는 메소드 호출 doGet, doPost 등이 있다.
* - Tomcat 종료시 모든 Servlet 객체를 destroy 메소드 호출 후 반환한다.
* */

@WebServlet(value = "/lifecycle", loadOnStartup = 1)
//해당 주소로 들어온 요청을 해당 Class가 담당한다고 알려줌
//loadOnstartUp : 처리 우선순위
public class LifeCycleTestServlet extends HttpServlet {
    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    public LifeCycleTestServlet(){
        System.out.println("Constructor 생성자!");
    }

    //서블릿이 생성될 때 "최초 단 한 번" 호출되어 초기화 작업을 담당
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(): "+initCount++);
    }

    //Client의 요청이 올 때 마다 새롭게 호출 됨 -> 요청마다 달라지는 데이터를 Request에 담기
    //HttpServletRequest 클라이언트가 서버에 보내는 요청정보를 처리하는 객체
    //HttpServletResponse 서버가 클라이언트로 보내는 응답정보를 처리하는 객체
    //이 프로젝트를 통채로 Tomcat에 넘겨줘서 deploy
    //Application Context : 최상위 경로.
    //게시판을 만들떄는 service에서 만들어진다고 보면 됨
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service() : " + serviceCount++);
    }

    //서버 종료시 호출 됨
    @Override
    public void destroy() {
        System.out.println("destory() : "+ destroyCount++);
    }

}
