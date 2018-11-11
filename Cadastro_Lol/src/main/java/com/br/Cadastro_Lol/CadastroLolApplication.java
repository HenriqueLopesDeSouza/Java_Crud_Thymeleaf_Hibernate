package com.br.Cadastro_Lol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.*"})
public class CadastroLolApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CadastroLolApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
}
