package com.keyin.repository;

import com.keyin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Method to find a member by their first name
    List<Member> findByFirstNameContainingIgnoreCase(String firstName);

    // Method to find a member by their last name
    List<Member> findByLastNameContainingIgnoreCase(String lastName);

    // Method to find a member by their full name - both first and last!
    List<Member> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}