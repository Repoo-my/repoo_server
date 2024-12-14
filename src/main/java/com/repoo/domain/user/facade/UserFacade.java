package com.repoo.domain.user.facade;

import com.repoo.domain.user.domain.Users;
import com.repoo.domain.user.domain.repository.UsersRepository;
import com.repoo.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UsersRepository userRepository;

    public Optional<Users> getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }
}
