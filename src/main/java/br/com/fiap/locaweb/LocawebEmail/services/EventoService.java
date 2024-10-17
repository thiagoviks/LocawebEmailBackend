package br.com.fiap.locaweb.LocawebEmail.services;


import br.com.fiap.locaweb.LocawebEmail.entities.EventoEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoEntity> listarEventos() {
        return eventoRepository.findAll();
    }

    public EventoEntity criarEvento(EventoEntity evento) {
        return eventoRepository.save(evento);
    }
}
