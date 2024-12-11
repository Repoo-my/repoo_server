package com.repoo.user.service.implementation;

import com.repoo.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersUpdater {

    public void update(Users updatableUser, Users user){
        updatableUser.update(
                user.getUserName(),
                user.getUserPassword(),
                user.getUserEmail(),
                user.getUserGender(),
                user.getUserAge(),
                user.getProfileImg()
        );
    }
}