package com.example.batchtest.domain;

import com.example.batchtest.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {


    default Member getById(Long id){
        return findById(id).orElseThrow(() -> new NotFoundException("존재하지 않는 유저 입니다"));
    }

}
