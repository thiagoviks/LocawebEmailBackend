package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.AcoesEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.AcoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcoesService {

    @Autowired
    private AcoesRepository acoesRepository;

    public List<AcoesEntity> listarAcoes() {
        return acoesRepository.findAll();
    }

    public AcoesEntity obterAcao(Long id) {
        return acoesRepository.findById(id).orElse(null);
    }

    public AcoesEntity salvarAcao(AcoesEntity acao) {
        return acoesRepository.save(acao);
    }
}
