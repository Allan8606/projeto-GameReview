package com.gamereview.projeto_game_review.mapper;


import com.gamereview.projeto_game_review.dtos.request.PlataformaRequest;
import com.gamereview.projeto_game_review.dtos.response.PlataformaResponse;
import com.gamereview.projeto_game_review.models.PlataformaModel;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class PlataformaMapper {

    public static PlataformaResponse paraPlataformaResponse(PlataformaModel plataformaModel){

        Set<String> games = plataformaModel.getGames().stream()
                .map(gameModel -> gameModel.getTitulo()).collect(Collectors.toSet());


        return PlataformaResponse.builder()
                .id(plataformaModel.getId())
                .games(games)
                .plataforma(plataformaModel.getPlataforma())
                .build();
    }


    public static PlataformaModel paraPlataformaModel(PlataformaRequest plataformaRequest){

        return PlataformaModel.builder()
                .plataforma(plataformaRequest.plataforma())
                .build();

    }





}
