package com.gamestore.projeto_game_store.services;


import com.gamestore.projeto_game_store.models.PlataformaModel;
import com.gamestore.projeto_game_store.repositories.PlataformaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;


    public PlataformaModel criar(PlataformaModel plataformaModel){
        return plataformaRepository.save(plataformaModel);
    }

    public List<PlataformaModel> listarTodos(){
        return plataformaRepository.findAll();
    }
}
