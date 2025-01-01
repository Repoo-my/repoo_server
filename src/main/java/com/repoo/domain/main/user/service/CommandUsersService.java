package com.repoo.domain.main.user.service;

import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.presentation.dto.response.UserInfo;
import com.repoo.domain.main.user.service.implementation.UsersCreator;
import com.repoo.domain.main.user.service.implementation.UsersDeleter;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import com.repoo.domain.main.user.service.implementation.UsersUpdater;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandUsersService {

    private final UsersCreator usersCreator;
    private final UsersDeleter usersDeleter;
    private final UsersUpdater usersUpdater;
    private final UsersReader usersReader;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    public void save(Users user){
        usersCreator.save(user);
    }

    public void update(String accessToken, UserInfo userInfo){

        usersUpdater.update(
                usersReader.findById(
                        jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
                ),
                new Users(
                        userInfo.userName(),
                        userInfo.userAge(),
                        userInfo.userGender(),
                        userInfo.userEmail()
                )
        );
    }

    public void delete(String accessToken){
        usersDeleter.delete(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }
}
