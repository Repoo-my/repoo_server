package com.repoo.domain.main.user.presentation.dto.response;

public record UserInfo(
    String userName,
    String userEmail,
    String userGender,
    Integer userAge
) {
}
