package com.repoo.domain.main.user.domain;

import com.repoo.domain.main.user.domain.value.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
  
    private String userEmail;

    private String userGender;

    private Integer userAge;

//    private String profileImg;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    private String type;

    @Builder(builderMethodName = "normalUserBuilder")
    public Users(String username, String email, String userGender, String type, Integer age, Authority role) {
        this.authority = role;
        this.userName = username;
        this.type = type;
        this.userEmail = email;
        this.userAge = age;
        this.userGender = userGender;
//        this.profileImg = profileImg;
    }

    @Builder(builderMethodName = "socialUserBuilder")
    public Users(String email, Authority role, String type) {
        this.userEmail = email;
        this.authority = role;
        this.type = type;
    }

    @Builder(builderMethodName = "jwtUserBuilder")
    public Users(String email, Authority role) {
        this.userEmail = email;
        this.authority = role;
    }

    @Builder(builderMethodName = "updateUserBuilder")
    public Users(String username, Integer age, String Gender, String email) {
        this.userName = username;
        this.userAge = age;
        this.userGender = Gender;
        this.userEmail = email;
//        this.profileImg = profileImg;
    }

    public void updateSocial(String email, String type) {
        this.userEmail = email;
        this.type = type;
    }

    public void updateAdditionalInfo(String userName, String userGender, Integer userAge) {
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
//        this.profileImg = profileImg;
    }

    public void updateRole(Authority role) {
        this.authority = role;
    }

    public void update(String userName, String userEmail, String userGender, Integer userAge){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userAge = userAge;
//        this.profileImg = profileImg;
    }
}
