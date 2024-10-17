package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.CategoriaEntity;
import br.com.fiap.locaweb.LocawebEmail.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaEntity> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaEntity obterCategoria(@PathVariable Long id) {
        return categoriaService.obterCategoria(id);
    }

    @PostMapping
    public CategoriaEntity salvarCategoria(@RequestBody CategoriaEntity categoria) {
        return categoriaService.salvarCategoria(categoria);
    }
}
