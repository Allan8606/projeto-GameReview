package com.gamereview.projeto_game_review.repositories;

import com.gamereview.projeto_game_review.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
