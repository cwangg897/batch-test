package com.example.batchtest.domain.response;

import com.example.batchtest.domain.Member;
import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private Long id;
    private String name;
    private BigDecimal amount;

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .amount(member.getAmount())
                .build();
    }
}
