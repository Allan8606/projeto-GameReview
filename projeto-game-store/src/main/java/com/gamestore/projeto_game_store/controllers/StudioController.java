package com.gamestore.projeto_game_store.controllers;

import com.gamestore.projeto_game_store.models.ReviewModel;
import com.gamestore.projeto_game_store.models.StudioModel;
import com.gamestore.projeto_game_store.services.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studio")
@RequiredArgsConstructor
public class StudioController {

    private final StudioService studioService;


    @PostMapping("/criar")
    public StudioModel criar(@RequestBody StudioModel studioModel){
        return studioService.criar(studioModel);
    }

    @GetMapping("/listarTodos")
    public List<StudioModel> listarTodos(){
        return studioService.listarTodos();
    }
}
