package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.RotuloEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.RotuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotuloService {

    @Autowired
    private RotuloRepository rotuloRepository;

    public List<RotuloEntity> listarRotulos() {
        return rotuloRepository.findAll();
    }

    public RotuloEntity obterRotulo(Long id) {
        return rotuloRepository.findById(id).orElse(null);
    }

    public RotuloEntity salvarRotulo(RotuloEntity rotulo) {
        return rotuloRepository.save(rotulo);
    }
}
