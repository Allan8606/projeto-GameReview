package com.gamereview.projeto_game_review.services;


import com.gamereview.projeto_game_review.dtos.request.GameRequest;
import com.gamereview.projeto_game_review.dtos.response.GameResponse;
import com.gamereview.projeto_game_review.mapper.GameMapper;
import com.gamereview.projeto_game_review.models.GameModel;
import com.gamereview.projeto_game_review.models.PlataformaModel;
import com.gamereview.projeto_game_review.models.ReviewModel;
import com.gamereview.projeto_game_review.models.StudioModel;
import com.gamereview.projeto_game_review.repositories.GameRepository;
import com.gamereview.projeto_game_review.repositories.PlataformaRepository;
import com.gamereview.projeto_game_review.repositories.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final PlataformaRepository plataformaRepository;
    private final StudioRepository studioRepository;

    @Transactional
    public GameResponse criar(GameRequest gameRequestDto){

        GameModel game = new GameModel();

        game.setTitulo(gameRequestDto.titulo());

        StudioModel studioModel = studioRepository.findById(gameRequestDto.studioId())
                .orElseThrow(() -> new RuntimeException("Studio não encontrado"));

        game.setStudio(studioModel);

        Set<UUID> plataformasIds = gameRequestDto.plataformasIds();
        Set<PlataformaModel> listaIdsPlataformas = plataformaRepository.findAllById(plataformasIds).stream()
                .collect(Collectors.toSet());
        game.setPlataformas(listaIdsPlataformas);


        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComentario(gameRequestDto.reviewComentario());
        reviewModel.setGame(game);
        reviewModel.setNota(gameRequestDto.reviewNota());

        game.setReview(reviewModel);

        GameModel save = gameRepository.save(game);
        GameResponse gameResponse = GameMapper.paraResponse(save);
        return gameResponse;
    }

    public List<GameResponse> buscarPeloTitulo(String titulo){
        List<GameModel> listaNomes = gameRepository.findByTituloContainingIgnoreCase(titulo);

       return listaNomes.stream()
                .map(game -> GameMapper.paraResponse(game))
                .toList();
    }

    public GameResponse buscarPorId(UUID id) {
        GameModel game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));

        return GameMapper.paraResponse(game);
    }


    public List<GameResponse> listarTodos(){

        List<GameModel> todosGames = gameRepository.findAll();
        return todosGames.stream()
                .map(GameMapper::paraResponse).toList();
    }

    @Transactional
    public GameResponse atualizarGame(UUID id, GameRequest gameRequest) {

        GameModel gameEncontrado = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));

        gameEncontrado.setTitulo(gameRequest.titulo());

        StudioModel studio = studioRepository.findById(gameRequest.studioId())
                .orElseThrow(() -> new RuntimeException("Studio não encontrado"));
        gameEncontrado.setStudio(studio);


        Set<PlataformaModel> plataformas = plataformaRepository.findAllById(gameRequest.plataformasIds())
                .stream()
                .collect(Collectors.toSet());
        gameEncontrado.setPlataformas(plataformas);

        ReviewModel review = gameEncontrado.getReview();
        if (review == null) {
            review = new ReviewModel();
            review.setGame(gameEncontrado); // importante no OneToOne
        }

        review.setComentario(gameRequest.reviewComentario());
        review.setNota(gameRequest.reviewNota());
        gameEncontrado.setReview(review);

        GameModel atualizado = gameRepository.save(gameEncontrado);

        return GameMapper.paraResponse(atualizado);
    }


    @Transactional
    public void deletar(UUID id) {
        GameModel game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));
        gameRepository.delete(game);
    }

}
