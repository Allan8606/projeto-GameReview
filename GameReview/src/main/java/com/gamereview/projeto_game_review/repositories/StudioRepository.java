package com.gamereview.projeto_game_review.repositories;

import com.gamereview.projeto_game_review.models.StudioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudioRepository extends JpaRepository<StudioModel, UUID> {
}
