package com.ohgiraffers.springsecurity.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;
    //서블릿에도 필터가 있다.

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtFromRequest(request);

        if (StringUtils.hasText(token) && jwtTokenProvider.validationToken(token)) {

            //로그인 사용자의 토큰을 받아, 사용자 이름을 뽑아내, 어떤 권한을 갖고 있는지 확인
            String username = jwtTokenProvider.getUsernameFromJWT(token);

            //CustomUserDetailService를 통해 사용자 정보를 로드
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        //현재 받은 요청과 응답을 같이 넘겨준다.
        // JWT 검증이 성공하면
        // SecurityContextHolder에 인증 정보가 저장된다.
        //
        // 이후 filterChain.doFilter()를 호출하여
        // 다음 필터 또는 Controller로 요청을 전달한다.
        //
        // 이 시점부터 Spring Security는
        // "로그인된 사용자"로 인식한다.
        filterChain.doFilter(request, response);



    }

    //React에 토근값을 보낼때 속성명을 Authorization을 보내는데, Bearer 토큰을 보낸다.
    //Bearer을 잘라주는 작업 필요
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        //"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30"
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
