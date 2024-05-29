package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.services.impl.AuthServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProfileController {

    AuthServiceImpl authService;

    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal) {
        String username = principal.getName();
        UserDetails user = authService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return "profile_view"; // Возвращаем имя представления
    }
}
