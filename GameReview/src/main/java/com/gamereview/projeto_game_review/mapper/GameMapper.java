package com.gamereview.projeto_game_review.mapper;



import com.gamereview.projeto_game_review.dtos.request.GameRequest;
import com.gamereview.projeto_game_review.dtos.response.GameResponse;
import com.gamereview.projeto_game_review.models.GameModel;
import com.gamereview.projeto_game_review.models.PlataformaModel;
import com.gamereview.projeto_game_review.models.ReviewModel;
import com.gamereview.projeto_game_review.models.StudioModel;

import lombok.experimental.UtilityClass;


import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class GameMapper {


    public GameResponse paraResponse(GameModel gameModel){

        //Pegando apenas o nome das plataformas
        Set<String> listaNomes = gameModel.getPlataformas().stream()
                .map(p -> p.getPlataforma()).collect(Collectors.toSet());

        //Pegando apenas o comentario
        String comentario = gameModel.getReview().getComentario();

//      Pegando apenas o valor da nota
        double nota = gameModel.getReview().getNota();

        return GameResponse.builder()
                .id(gameModel.getId())
                .titulo(gameModel.getTitulo())
                .plataformas(listaNomes)
                .reviewComentario(comentario)
                .reviewNota(nota)
                .build();
    }


    public GameModel paraModel(GameRequest gameRequestDto,
                               StudioModel studio,
                               Set<PlataformaModel> plataformas,
                               ReviewModel review){


        return GameModel.builder()
                .titulo(gameRequestDto.titulo())
                .studio(studio)
                .plataformas(plataformas)
                .review(review)
                .build();
    }




}
