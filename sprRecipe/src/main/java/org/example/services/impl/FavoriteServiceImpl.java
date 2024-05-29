package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.model.Favorite;
import org.example.model.Recipe;
import org.example.model.User;
import org.example.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl {
    private final FavoriteRepository favoriteRepository;

    public void addToFavorites(User user, Recipe recipe) {
        Favorite favorite = Favorite.builder()
                .user(user)
                .recipe(recipe)
                .build();
        favoriteRepository.save(favorite);
    }

    public List<Favorite> getUserFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }

    public void removeFromFavorites(UUID id){
        favoriteRepository.deleteById(id);
    }
}
