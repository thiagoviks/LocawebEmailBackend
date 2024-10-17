package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.RascunhoEntity;
import br.com.fiap.locaweb.LocawebEmail.services.RascunhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rascunhos")
public class RascunhoController {

    @Autowired
    private RascunhoService rascunhoService;

    @GetMapping
    public List<RascunhoEntity> listarRascunhos() {
        return rascunhoService.listarRascunhos();
    }

    @GetMapping("/{id}")
    public RascunhoEntity obterRascunho(@PathVariable Long id) {
        return rascunhoService.obterRascunho(id);
    }

    @PostMapping
    public RascunhoEntity salvarRascunho(@RequestBody RascunhoEntity rascunho) {
        return rascunhoService.salvarRascunho(rascunho);
    }
}
