package com.example.batchtest.domain.request;

import com.example.batchtest.domain.Member;
import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class MemberCreateRequest {

    private String name;
    private BigDecimal amount;

    public Member toMember(){
        return Member.builder()
                .name(name)
                .amount(amount)
                .build();
    }

}
