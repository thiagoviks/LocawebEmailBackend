package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.PastaEntity;
import br.com.fiap.locaweb.LocawebEmail.services.PastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pastas")
public class PastaController {

    @Autowired
    private PastaService pastaService;

    @GetMapping
    public List<PastaEntity> listarPastas() {
        return pastaService.listarPastas();
    }

    @GetMapping("/{id}")
    public PastaEntity obterPasta(@PathVariable Long id) {
        return pastaService.obterPasta(id);
    }

    @PostMapping
    public PastaEntity salvarPasta(@RequestBody PastaEntity pasta) {
        return pastaService.salvarPasta(pasta);
    }
}
