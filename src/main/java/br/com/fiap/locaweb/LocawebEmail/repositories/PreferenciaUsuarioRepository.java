package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.PreferenciaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenciaUsuarioRepository  extends JpaRepository<PreferenciaUsuarioEntity, Long> {
}
