package com.repoo.global.security.principle;

import com.repoo.user.exception.UserNotFoundException;
import com.repoo.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return new AuthDetails(userFacade.getUserByEmail(email)
                .orElseThrow(UserNotFoundException::new));
    }
}