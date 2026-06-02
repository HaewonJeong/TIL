package com.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StopwatchInterceptor stopwatchInterceptor;
    private final ApiKeyInterceptor apiKeyInterceptor;

    //생성자 주입
    //생성자가 하나만 있으면 Autowired가 생략되도 된다.
    public WebConfiguration(StopwatchInterceptor stopwatchInterceptor, ApiKeyInterceptor apiKeyInterceptor){
        this.stopwatchInterceptor = stopwatchInterceptor;
        this.apiKeyInterceptor = apiKeyInterceptor;
    }

    //Spring MVC에 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopwatchInterceptor)
                .addPathPatterns("/api/v1/**") //적용 경로
                .excludePathPatterns("/error") //제외 경로
                .order(1);                     //인터셉터 실행순서, 숫자가 작을 수록 먼저 실행
        registry.addInterceptor(apiKeyInterceptor)
                .addPathPatterns("/api/v1/admin/**")
                .excludePathPatterns("/error")
                .order(2);

    }
}
