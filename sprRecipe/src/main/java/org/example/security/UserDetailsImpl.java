package org.example.security;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Builder
@Data
public class UserDetailsImpl implements UserDetails {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final Role role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
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
        return true;
    }
}
