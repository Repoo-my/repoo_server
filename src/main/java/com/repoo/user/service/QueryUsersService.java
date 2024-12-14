package com.repoo.user.service;

import com.repoo.user.domain.Users;
import com.repoo.user.service.implementation.UsersReader;
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
