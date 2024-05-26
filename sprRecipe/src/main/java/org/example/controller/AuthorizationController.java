package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.RegistrationForm;
import org.example.exception.UserAlreadyExistsException;
import org.example.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@AllArgsConstructor
public class AuthorizationController {
    private final AuthService authService;

    @GetMapping("/sign-in")
    String signInView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "sign_in_view";
    }

    @GetMapping("/sign-up")
    String signUpView() {
        return "sign_up_view";
    }

    @PostMapping("/sign-up")
    String signUp(@ModelAttribute @Valid RegistrationForm form) throws UserAlreadyExistsException {
        authService.register(form);
        return "redirect:/test";
    }
}
