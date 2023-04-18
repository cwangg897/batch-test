package com.example.batchtest.controller;

import com.example.batchtest.domain.request.MemberCreateRequest;
import com.example.batchtest.domain.response.MemberResponse;
import com.example.batchtest.response.common.ApiResponse;
import com.example.batchtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createMember(@RequestBody MemberCreateRequest request) {
        memberService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> findMember(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.getSuccessResult(memberService.findMember(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<MemberResponse>>> findAll(){
        return ResponseEntity.ok(ApiResponse.getSuccessResult(memberService.findAll()));
    }




}
