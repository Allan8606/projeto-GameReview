package com.gamereview.projeto_game_review.dtos.response;

import lombok.Builder;


import java.util.Set;
import java.util.UUID;

@Builder
public record StudioResponse(UUID id, String nome, Set<String> games) {
}
