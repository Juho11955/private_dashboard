package com.dashboard.custom.service.members;

import com.dashboard.custom.DTO.JwtTokenDTO;
import com.dashboard.custom.repository.MembersRepository;
import com.dashboard.custom.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public JwtTokenDTO login(String memberEmail, String memberPw) {

        // 1. 로그인 정보를 기반으로 authentication 객체 생성
        // 최초 authentication은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberEmail, memberPw);

        // 2. 실제 검증
        // authenticate 메소드가 실행될 때 CustomerUserDetailService에서 만든 loadUserByUsername 메소드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT토큰 생성
        JwtTokenDTO jwtTokenDTO = jwtTokenProvider.generateToken(authentication);

        return jwtTokenDTO;

    }

}
