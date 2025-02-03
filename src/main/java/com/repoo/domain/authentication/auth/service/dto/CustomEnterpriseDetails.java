package com.repoo.domain.authentication.auth.service.dto;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.user.domain.value.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomEnterpriseDetails implements UserDetails {

    private final Enterprise enterprise;


    private GrantedAuthority getAuthority(Authority role) {
        return new SimpleGrantedAuthority("ROLE_" + role.name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();

        switch (enterprise.getAuthority()) {
            case ENTERPRISE:
                authorityList.add(getAuthority(Authority.ENTERPRISE));
                break;
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return "OAuth2라서 password는 없습니다.";
    }

    @Override
    public String getUsername() {
        return enterprise.getEnterpriseName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public String getEmail() { return enterprise.getEnterpriseEmail(); }

    public Long getId() { return enterprise.getEnterpriseId(); }
}
