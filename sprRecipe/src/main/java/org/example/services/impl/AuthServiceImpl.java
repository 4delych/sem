package org.example.services.impl;

import lombok.AllArgsConstructor;

import org.example.dto.SignUpForm;
import org.example.exception.UserAlreadyExistsException;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(SignUpForm form) throws UserAlreadyExistsException {
            if(userRepository.existsByUsername(form.getUsername())) {
                throw new UserAlreadyExistsException("already exist");
            }
            User user = User.builder()
                    .firstname(form.getFirstName())
                    .lastname(form.getLastName())
                    .username(form.getUsername())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .role(Role.ROLE_USER)
                    .build();
            userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("not found");
        }
        User user = optionalUser.get();
        return UserDetailsImpl.builder()
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .password(user.getPassword())
                .roles(List.of(user.getRole()))
                .build();
    }
}
