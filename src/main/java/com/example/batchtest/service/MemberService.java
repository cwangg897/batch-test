package com.example.batchtest.service;

import com.example.batchtest.domain.Member;
import com.example.batchtest.domain.MemberRepository;
import com.example.batchtest.domain.request.MemberCreateRequest;
import com.example.batchtest.domain.response.MemberResponse;
import com.example.batchtest.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public void create(MemberCreateRequest request) {
        memberRepository.save(request.toMember());
    }

    public MemberResponse findMember(Long id){
        Member member = memberRepository.getById(id);
        return MemberResponse.from(member);
    }

    public List<MemberResponse> findAll() {
        List<Member> list = memberRepository.findAll();
        List<MemberResponse> result = list.stream().map(m -> (MemberResponse.from(m))).collect(Collectors.toList());
        return result;
    }

}
