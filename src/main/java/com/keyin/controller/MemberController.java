package com.keyin.controller;

import com.keyin.model.Member;
import com.keyin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member createOrUpdateMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
    }

    @GetMapping("/search")
    public List<Member> searchMembers(@RequestParam String query) {
        return memberService.searchMembers(query);
    }

    // Optional: Add more specific search endpoints if needed
    @GetMapping("/search/by-first-name")
    public List<Member> searchMembersByFirstName(@RequestParam String firstName) {
        return memberService.searchMembersByFirstName(firstName);
    }

    @GetMapping("/search/by-last-name")
    public List<Member> searchMembersByLastName(@RequestParam String lastName) {
        return memberService.searchMembersByLastName(lastName);
    }
}