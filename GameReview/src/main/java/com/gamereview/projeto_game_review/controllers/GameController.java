package com.gamereview.projeto_game_review.controllers;


import com.gamereview.projeto_game_review.dtos.request.GameRequest;
import com.gamereview.projeto_game_review.dtos.response.GameResponse;
import com.gamereview.projeto_game_review.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/criar")
    public ResponseEntity<GameResponse> criar(@RequestBody GameRequest game){
        GameResponse salvo = gameService.criar(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/buscarPeloNome")
    public ResponseEntity<List<GameResponse>> buscarPeloNome(@RequestParam String titulo){
        List<GameResponse> gameResponses = gameService.buscarPeloTitulo(titulo);

        return ResponseEntity.ok(gameResponses);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<GameResponse>> listarTodos(){
        List<GameResponse> gamesResponses = gameService.listarTodos();
        return ResponseEntity.ok(gamesResponses);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<GameResponse> buscarPorId(@PathVariable UUID id){
        GameResponse gameResponse = gameService.buscarPorId(id);

        return ResponseEntity.ok(gameResponse);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<GameResponse> atualizarGame(@PathVariable UUID id, @RequestBody GameRequest gameRequest){
        GameResponse gameResponse = gameService.atualizarGame(id, gameRequest);

        return ResponseEntity.ok(gameResponse);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        gameService.deletar(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
