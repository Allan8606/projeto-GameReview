package com.gamereview.projeto_game_review.dtos.response;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record PlataformaResponse(UUID id, String plataforma, Set<String> games) { }