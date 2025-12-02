package com.gamestore.projeto_game_store.dtos.request;

import java.util.Set;
import java.util.UUID;

public record GameRequest(
        String titulo,
        UUID studioId,
        Set<UUID> plataformasIds,
        String reviewComentario,
        double reviewNota) {
}
