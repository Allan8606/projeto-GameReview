package com.gamestore.projeto_game_store.controllers;

import com.gamestore.projeto_game_store.models.ReviewModel;
import com.gamestore.projeto_game_store.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/criar")
    public ReviewModel criar(ReviewModel reviewModel){
        return reviewService.criar(reviewModel);
    }
}
