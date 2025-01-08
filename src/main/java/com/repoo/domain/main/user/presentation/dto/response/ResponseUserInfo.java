package com.repoo.domain.main.user.presentation.dto.response;

public record ResponseUserInfo(
    String userName,
    String userEmail,
    String userGender,
    Integer userAge
) {
}
