package com.example.batchtest.response.common;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String message;

    /**
     * 단순 응답 성공
     */
    public static <T> ApiResponse getSuccessResult(T data){
        return ApiResponse.builder()
                .success(true)
                .data(data)
                .message("요청 성공")
                .build();
    }

    /**
     * 실패시
     */
    public static ApiResponse getFailResult(String message){
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .build();
    }

    /**
     * 성공일때 : 응답 + 메시지 사용하는 경우
     */
    public static <T> ApiResponse getDataResult( T data, String message){
        return ApiResponse.builder()
                .success(true)
                .data(data)
                .message(message)
                .build();
    }

}
