package com.repoo.auth.service;

import com.repoo.auth.service.dto.CustomUserDetails;
import com.repoo.user.domain.Users;
import com.repoo.user.domain.repository.UsersRepository;
import com.repoo.user.exception.UserNotFoundException;
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
