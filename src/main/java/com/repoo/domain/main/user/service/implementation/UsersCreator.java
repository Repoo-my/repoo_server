package com.repoo.domain.main.user.service.implementation;

import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.domain.repository.UsersRepository;
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
