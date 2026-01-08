package com.gamereview.projeto_game_review.services;

import com.gamereview.projeto_game_review.dtos.request.ReviewRequest;
import com.gamereview.projeto_game_review.dtos.response.ReviewResponse;
import com.gamereview.projeto_game_review.mapper.ReviewMapper;
import com.gamereview.projeto_game_review.models.GameModel;
import com.gamereview.projeto_game_review.models.ReviewModel;
import com.gamereview.projeto_game_review.repositories.GameRepository;
import com.gamereview.projeto_game_review.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;


    public List<ReviewResponse> listarTodos(){
        List<ReviewResponse> list = reviewRepository.findAll()
                .stream()
                .map(ReviewMapper::paraReviewResponse)
                .toList();

        return list;
    }


    public ReviewResponse atualizar(ReviewRequest reviewRequest, UUID idGame){

        GameModel buscarGame = gameRepository.findById(idGame).orElseThrow(() -> new RuntimeException("Game não encontrado"));

        ReviewModel reviewAtual = buscarGame.getReview();
        reviewAtual.setComentario(reviewRequest.comentario());
        reviewAtual.setNota(reviewRequest.nota());

        gameRepository.save(buscarGame);

        return ReviewMapper.paraReviewResponse(reviewAtual);
    }
}
