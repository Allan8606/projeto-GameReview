package com.gamereview.projeto_game_review.dtos.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReviewResponse(UUID id, String comentario, double nota, String titulo) {
}
