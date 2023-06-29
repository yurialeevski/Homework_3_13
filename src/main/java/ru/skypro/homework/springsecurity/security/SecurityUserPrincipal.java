package ru.skypro.homework.springsecurity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.homework.springsecurity.pojo.AuthUser;

import java.util.*;
import java.util.stream.Collectors;

public class SecurityUserPrincipal implements UserDetails {

    private AuthUser authUser;
    private Collection<? extends GrantedAuthority> authorities;

    public SecurityUserPrincipal(AuthUser authUser) {
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = authUser.getRole().name();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (authUser.getEnabled() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }
}
