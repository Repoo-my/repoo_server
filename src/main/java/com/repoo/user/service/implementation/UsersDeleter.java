package com.repoo.user.service.implementation;

import com.repoo.user.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDeleter {

    private final UsersRepository usersRepository;

    public void delete(Long id){
        usersRepository.deleteById(id);
    }
}
