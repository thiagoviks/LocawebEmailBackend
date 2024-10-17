package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
