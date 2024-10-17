package br.com.fiap.locaweb.LocawebEmail.services;

import br.com.fiap.locaweb.LocawebEmail.entities.RegrasFiltragemEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.RegrasFiltragemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegrasFiltragemService {

    @Autowired
    private RegrasFiltragemRepository regrasFiltragemRepository;

    public List<RegrasFiltragemEntity> listarRegras() {
        return regrasFiltragemRepository.findAll();
    }

    public RegrasFiltragemEntity obterRegra(Long id) {
        return regrasFiltragemRepository.findById(id).orElse(null);
    }

    public RegrasFiltragemEntity salvarRegra(RegrasFiltragemEntity regra) {
        return regrasFiltragemRepository.save(regra);
    }
}
