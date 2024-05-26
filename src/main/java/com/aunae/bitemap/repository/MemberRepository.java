package com.aunae.bitemap.repository;

import com.aunae.bitemap.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<Member> findByUsername(String username);

}
