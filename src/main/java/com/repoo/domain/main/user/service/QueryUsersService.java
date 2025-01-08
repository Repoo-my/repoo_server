package com.repoo.domain.main.user.service;

import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.presentation.dto.response.ResponseUserInfo;
import com.repoo.domain.main.user.service.implementation.UsersReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryUsersService {

    private final UsersReader usersReader;

    public Users getUser(Long id){
        return usersReader.findById(id);
    }

    public ResponseUserInfo getUserInfo(Long id){
        Users user = usersReader.findById(id);
        return new ResponseUserInfo(
                user.getUserName(),
                user.getUserEmail(),
                user.getUserGender(),
                user.getUserAge()
        );
    }

    public String getUserEmail(Long id){
        return usersReader.findById(id).getUserEmail();
    }
}
