package com.repoo.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long usersId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userGender;

    private String userAge;

    private String profileImg;

    public void update(String userName, String userPassword, String userEmail, String userGender, String userAge, String profileImg){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userAge = userAge;
        this.profileImg = profileImg;
    }
}
