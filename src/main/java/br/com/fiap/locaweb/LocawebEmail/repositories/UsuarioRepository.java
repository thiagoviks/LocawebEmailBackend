package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
