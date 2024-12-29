package com.repoo.domain.main.user.service.implementation;

import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.domain.repository.UsersRepository;
import com.repoo.domain.main.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersReader {

    private final UsersRepository usersRepository;

    public Users findById(Long id){
        return usersRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
