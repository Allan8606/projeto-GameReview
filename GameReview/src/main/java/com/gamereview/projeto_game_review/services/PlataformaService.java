package com.gamereview.projeto_game_review.services;


import com.gamereview.projeto_game_review.dtos.request.PlataformaRequest;
import com.gamereview.projeto_game_review.dtos.response.PlataformaResponse;
import com.gamereview.projeto_game_review.mapper.PlataformaMapper;
import com.gamereview.projeto_game_review.models.PlataformaModel;
import com.gamereview.projeto_game_review.repositories.GameRepository;
import com.gamereview.projeto_game_review.repositories.PlataformaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;
    private final GameRepository gameRepository;


    @Transactional
    public PlataformaResponse criar(PlataformaRequest plataformaRequest){

        Optional<PlataformaModel> existente =
                plataformaRepository.findByPlataformaIgnoreCase(plataformaRequest.plataforma());

        if (existente.isPresent()) {
            throw new RuntimeException("Plataforma já cadastrada!");
        }

        PlataformaModel plataformaModel = PlataformaMapper.paraPlataformaModel(plataformaRequest);
        PlataformaModel save = plataformaRepository.save(plataformaModel);
        PlataformaResponse plataformaResponse = PlataformaMapper.paraPlataformaResponse(save);

        return plataformaResponse;
    }

    public List<PlataformaResponse> listarTodos(){
        List<PlataformaModel> todasPlataformas = plataformaRepository.findAll();

        List<PlataformaResponse> list = todasPlataformas.stream()
                .map(PlataformaMapper::paraPlataformaResponse).toList();

        return list;
    }


    public PlataformaResponse atualizar(PlataformaRequest plataformaRequest, UUID id){
        PlataformaModel plataforma = plataformaRepository.findById(id).orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));

        plataforma.setPlataforma(plataformaRequest.plataforma());
        PlataformaModel save = plataformaRepository.save(plataforma);
        return PlataformaMapper.paraPlataformaResponse(save);

    }


    public void deletar(UUID id){
        PlataformaModel plataforma = plataformaRepository.findById(id).orElseThrow(() -> new RuntimeException("Plataforma não encontrada"));
        plataformaRepository.deleteById(id);
    }




}
