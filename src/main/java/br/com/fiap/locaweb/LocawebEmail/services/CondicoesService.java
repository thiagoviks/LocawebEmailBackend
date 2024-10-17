package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.CondicoesEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.CondicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicoesService {

    @Autowired
    private CondicoesRepository condicoesRepository;

    public List<CondicoesEntity> listarCondicoes() {
        return condicoesRepository.findAll();
    }

    public CondicoesEntity obterCondicao(Long id) {
        return condicoesRepository.findById(id).orElse(null);
    }

    public CondicoesEntity salvarCondicao(CondicoesEntity condicao) {
        return condicoesRepository.save(condicao);
    }
}
