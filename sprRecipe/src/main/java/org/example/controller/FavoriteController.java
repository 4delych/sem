package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Favorite;
import org.example.model.Recipe;
import org.example.model.User;
import org.example.services.impl.FavoriteServiceImpl;
import org.example.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteServiceImpl favoriteService;
    private final UserServiceImpl userService;

    @GetMapping("/favorites")
    public String getUserFavorites(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());
        List<Favorite> favorites = favoriteService.getUserFavorites(user);
        model.addAttribute("favorites", favorites);
        return "favorites";
    }

    @PostMapping("/favorites/remove/{favoriteId}")
    public String removeFromFavorites(@PathVariable UUID favoriteId,Principal principal) {
        favoriteService.removeFromFavorites(favoriteId);
        return "redirect:/favorites"; // После удаления избранного перенаправляем на страницу с избранными рецептами
    }
}
