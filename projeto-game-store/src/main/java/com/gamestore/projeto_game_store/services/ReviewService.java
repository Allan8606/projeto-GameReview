package com.gamestore.projeto_game_store.services;

import com.gamestore.projeto_game_store.models.ReviewModel;
import com.gamestore.projeto_game_store.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewModel criar(ReviewModel reviewModel){
        return reviewRepository.save(reviewModel);
    }
}
