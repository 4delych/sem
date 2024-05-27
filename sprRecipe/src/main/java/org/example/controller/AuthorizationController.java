package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.SignUpForm;
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
    String signInView(@RequestParam(required = false) String error, String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
        }
        if (logout != null) {
            model.addAttribute("logout", "Вы успешно вышли из аккаунта");
        }
        return "sign_in_view";
    }


    @GetMapping("/sign-up")
    String signUpView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "sign_up_view";
    }

    @PostMapping("/sign-up")
    String signUp(@ModelAttribute @Valid SignUpForm form, Model model) {
        try {
            authService.register(form);
            return "redirect:/profile";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "sign_up_view";
        }
    }

}
