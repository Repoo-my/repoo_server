package com.repoo.domain.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {
    @Id
    private String token;

    private String email;

    public RefreshToken(
            String token, String email
    ) {
        this.token = token;
        this.email = email;
    }
}
