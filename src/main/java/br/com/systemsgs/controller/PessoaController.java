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
	
	@DeleteMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		pessoaService.deletePessoa(id);
		
		return "Pessoa Deletada com Sucesso!!!";
	}
	
	/*
	@PostMapping(value = "/salvar")
	public ModelPessoasDTO salvaPessoa(@RequestBody @Valid ModelPessoasDTO modelPessoasDTO){
		return pessoaService.salvar(modelPessoasDTO);
	}
	
	@GetMapping(value = "/listarTodos")
	public List<ModelPessoasDTO> listaPessoas(){
		return pessoaService.retornaListaPessoas();
	}
	
	@GetMapping(value = "/pesquisar/{id}")
	public ResponseEntity<ModelPessoasDTO> pesquisaPorId(@PathVariable Long id) {
		return pessoaService.pesquisaPorId(id);
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
	
	
	*/
	@PostMapping(value = "/salvaPessoas")
	public ModelPessoas salvaPessoas2(@RequestBody @Valid ModelPessoas modelPessoas) {
		
		for (int posicao = 0; posicao < modelPessoas.getContatos().size(); posicao++) {
			modelPessoas.getContatos().get(posicao).setPessoas(modelPessoas);
		}
		
		return pessoaService.salvar2(modelPessoas);
	}

}
