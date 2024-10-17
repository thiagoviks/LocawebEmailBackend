package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.ConfiguracaoUsuarioEntity;
import br.com.fiap.locaweb.LocawebEmail.services.ConfiguracaoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracaoUsuarioController {

    @Autowired
    private ConfiguracaoUsuarioService configuracaoUsuarioService;

    @GetMapping
    public List<ConfiguracaoUsuarioEntity> listarConfiguracoes() {
        return configuracaoUsuarioService.listarConfiguracoes();
    }

    @GetMapping("/{id}")
    public ConfiguracaoUsuarioEntity obterConfiguracao(@PathVariable Long id) {
        return configuracaoUsuarioService.obterConfiguracao(id);
    }

    @PostMapping
    public ConfiguracaoUsuarioEntity salvarConfiguracao(@RequestBody ConfiguracaoUsuarioEntity configuracao) {
        return configuracaoUsuarioService.salvarConfiguracao(configuracao);
    }
}
