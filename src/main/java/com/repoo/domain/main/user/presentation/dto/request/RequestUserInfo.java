package com.repoo.domain.main.user.presentation.dto.request;

public record RequestUserInfo(
    String userName,
    String userGender,
    Integer userAge
) {
}
