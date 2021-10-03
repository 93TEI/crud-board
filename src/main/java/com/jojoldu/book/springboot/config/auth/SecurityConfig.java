package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()   //h2-console 화면을 사용하기 위해 해당 옵션들을 disable한다
                .headers().frameOptions().disable() // 이것도
                .and()
                    .authorizeRequests() // URL별로 권환 관리 설정하는 옵션의 시작점이다
                    .antMatchers("/","/css/**","/images/**","/js/**","h2-console/**","/profile").permitAll() // antMatchers : 권한 관리 대상을 지정하는 옵션
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER권한을 가진 사람만 가능하게 함 (permitAll은 전체열람권한을 준것)
                    .anyRequest().authenticated() // anyRequest() : 설정된 값들 이외 나머지 URL을 나타냄/ .authenticated()는 인증된 사용자에게만 허용하게 함(인즌=로그인)
                .and()
                    .logout() // 로그아웃 기능에 대한 여러 설정의 진입점
                        .logoutSuccessUrl("/")  // 로그아웃 시 이동할 주소
                .and()
                    .oauth2Login() // 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당한다
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다
                                                                    // 리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시 가능
    }
}
