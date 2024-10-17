package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.EmailEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public List<EmailEntity> listarEmails() {
        return emailRepository.findAll();
    }

    public EmailEntity obterEmail(Long id) {
        return emailRepository.findById(id).orElse(null);
    }

    public EmailEntity enviarEmail(EmailEntity email) {
        email.setDataEnvio(new Date());
        email.setStatus("Enviado");
        return emailRepository.save(email);
    }
}
