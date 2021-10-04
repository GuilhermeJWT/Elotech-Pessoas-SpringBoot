package br.com.systemsgs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.dto.ModelPessoasDTO;
import br.com.systemsgs.model.ModelPessoas;
import br.com.systemsgs.service.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	/*
	@PostMapping(value = "/salvaPessoas")
	public ModelPessoasDTO salvarPessoas(@RequestBody ModelPessoasDTO modelPessoasDTO) {
		return pessoaService.salvar(modelPessoasDTO);
	}
	*/
	
	@PostMapping(value = "/salvaPessoas")
	public ModelPessoas salvaPessoas2(@RequestBody @Valid ModelPessoas modelPessoas) {
		
		for (int posicao = 0; posicao < modelPessoas.getContatos().size(); posicao++) {
			modelPessoas.getContatos().get(posicao).setPessoas(modelPessoas);
		}
		
		System.out.println(modelPessoas.getContatos());
		
		return pessoaService.salvar2(modelPessoas);
	}
	
	@GetMapping(value = "/listarTodos")
	public List<ModelPessoasDTO> findAll() {
		return pessoaService.findAll();
	}	
	
	@GetMapping("/pesquisar/{id}")
	public ModelPessoasDTO findById(@PathVariable("id") Long id) {
		return pessoaService.findById(id);
	}	
	
	@PutMapping(value = "/atualizar")
	public ModelPessoasDTO atualizaPessoas(@RequestBody ModelPessoasDTO modelPessoasDTO) {
		return pessoaService.atualizar(modelPessoasDTO);
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.ok().build();
	}

}
