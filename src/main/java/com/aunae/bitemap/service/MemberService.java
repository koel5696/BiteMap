package com.aunae.bitemap.service;

import com.aunae.bitemap.entity.Member;
import com.aunae.bitemap.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String email, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        // 비밀번호를 인코딩하여 저장
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }

    public boolean isUsernameTaken(String username) {
        return memberRepository.existsByUsername(username);
    }

    public boolean isEmailTaken(String email) {
        return memberRepository.existsByEmail(email);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
