package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.AnexoEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public List<AnexoEntity> listarAnexos() {
        return anexoRepository.findAll();
    }

    public AnexoEntity obterAnexo(Long id) {
        return anexoRepository.findById(id).orElse(null);
    }

    public AnexoEntity salvarAnexo(AnexoEntity anexo) {
        return anexoRepository.save(anexo);
    }
}
