package com.repoo.global.jwt.util;

import com.repoo.domain.authentication.auth.service.dto.CustomUserDetails;
import com.repoo.domain.main.user.domain.value.Authority;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthenticationUtil {


    public static Long getMemberId() {
        var anonymous = String.valueOf(isAnonymous());
        log.warn(anonymous);
        if (isAnonymous()) {
            return null;
        }
        return (Long) getAuthentication().getPrincipal();
    }

    public static String getEmail() {
        Authentication authentication = getAuthentication();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        return principal.getEmail();
    }

    private static Authority extractRoleFromAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .map(Authority::valueOf)
                .findFirst()
                .orElse(Authority.USER);
    }

    public static boolean isAnonymous() {
        Authentication authentication = getAuthentication();
        return authentication == null || authentication.getPrincipal().equals("anonymousUser");
    }


    private static Authentication getAuthentication() {
        var context = SecurityContextHolder.getContext();
        log.info("Context :"+ context);
        var result = context.getAuthentication();
        log.info("result : " + result);
        return result;
    }
}
