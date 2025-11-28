package com.gamestore.projeto_game_store.repositories;

import com.gamestore.projeto_game_store.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
