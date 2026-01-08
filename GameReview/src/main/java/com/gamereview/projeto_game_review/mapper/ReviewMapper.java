package com.gamereview.projeto_game_review.mapper;


import com.gamereview.projeto_game_review.dtos.request.ReviewRequest;
import com.gamereview.projeto_game_review.dtos.response.ReviewResponse;
import com.gamereview.projeto_game_review.models.ReviewModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReviewMapper {

    public static ReviewResponse paraReviewResponse(ReviewModel model){

        String titulo = model.getGame().getTitulo();

        return ReviewResponse.builder()
                .id(model.getId())
                .comentario(model.getComentario())
                .nota(model.getNota())
                .titulo(titulo)
                .build();
    }



    public static ReviewModel paraReviewModel(ReviewRequest request){
        return ReviewModel.builder()
                .comentario(request.comentario())
                .nota(request.nota())
                .build();
    }



}
