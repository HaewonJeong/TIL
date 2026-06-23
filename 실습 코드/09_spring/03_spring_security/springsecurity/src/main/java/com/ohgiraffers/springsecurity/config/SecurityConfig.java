package com.ohgiraffers.config;

import com.ohgiraffers.jwt.JwtAuthenticationFilter;
import com.ohgiraffers.jwt.JwtTokenProvider;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration  //security container 라는 Bean을 등록 해줌
@EnableWebSecurity //HTTP 요청의 인증/인가 를 할 수 있게 해주는 어노테이션
@EnableMethodSecurity(prePostEnabled = true) //@PreAuthorize : 유저or어드민 사용자만 사용 할 수 있게 한다. @PostAutorize
@RequiredArgsConstructor
public class SecurityConfig {
    //Security config
    //Bean 등록 or 어노테이션

    //생성자 주입 1. 필드 주입 : 제일 쉬운 방법
    //@RequiredArgsConstructor 선언, JwToken을 @Component Bean으로 등록.

    private JwtTokenProvider jwtTokenProvider;
    private UserDetailsService userDetailsService;

    //비밀번호 암호화
    @Bean    //의존성 주입
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //SecurityFilterChain 설정
    //어디에서 로그인 되는지 등등..
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) {
        //CSRF 처리 비활성화
        http.csrf(AbstractHttpConfigurer::disable)
                //세션 로그인 x -> 토큰 로그인 설정
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth
                        -> auth.requestMatchers(HttpMethod.POST, "/api/v1/users", "/api/v1/auth/login",
                                "/api/v1/auth/refresh", "/api/v1/auth/logout").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/me").hasAuthority("USER") //개인 페이지에 USER 권한이 있으면 받아들여줘라.는 뜻
                        .anyRequest().authenticated() //로그인만 되면 통과 시키겠다.
                )

                /*
                  .permitAll()                        // 모두 허용 (비로그인도 OK)
                  .denyAll()                          // 모두 차단
                  .authenticated()                    // 로그인만 되면 OK
                  .anonymous()                        // 비로그인만 허용
                    ------------
                    hasRole vs hasAuthority 차이
                    DB에 "USER"라고 저장되어 있으면
                    .hasRole("USER") //내부적으로는 ROLE_USER를 찾아서 불일치
                    .hasAuthority("USER") //USER 그대로를 찾음
                    -----------
                   3. URL 패턴 규칙 (Ant Pattern)
                  "/api/v1/users"        // 정확히 이 경로만
                  "/api/v1/users/**"     // /api/v1/users/ 하위 모든 경로
                  "/api/v1/users/*"      // /api/v1/users/123 (한 단계만)
                  "/api/**"              // /api/ 하위 전체
                  "/**"                  // 모든 경로 (anyRequest랑 같은 범위)
                  "/api/v1/users/{id}"   // ❌ PathVariable 형식은 Ant에서 안 됨 → ** 사용
                  "/api/v1/users/*"      // ✅ 이렇게 써야 함
                 */
                //커스텀 인증 필터(JWT 사용해서 확인)을 인증 필터 앞에 삽입
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public Filter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvier, userDetailService);
    }

}
