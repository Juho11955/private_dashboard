package com.dashboard.custom.repository;

import com.dashboard.custom.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members, Long> {

    Optional<Members> findByUsername(String memberName);

}
