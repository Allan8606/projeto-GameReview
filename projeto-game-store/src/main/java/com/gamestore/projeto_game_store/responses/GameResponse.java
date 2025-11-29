package com.gamestore.projeto_game_store.responses;

import com.gamestore.projeto_game_store.models.PlataformaModel;

import java.util.Set;

public record GameResponse(
        String titulo,
        Set<PlataformaModel> plataformas,
        String reviewComentario,
        double reviewNota
) {
}
