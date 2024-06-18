package com.dashboard.custom.service.members;

import com.dashboard.custom.DTO.JwtTokenDTO;
import com.dashboard.custom.mapper.MembersMapper;
import com.dashboard.custom.utils.JwtTokenProvider;
import com.dashboard.custom.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface MembersService {

    public JwtTokenDTO login(String memberEmail, String memberPw);


}
