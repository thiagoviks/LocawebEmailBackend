package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.RegrasFiltragemEntity;
import br.com.fiap.locaweb.LocawebEmail.services.RegrasFiltragemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regras-filtragem")
public class RegrasFiltragemController {

    @Autowired
    private RegrasFiltragemService regrasFiltragemService;

    @GetMapping
    public List<RegrasFiltragemEntity> listarRegras() {
        return regrasFiltragemService.listarRegras();
    }

    @GetMapping("/{id}")
    public RegrasFiltragemEntity obterRegra(@PathVariable Long id) {
        return regrasFiltragemService.obterRegra(id);
    }

    @PostMapping
    public RegrasFiltragemEntity salvarRegra(@RequestBody RegrasFiltragemEntity regra) {
        return regrasFiltragemService.salvarRegra(regra);
    }
}
