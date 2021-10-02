package br.com.systemsgs.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.systemsgs.exception.RecursoNaoEncontradoException;
import br.com.systemsgs.model.ModelPessoas;
import br.com.systemsgs.service.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping(value = "/salvar")
	public ModelPessoas salvaPessoa(@RequestBody @Valid ModelPessoas modelPessoas){
		return pessoaService.salvar(modelPessoas);
	}
	
	@GetMapping(value = "/listarTodos")
	public List<ModelPessoas> listaPessoas(){
		return pessoaService.retornaListaPessoas();
	}
	
	@GetMapping(value = "/pesquisar/{id}")
	public Optional<ModelPessoas> pesquisaPorId(@PathVariable Long id) {
		return pessoaService.pesquisaPorId(id);
	}
	
	@PutMapping(value = "/atualizar")
	public ModelPessoas atualizarPessoa(@RequestBody ModelPessoas modelPessoas) {
		//ModelPessoas pessoa = pessoaService.pesquisaPorId(modelPessoas.getId()).orElseThrow(() -> new  RecursoNaoEncontradoException());
		return pessoaService.atualizarPessoa(modelPessoas);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ModelPessoas> deletePessoa(@PathVariable Long id){
		pessoaService.deletePessoa(id);
		return ResponseEntity.ok().build();
	}

}
