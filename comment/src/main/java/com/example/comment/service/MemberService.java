package com.example.comment.service;

import com.example.comment.domain.Member;
import com.example.comment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    @Autowired MemberRepository memberRepository;

    public void join(Member member){
        if(memberRepository.existsByNickname(member.getNickname())){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
        memberRepository.save(member);
    }
}
