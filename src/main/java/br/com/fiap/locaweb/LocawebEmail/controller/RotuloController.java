package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.RotuloEntity;
import br.com.fiap.locaweb.LocawebEmail.services.RotuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotulos")
public class RotuloController {

    @Autowired
    private RotuloService rotuloService;

    @GetMapping
    public List<RotuloEntity> listarRotulos() {
        return rotuloService.listarRotulos();
    }

    @GetMapping("/{id}")
    public RotuloEntity obterRotulo(@PathVariable Long id) {
        return rotuloService.obterRotulo(id);
    }

    @PostMapping
    public RotuloEntity salvarRotulo(@RequestBody RotuloEntity rotulo) {
        return rotuloService.salvarRotulo(rotulo);
    }
}
