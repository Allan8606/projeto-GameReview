package com.gamestore.projeto_game_store.services;

import com.gamestore.projeto_game_store.models.StudioModel;
import com.gamestore.projeto_game_store.repositories.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioModel criar(StudioModel studioModel){
        return studioRepository.save(studioModel);
    }

    public List<StudioModel> listarTodos(){
        return studioRepository.findAll();
    }
}
