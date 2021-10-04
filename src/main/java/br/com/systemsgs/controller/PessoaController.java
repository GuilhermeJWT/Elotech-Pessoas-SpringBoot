package br.com.systemsgs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@PostMapping(value = "/salvaPessoas")
	public ModelPessoas salvaPessoas(@RequestBody @Valid ModelPessoas modelPessoas) {
		
		for (int posicao = 0; posicao < modelPessoas.getContatos().size(); posicao++) {
			modelPessoas.getContatos().get(posicao).setPessoas(modelPessoas);
		}
		
		System.out.println(modelPessoas.getContatos());
		
		return pessoaService.salvar2(modelPessoas);
	}
	
	@GetMapping(value = "/listarTodos")
	public List<ModelPessoasDTO> listaPessoas(){
		return pessoaService.retornaListaPessoas();
	}
	
	@GetMapping(value = "/pesquisar/{id}")
	public ResponseEntity<ModelPessoasDTO> pesquisaPorId(@PathVariable Long id) {
		ModelPessoasDTO pessoaPesquisada = pessoaService.pesquisaPorId(id);
		return new ResponseEntity<ModelPessoasDTO>(pessoaPesquisada, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	public ModelPessoasDTO atualizarPessoa(@RequestBody ModelPessoasDTO modelPessoasDTO) {
		return pessoaService.atualizarPessoa(modelPessoasDTO);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ModelPessoasDTO> deletePessoa(@PathVariable Long id){
		pessoaService.deletePessoa(id);
		return ResponseEntity.ok().build();
	}
	
	/*Endpoints feitos somente para testes!*/
	
	/*
	@PostMapping(value = "/salvar")
	public ResponseEntity<ModelPessoas> salvarPessoa(@RequestBody @Valid ModelPessoas modelPessoas){
		
		for (int posicao = 0; posicao < modelPessoas.getContatos().size(); posicao++) {
			modelPessoas.getContatos().get(posicao).setPessoas(modelPessoas);
		}
		
		ModelPessoas pessoaSalva = pessoaService.salvar2(modelPessoas);
		
		return new ResponseEntity<ModelPessoas>(pessoaSalva, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	public ResponseEntity<ModelPessoas> atualizarPessoa(@RequestBody ModelPessoas modelPessoas){
	
		for (int posicao = 0; posicao < modelPessoas.getContatos().size(); posicao++) {
			modelPessoas.getContatos().get(posicao).setPessoas(modelPessoas);
		}
		
		ModelPessoas pessoaAlterada = pessoaService.atualizarPessoa2(modelPessoas);
		return new ResponseEntity<ModelPessoas>(pessoaAlterada, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		pessoaService.deletePessoa(id);
		
		return "Pessoa Deletada com Sucesso!!!";
	}
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<ModelPessoasDTO> salvaPessoa(@RequestBody @Valid ModelPessoasDTO modelPessoasDTO){
		for (int posicao = 0; posicao < pessoasEntity.getContatos().size(); posicao++) {
			pessoasEntity.getContatos().get(posicao).setPessoas(pessoasEntity);
		}
		
		ModelPessoasDTO pessoaSalva = pessoaService.salvar(modelPessoasDTO);
		
		return new ResponseEntity<ModelPessoasDTO>(pessoaSalva, HttpStatus.OK);
	}
	
	*/

}
