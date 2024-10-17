package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.PastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastaRepository extends JpaRepository<PastaEntity, Long> {
}
