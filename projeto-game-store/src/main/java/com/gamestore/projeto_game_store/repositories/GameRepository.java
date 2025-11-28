package com.gamestore.projeto_game_store.repositories;

import com.gamestore.projeto_game_store.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<GameModel, UUID> {

    //buscar determinado game passando o nome do game
    List<GameModel> findByTituloContainingIgnoreCase(String titulo);
}
