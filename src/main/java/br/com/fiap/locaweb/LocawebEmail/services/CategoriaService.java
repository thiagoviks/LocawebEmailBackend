package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.CategoriaEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaEntity> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaEntity obterCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public CategoriaEntity salvarCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }
}
