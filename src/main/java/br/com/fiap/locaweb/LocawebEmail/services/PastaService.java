package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.PastaEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.PastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastaService {

    @Autowired
    private PastaRepository pastaRepository;

    public List<PastaEntity> listarPastas() {
        return pastaRepository.findAll();
    }

    public PastaEntity obterPasta(Long id) {
        return pastaRepository.findById(id).orElse(null);
    }

    public PastaEntity salvarPasta(PastaEntity pasta) {
        return pastaRepository.save(pasta);
    }
}
