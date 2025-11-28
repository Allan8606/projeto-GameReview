package com.gamestore.projeto_game_store.repositories;

import com.gamestore.projeto_game_store.models.StudioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudioRepository extends JpaRepository<StudioModel, UUID> {
}
