package com.repoo.domain.main.user.service.implementation;

import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.domain.repository.UsersRepository;
import com.repoo.domain.main.user.presentation.dto.request.RequestUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersUpdater {

    private final UsersRepository usersRepository;

    public void update(Users updatableUser, RequestUserInfo userInfo){
        updatableUser.updateAdditionalInfo(
                userInfo.userName(),
                userInfo.userGender(),
                userInfo.userAge()
        );

        usersRepository.save(updatableUser);
    }
}
