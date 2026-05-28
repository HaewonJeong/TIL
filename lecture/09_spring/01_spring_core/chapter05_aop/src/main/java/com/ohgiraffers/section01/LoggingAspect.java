package com.ohgiraffers.section01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
* Aspect : 공통 관심사를 모아둔 클래스
* */

@Aspect
@Component
public class LoggingAspect {

    //Pointcut : Advice를 어떤 메서드에 공통 기능을 적용할지 고르는 조건
    //com.ohgiraffers.section01 패키지 안의 이름이 Service로 끝나는 클래스의 모든 메서드 실행 지점
    @Pointcut("execution(* com.ohgiraffers.section01.*Service.*(..))")
    public void logPointcut() {
    }

    /*
    * Advice : 실제로 실행될 공통 기능 메서드
    * Target: 공통 기능이 적용될 실제 대상 객체
    * Proxy: Target 앞에서 요청을 가로채는 대리 객체
    * Weaving: Target에 Advice가 적용되는 과정*/
    //방금 위에서 정한 감시 구역(logPointcut) 안에서, 대상 메서드가 실행되기 바로 직전(Before)에 내가 짠 감시 코드를 먼저 실행할게!" 라는 뜻
    @Before("LoggingAspect.logPointcut()")

    //JoinPoint : 현재 실행 지점의 정보를 담고 있는 객체(Advice가 끼어들 수 있는 실행 지점)
    public void logBefore(JoinPoint joinPoint) {
        // 1. "스프링아, 방금 실행된 그 메서드가 들어있는 '진짜 클래스 객체(타겟)'가 누구냐?"
        System.out.println("Before joinPoint.getTaerget() : " + joinPoint.getTarget());
        // ➡️ 출력 예시: com.ohgiraffers.section01.MemberService@7a3f4c (아하, 멤버서비스 클래스구나!)

        // 2. "그럼 그 클래스 안에서 실행된 '메서드의 이름(시그니처)'은 정확히 뭐냐?"
        System.out.println("Before joinPoint getSigniture(): " + joinPoint.getSignature());
        // ➡️ 출력 예시: List com.ohgiraffers.section01.MemberService.selectMembers() (아하, selectMembers 메서드구나!)


        if (joinPoint.getArgs().length > 0) {
            System.out.println("getArgs():" + joinPoint.getArgs()[0]);
        }
    }

    //포인트 컷을 동일한 클래스 내에서 사용하는 것이면 클래스명 생략 가능
    //After는 대상 메서드가 동작한 후에 동작한다.
    //에러가 나도 실행된다. 그래서 보통 로그를 남길때 사용한다.
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After : " + joinPoint.getTarget());
        System.out.println("After : " + joinPoint.getSignature());
    }

    //returning 속성은 리턴값으로 반환되는 값을 객체로 받것이다. (result -> result) <--사실 이부분 잘 모르곘음
    //returning 속성값의 이름이 매개변수로 받아주는 것의 이름과 일치해야 한다.
    //또한, joinPoint는 반드시 첫 번째 매개변수로 선언해야 한다.
    //정상적으로 실행 될때만 반환
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    //return 값으로 반환되는 값을 받아 활용 가능
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result: " + result);

        /*리턴 할 결과값을 가공해 줄 수도 있다.*/
        if (result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }

    //예외가 발생했을때만 실행
    //속성값의 이름이 매개변수와 일치해야 한다.
    //발생한 예외의 내용을 Throwable 객체로 받아볼 수 있다.
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing Exception" + exception);
    }


    @Around("logPointcut()") // 👈 1. 어디에 끼어들지 주소를 지정해줘!
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // ----------- [Before 단계] -----------
        // 2. 진짜 메서드가 실행되기 전에 하고 싶은 일 (시간 측정 시작, 로그 찍기 등)
        System.out.println("Around Before: 메서드 시작합니다~");

        // ----------- [핵심: 실행 권한] -----------
        // 3. 🔥 이 코드가 실행되는 순간 원래 메서드가 실행돼!
        // 원래 메서드가 돌고 돌려준 결과값(Return)을 result에 저장하는 거지.
        Object result = joinPoint.proceed();

        // ----------- [After 단계] -----------
        // 4. 진짜 메서드가 끝나고 나서 하고 싶은 일 (시간 측정 종료, 결과물 가공 등)
        System.out.println("Around After: 메서드 안전하게 끝났습니다~");

        // 5. 원래 메서드가 돌려주려던 결과값을 최종적으로 다시 토스해줘!
        return result;
    }

}

