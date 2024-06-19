package com.dashboard.custom.mapper;

import com.dashboard.custom.security.CustomUserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface MembersMapper {

    // 로그인 확인
    public CustomUserDetail loginCheck(String username);


}
