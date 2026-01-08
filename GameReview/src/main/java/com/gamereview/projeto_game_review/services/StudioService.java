package com.gamereview.projeto_game_review.services;

import com.gamereview.projeto_game_review.dtos.request.StudioRequest;
import com.gamereview.projeto_game_review.dtos.response.StudioResponse;
import com.gamereview.projeto_game_review.mapper.StudioMapper;
import com.gamereview.projeto_game_review.models.StudioModel;
import com.gamereview.projeto_game_review.repositories.StudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioResponse criar(StudioRequest studioRequest){

        StudioModel studioModel = StudioMapper.paraStudioModel(studioRequest);
        StudioModel save = studioRepository.save(studioModel);

        return StudioMapper.paraStudioResponse(save);
    }

    public List<StudioResponse> listarTodos(){
        List<StudioModel> todosStudios = studioRepository.findAll();
        List<StudioResponse> list = todosStudios.stream()
                .map(StudioMapper::paraStudioResponse)
                .toList();

        return list;
    }

    public StudioResponse listarPorID(UUID id){
        StudioModel studioModel = studioRepository.findById(id).orElseThrow(() -> new RuntimeException("Studio não encontrado"));

        return StudioMapper.paraStudioResponse(studioModel);
    }

    public StudioResponse atualizar(StudioRequest studioRequest, UUID id){
        StudioModel studioModel = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio não encontrado"));

        studioModel.setNome(studioRequest.nome());
        StudioModel save = studioRepository.save(studioModel);

        return StudioMapper.paraStudioResponse(save);
    }

    public void deletar(UUID id){

        StudioModel studioModel = studioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Studio não encontrado"));

        studioRepository.delete(studioModel);

    }
}
