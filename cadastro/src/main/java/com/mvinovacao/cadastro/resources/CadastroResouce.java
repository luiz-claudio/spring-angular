package com.mvinovacao.cadastro.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvinovacao.cadastro.exception.NotFoundException;
import com.mvinovacao.cadastro.model.Cadastro;
import com.mvinovacao.cadastro.repository.CadastroRepository;

@RestController
@RequestMapping("/cadastro")
public class CadastroResouce {

	@Autowired
	private CadastroRepository cadastroRepository;	
	
	

	public CadastroResouce(CadastroRepository cadastroRepository) {
		this.cadastroRepository = cadastroRepository;

	}

	@GetMapping
	public List<Cadastro> findAll() {
		return this.cadastroRepository.findAll();
	}

	@PostMapping
	@ResponseBody
	public Cadastro create(@RequestBody Cadastro cadastro, BindingResult bindingResult) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		cadastro.setSenha(passwordEncoder.encode(cadastro.getSenha()));
		return this.cadastroRepository.save(cadastro);
		
	}

	@GetMapping("/{id}")
	public Cadastro findById(@PathVariable(value = "id") Long id) {
		return this.cadastroRepository.findById(id).orElseThrow(() -> new NotFoundException("Cadastro", id));
	}

	@PutMapping("/{id}")
	public Cadastro update(@PathVariable(value = "id") Long id, @RequestBody Cadastro newCadastro) {
		Cadastro cadastro = this.cadastroRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Cadastro", id));
		cadastro.setEmail(newCadastro.getEmail());
		Cadastro updateCadastro = this.cadastroRepository.save(cadastro);
		return updateCadastro;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
		Cadastro cadastro = this.cadastroRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Cadastro", id));
		this.cadastroRepository.delete(cadastro);
		return ResponseEntity.ok().build();
	}
	

	// metodo para buscar pelo login!
	public Cadastro findBylogin(String login) {

		return this.cadastroRepository.findBylogin(login);
	}

	// metodo para buscar pelo email!
	public Cadastro findByemail(String email) {

		return this.cadastroRepository.findByemail(email);
	}

}
