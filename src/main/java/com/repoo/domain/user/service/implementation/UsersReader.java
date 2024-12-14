package com.repoo.domain.user.service.implementation;

import com.repoo.domain.user.domain.Users;
import com.repoo.domain.user.domain.repository.UsersRepository;
import com.repoo.domain.user.exception.UserNotFoundException;
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
