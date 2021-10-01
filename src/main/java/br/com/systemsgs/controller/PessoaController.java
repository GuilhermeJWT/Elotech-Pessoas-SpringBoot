package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
