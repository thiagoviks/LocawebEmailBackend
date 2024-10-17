package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.ConfiguracaoUsuarioEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.ConfiguracaoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoUsuarioService {

    @Autowired
    private ConfiguracaoUsuarioRepository configuracaoUsuarioRepository;

    public List<ConfiguracaoUsuarioEntity> listarConfiguracoes() {
        return configuracaoUsuarioRepository.findAll();
    }

    public ConfiguracaoUsuarioEntity obterConfiguracao(Long id) {
        return configuracaoUsuarioRepository.findById(id).orElse(null);
    }

    public ConfiguracaoUsuarioEntity salvarConfiguracao(ConfiguracaoUsuarioEntity configuracao) {
        return configuracaoUsuarioRepository.save(configuracao);
    }
}
