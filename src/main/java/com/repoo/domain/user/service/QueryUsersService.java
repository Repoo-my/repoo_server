package com.repoo.domain.user.service;

import com.repoo.domain.user.domain.Users;
import com.repoo.domain.user.service.implementation.UsersReader;
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
