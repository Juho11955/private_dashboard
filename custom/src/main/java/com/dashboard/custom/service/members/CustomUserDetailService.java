package com.dashboard.custom.service.members;

import com.dashboard.custom.entity.Members;
import com.dashboard.custom.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MembersRepository membersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return membersRepository.findByUsername(username)
                .map(this::createUserDetail)
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));
    }

    // user 데이터 존재할 시 userdetail 객체로 만들어서 리턴
    private  UserDetails createUserDetail(Members members) {
        return User.builder()
                .username(members.getMemberEmail())
                .password(passwordEncoder.encode(members.getPassword()))
                .roles(members.getRoles().toArray(new String[0]))
                .build();
    }

}
