package com.gamereview.projeto_game_review.repositories;

import com.gamereview.projeto_game_review.models.PlataformaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlataformaRepository extends JpaRepository<PlataformaModel, UUID> {

    Optional<PlataformaModel> findByPlataformaIgnoreCase(String plataforma);

}
