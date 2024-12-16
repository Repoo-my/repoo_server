package com.repoo.auth.presentation.dto.request;

public record AdditionalInfoRequest(
        String userName,
        String userPhone,
        String userGender, // 여자 혹은 남자
        Integer userAge
) {
}
