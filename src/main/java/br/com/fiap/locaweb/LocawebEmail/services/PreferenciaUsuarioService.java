package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.PreferenciaUsuarioEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.PreferenciaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenciaUsuarioService {

    @Autowired
    private PreferenciaUsuarioRepository preferenciaUsuarioRepository;

    public List<PreferenciaUsuarioEntity> listarPreferencias() {
        return preferenciaUsuarioRepository.findAll();
    }

    public PreferenciaUsuarioEntity obterPreferencia(Long id) {
        return preferenciaUsuarioRepository.findById(id).orElse(null);
    }

    public PreferenciaUsuarioEntity salvarPreferencia(PreferenciaUsuarioEntity preferencia) {
        return preferenciaUsuarioRepository.save(preferencia);
    }
}
