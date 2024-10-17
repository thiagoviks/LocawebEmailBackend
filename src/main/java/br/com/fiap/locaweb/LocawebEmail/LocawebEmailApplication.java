package br.com.fiap.locaweb.LocawebEmail;

import br.com.fiap.locaweb.LocawebEmail.entities.UsuarioEntity;
import br.com.fiap.locaweb.LocawebEmail.repositories.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class LocawebEmailApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(LocawebEmailApplication.class, args);


		UsuarioRepository usuarioRepository = ctxt.getBean(UsuarioRepository.class);
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome("Thiago");
		usuarioEntity.setEmail("thiago@gmail.com");
		usuarioEntity.setSenha("123456");
		usuarioEntity.setDataCadastro(new Date());
		usuarioRepository.save(usuarioEntity);
		ctxt.close();

	}

}
