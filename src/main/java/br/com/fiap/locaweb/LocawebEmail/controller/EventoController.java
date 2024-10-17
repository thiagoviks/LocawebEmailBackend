package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.EventoEntity;
import br.com.fiap.locaweb.LocawebEmail.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoEntity> listarEventos() {
        return eventoService.listarEventos();
    }

    @PostMapping
    public EventoEntity criarEvento(@RequestBody EventoEntity evento) {
        return eventoService.criarEvento(evento);
    }
}
