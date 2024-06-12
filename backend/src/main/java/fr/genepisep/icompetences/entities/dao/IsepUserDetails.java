package fr.genepisep.icompetences.entities.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class IsepUserDetails implements UserDetails {
    private final UserEntity user;

    public IsepUserDetails(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return user.getIsepId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getDisableDate() == null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getDisableDate() == null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return user.getDisableDate() == null;
    }
}