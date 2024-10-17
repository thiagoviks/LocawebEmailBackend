package br.com.fiap.locaweb.LocawebEmail.repositories;

import br.com.fiap.locaweb.LocawebEmail.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
