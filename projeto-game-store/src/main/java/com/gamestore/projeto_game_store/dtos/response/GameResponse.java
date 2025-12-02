package com.gamestore.projeto_game_store.dtos.response;


import com.gamestore.projeto_game_store.models.PlataformaModel;
import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record GameResponse(
        UUID id,
        String titulo,
        Set<String> plataformas,
        String reviewComentario,
        double reviewNota
) {
}
