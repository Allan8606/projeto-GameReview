package com.gamereview.projeto_game_review.dtos.request;

import java.util.Set;
import java.util.UUID;

public record GameRequest(
        String titulo,
        UUID studioId,
        Set<UUID> plataformasIds,
        String reviewComentario,
        double reviewNota) {
}
