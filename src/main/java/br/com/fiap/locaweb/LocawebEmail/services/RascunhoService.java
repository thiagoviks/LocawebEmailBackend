package br.com.fiap.locaweb.LocawebEmail.services;


import br.com.fiap.locaweb.LocawebEmail.entities.RascunhoEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.RascunhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RascunhoService {

    @Autowired
    private RascunhoRepository rascunhoRepository;

    public List<RascunhoEntity> listarRascunhos() {
        return rascunhoRepository.findAll();
    }

    public RascunhoEntity obterRascunho(Long id) {
        return rascunhoRepository.findById(id).orElse(null);
    }

    public RascunhoEntity salvarRascunho(RascunhoEntity rascunho) {
        return rascunhoRepository.save(rascunho);
    }
}
