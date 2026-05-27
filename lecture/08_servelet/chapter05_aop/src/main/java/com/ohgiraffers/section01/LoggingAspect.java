package com.ohgiraffers.section01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //Pointcut : 어떤 메서드에 공통 기능을 적용할지 고르는 조건
    //com.ohgiraffers.section01 패키지 안의 이름이 Service로 끝나는 클래스의 모든 메서드 실행 지점
    @Pointcut("execution(* com.ohgiraffers.section01.*Service.*(..))")
    public void logPointcut() {
    }

    //방금 위에서 정한 감시 구역(logPointcut) 안에서, 대상 메서드가 실행되기 바로 직전(Before)에 내가 짠 감시 코드를 먼저 실행할게!" 라는 뜻
    @Before("LoggingAspect.logPointcut()")

    //JoinPoint : 현재 실행 지점의 정보를 담고 있는 객체
    public void logBefore(JoinPoint joinPoint){
        // 1. "스프링아, 방금 실행된 그 메서드가 들어있는 '진짜 클래스 객체(타겟)'가 누구냐?"
        System.out.println("Before joinPoint.getTaerget() : " + joinPoint.getTarget());
        // ➡️ 출력 예시: com.ohgiraffers.section01.MemberService@7a3f4c (아하, 멤버서비스 클래스구나!)

        // 2. "그럼 그 클래스 안에서 실행된 '메서드의 이름(시그니처)'은 정확히 뭐냐?"
        System.out.println("Before joinPoint getSigniture(): " + joinPoint.getSignature());
        // ➡️ 출력 예시: List com.ohgiraffers.section01.MemberService.selectMembers() (아하, selectMembers 메서드구나!)


    }

}
