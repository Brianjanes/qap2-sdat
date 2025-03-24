package com.keyin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.keyin.model.Member;
import com.keyin.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void deleteMemberById(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Member with ID " + id + " does not exist.");
        }
    }

    public List<Member> searchMembers(String searchTerm) {
        return memberRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchTerm, searchTerm);
    }

    public List<Member> searchMembersByFirstName(String firstName) {
        return memberRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Member> searchMembersByLastName(String lastName) {
        return memberRepository.findByLastNameContainingIgnoreCase(lastName);
    }
}
