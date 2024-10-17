package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.PreferenciaUsuarioEntity;
import br.com.fiap.locaweb.LocawebEmail.services.PreferenciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaUsuarioController {

    @Autowired
    private PreferenciaUsuarioService preferenciaUsuarioService;

    @GetMapping
    public List<PreferenciaUsuarioEntity> listarPreferencias() {
        return preferenciaUsuarioService.listarPreferencias();
    }

    @GetMapping("/{id}")
    public PreferenciaUsuarioEntity obterPreferencia(@PathVariable Long id) {
        return preferenciaUsuarioService.obterPreferencia(id);
    }

    @PostMapping
    public PreferenciaUsuarioEntity salvarPreferencia(@RequestBody PreferenciaUsuarioEntity preferencia) {
        return preferenciaUsuarioService.salvarPreferencia(preferencia);
    }
}
