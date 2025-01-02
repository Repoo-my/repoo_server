package com.repoo.domain.authentication.auth.presentation.dto.request;

public record AdditionalInfoRequest(
        String userName,
        String userGender, // 여자 혹은 남자
        Integer userAge
) {
}
