package com.repoo.domain.authentication.auth.service;

import com.repoo.domain.authentication.auth.service.dto.CustomUserDetails;
import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.domain.repository.UsersRepository;
import com.repoo.domain.main.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = userRepository.findByUserEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if (user != null) {
            return new CustomUserDetails(user);
        }

        return null;
    }
}
