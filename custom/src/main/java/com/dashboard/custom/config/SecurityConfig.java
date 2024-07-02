package com.dashboard.custom.config;

import com.dashboard.custom.filter.JwtAuthenticationFilter;
import com.dashboard.custom.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable() // REST API이므로 basic auth 및 csrf 보안을 사용하지 않음
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT를 사용하기 때문에 세션 사용X
                .and()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/members/login")).permitAll() // 해당 API로의 모든 요청을 허가
                .requestMatchers(new AntPathRequestMatcher("/members/test")).permitAll() // 해당 API로의 모든 요청을 허가
//                .requestMatchers(new AntPathRequestMatcher("/members/test")).hasRole("USER") // USER 권한이 있어야 요청할 수 있다
                .anyRequest().authenticated() // 이 외의 모든 요청은 인증을 필요
                .and()
                // JWT 인증을 위하여 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt Encoder 사용
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
