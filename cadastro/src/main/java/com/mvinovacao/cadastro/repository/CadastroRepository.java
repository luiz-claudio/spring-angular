package com.mvinovacao.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvinovacao.cadastro.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	Cadastro findBylogin(String login);
	Cadastro findByemail(String email);

}
