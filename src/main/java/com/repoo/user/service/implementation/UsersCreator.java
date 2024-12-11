package com.repoo.user.service.implementation;

import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersCreator {

    private final UsersRepository usersRepository;

    public void save(Users user){
        usersRepository.save(user);
    }
}
