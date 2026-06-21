package com.ohgiraffers.section03.layeredarchitecture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*MemoController-> Service -> Repository
* new 를 쓰지 않고 객체 생성 가능
* Controller Service Repository를 Bean으로 관리
* */
@Configuration // "여기는 스프링 공장 설계도 인가요?" "네!"
public class ContextConfiguration {

    // 1. 창고지기(Repository) 부품을 공장에 등록한다!
    @Bean
    public MemoRepository memoRepository(){
        return new MemoryMemoRepository(); // 실제 일할 창고지기 구현체 객체
    }

    // 2. 요리사(Service) 부품을 공장에 등록한다!
    @Bean
    public MemoService memoService(){
        // 요리사는 일할 때 창고지기가 필요하니까 괄호 안에 memoRepository()를 쏙 넣어준 거야! (조립)
        return new MemoService(memoRepository());
    }

    // 3. 서빙 직원(Controller) 부품을 공장에 등록한다!
    //MemoController가 MemoService를 의존한다.
    @Bean
    public MemoController memoController(){
        // 서빙 직원은 주문받으면 요리사한테 넘겨야 하니까 memoService()를 쏙 넣어준 거야! (조립)
        return new MemoController(memoService());
    }
}
