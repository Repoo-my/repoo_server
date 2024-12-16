package com.repoo.oauth.service.dto;

import com.repoo.user.domain.value.Authority;
import lombok.Builder;

public record UserDto(
        Authority role,
        Long id
) {

    @Builder
    public UserDto(Authority role, Long id) {
        this.role = role;
        this.id = id;
    }

}
