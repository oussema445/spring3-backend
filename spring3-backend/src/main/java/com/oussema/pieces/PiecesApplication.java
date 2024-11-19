package com.oussema.pieces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.oussema.pieces.entities.Nature;
import com.oussema.pieces.entities.Pieces;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class PiecesApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(PiecesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Pieces.class);
		repositoryRestConfiguration.exposeIdsFor(Nature.class);
	}

}
