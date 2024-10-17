package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.CondicoesEntity;
import br.com.fiap.locaweb.LocawebEmail.services.CondicoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condicoes")
public class CondicoesController {

    @Autowired
    private CondicoesService condicoesService;

    @GetMapping
    public List<CondicoesEntity> listarCondicoes() {
        return condicoesService.listarCondicoes();
    }

    @GetMapping("/{id}")
    public CondicoesEntity obterCondicao(@PathVariable Long id) {
        return condicoesService.obterCondicao(id);
    }

    @PostMapping
    public CondicoesEntity salvarCondicao(@RequestBody CondicoesEntity condicao) {
        return condicoesService.salvarCondicao(condicao);
    }
}
