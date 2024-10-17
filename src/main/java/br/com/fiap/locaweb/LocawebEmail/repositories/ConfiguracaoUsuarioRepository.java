package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.ConfiguracaoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoUsuarioRepository extends JpaRepository<ConfiguracaoUsuarioEntity, Long> {
}
