package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.RegistrationForm;
import org.example.exception.UserAlreadyExistsException;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UsersRepository;
import org.example.security.UserDetailsImpl;
import org.example.services.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationForm form) throws UserAlreadyExistsException {
        if(usersRepository.existsByUsername(form.getUsername())) {
            throw new UserAlreadyExistsException("AHMEEEEED!");
        }
        User user = User.builder()
                .username(form.getUsername())
                .passwordHash(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("AHMED!!!!");
        }
        User user = optionalUser.get();
        return UserDetailsImpl.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash())
                .roles(List.of(user.getRole()))
                .build();
    }
}
