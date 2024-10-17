package br.com.fiap.locaweb.LocawebEmail.controller;

import br.com.fiap.locaweb.LocawebEmail.entities.EmailEntity;
import br.com.fiap.locaweb.LocawebEmail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<EmailEntity> listarEmails() {
        return emailService.listarEmails();
    }

    @GetMapping("/{id}")
    public EmailEntity obterEmail(@PathVariable Long id) {
        return emailService.obterEmail(id);
    }

    @PostMapping("/enviar")
    public EmailEntity enviarEmail(@RequestBody EmailEntity email) {
        return emailService.enviarEmail(email);
    }
}
