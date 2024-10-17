package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.AcoesEntity;
import br.com.fiap.locaweb.LocawebEmail.services.AcoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcoesController {

    @Autowired
    private AcoesService acoesService;

    @GetMapping
    public List<AcoesEntity> listarAcoes() {
        return acoesService.listarAcoes();
    }

    @GetMapping("/{id}")
    public AcoesEntity obterAcao(@PathVariable Long id) {
        return acoesService.obterAcao(id);
    }

    @PostMapping
    public AcoesEntity salvarAcao(@RequestBody AcoesEntity acao) {
        return acoesService.salvarAcao(acao);
    }
}
