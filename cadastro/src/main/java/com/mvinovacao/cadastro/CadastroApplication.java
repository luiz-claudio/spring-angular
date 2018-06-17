package com.mvinovacao.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CadastroApplication extends SpringBootServletInitializer {
	
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {

	return applicationBuilder.sources(CadastroApplication.class);

}

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
		
	}
}
