package com.gamereview.projeto_game_review.dtos.response;


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
