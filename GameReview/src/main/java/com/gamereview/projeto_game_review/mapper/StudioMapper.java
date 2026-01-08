package com.gamereview.projeto_game_review.mapper;


import com.gamereview.projeto_game_review.dtos.request.StudioRequest;
import com.gamereview.projeto_game_review.dtos.response.StudioResponse;
import com.gamereview.projeto_game_review.models.GameModel;
import com.gamereview.projeto_game_review.models.StudioModel;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class StudioMapper {

    public static StudioModel paraStudioModel(StudioRequest studioRequest){
        return StudioModel.builder()
                .nome(studioRequest.nome())
                .build();

    }


    public static StudioResponse paraStudioResponse(StudioModel studioModel){



        Set<String> collect = studioModel.getGames() == null
                ? Set.of()
                : studioModel.getGames()
                .stream()
                .map(GameModel::getTitulo)
                .collect(Collectors.toSet());



        return StudioResponse.builder()
                .id(studioModel.getId())
                .nome(studioModel.getNome())
                .games(collect)
                .build();
    }







}





