package com.repoo.user.presentation.dto.response;

public record UserInfo(
    String userName,
    String userEmail,
    String userPhone,
    String userGender,
    Integer userAge
) {
}
