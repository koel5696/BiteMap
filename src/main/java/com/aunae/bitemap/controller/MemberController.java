package com.aunae.bitemap.controller;

import com.aunae.bitemap.entity.Member;
import com.aunae.bitemap.repository.MemberRepository;
import com.aunae.bitemap.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/member/register")
    public String register() {
        return "register";
    }


    @PostMapping("/member/register")
    public ResponseEntity<?> signUp(@RequestBody Member member) {
        if (memberService.isUsernameTaken(member.getUsername())) {
            return ResponseEntity.status(400).body("{\"message\": \"이미 사용 중인 ID입니다.\"}");
        }
        if (memberService.isEmailTaken(member.getEmail())) {
            return ResponseEntity.status(400).body("{\"message\": \"이미 사용 중인 이메일입니다.\"}");
        }
        try {
            memberService.saveMember(member);
            return ResponseEntity.ok().body("{\"message\": \"회원가입이 완료되었습니다!\"}");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("{\"message\": \"회원가입 중 오류가 발생했습니다: " + e.getMessage() + "\"}");
        }
    }
}
