package com.dashboard.custom.service.members;

import com.dashboard.custom.DTO.JwtTokenDTO;
import com.dashboard.custom.mapper.MembersMapper;
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
public class MemberServiceImpl implements MembersService {

    private final MembersMapper membersMapper;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtTokenDTO login(String memberEmail, String memberPw) {

        // 1. login email(id)/password를 기반으로 Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberEmail, memberPw);

        // 2. 실제 검증(사용자 비밀번호 체크)
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        JwtTokenDTO jwtTokenDTO = jwtTokenProvider.generateToken(authentication);

        return jwtTokenDTO;
    }



}

