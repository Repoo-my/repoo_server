package com.repoo.user.service.implementation;

import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import com.repoo.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersReader {

    private final UsersRepository usersRepository;

    public Users findById(Long id){
        return usersRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
