package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.AnexoEntity;
import br.com.fiap.locaweb.LocawebEmail.services.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexos")
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @GetMapping
    public List<AnexoEntity> listarAnexos() {
        return anexoService.listarAnexos();
    }

    @GetMapping("/{id}")
    public AnexoEntity obterAnexo(@PathVariable Long id) {
        return anexoService.obterAnexo(id);
    }

    @PostMapping
    public AnexoEntity salvarAnexo(@RequestBody AnexoEntity anexo) {
        return anexoService.salvarAnexo(anexo);
    }
}
