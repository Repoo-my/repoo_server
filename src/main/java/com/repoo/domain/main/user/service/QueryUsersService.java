package com.repoo.domain.main.user.service;

import com.repoo.domain.main.user.domain.Users;
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
}
