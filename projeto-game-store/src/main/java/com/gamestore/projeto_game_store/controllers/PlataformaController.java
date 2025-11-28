package com.gamestore.projeto_game_store.controllers;

import com.gamestore.projeto_game_store.models.PlataformaModel;
import com.gamestore.projeto_game_store.repositories.PlataformaRepository;
import com.gamestore.projeto_game_store.services.PlataformaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataforma")
@RequiredArgsConstructor
public class PlataformaController {

    private final PlataformaService plataformaService;

    @PostMapping("/criar")
    public PlataformaModel criar(@RequestBody PlataformaModel plataformaModel){
        return plataformaService.criar(plataformaModel);
    }

    @GetMapping("/listarTodos")
    public List<PlataformaModel> listarTodos(){
        return plataformaService.listarTodos();
    }

}
