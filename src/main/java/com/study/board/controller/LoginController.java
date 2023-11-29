//package com.study.board.controller;
//
//import com.study.board.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import java.lang.reflect.Member;
//
//@SessionAttributes("member")
//@Controller
//public class LoginController {
//    @Autowired
//    private MemberService memberService;
//
//    @GetMapping("/login")
//    public void loginView() {
//
//    }
//
//    @PostMapping("/login")
//    public String login(Member member, Model model) {
//        Member findMember = memberService.getMember(member);
//
//        if (findMember != null && findMember.getPassword(member.getPassword())) {
//            model.addAttribute("member", findMember);
//            return "forward:getBoardList";
//        } else {
//            return "redirect:login";
//        }
//    }
//}
