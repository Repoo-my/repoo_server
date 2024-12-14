package com.repoo.user.domain;

import com.repoo.user.domain.type.Authority;
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
  
    private String userEmail;

    private String userGender;

    private String userAge;

    private String profileImg;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public Users(String userEmail, Authority authority) {
        this.userEmail = userEmail;
        this.authority = authority;
    }

    public void update(String userName, String userGender, String userAge, String profileImg) {
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.profileImg = profileImg;
    }

    public void update(String userName, String userEmail, String userGender, String userAge, String profileImg){
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userAge = userAge;
        this.profileImg = profileImg;
    }
}
