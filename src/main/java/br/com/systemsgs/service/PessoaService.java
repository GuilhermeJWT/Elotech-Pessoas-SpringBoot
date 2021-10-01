package br.com.systemsgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.model.ModelPessoas;
import br.com.systemsgs.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ModelPessoas salvar (ModelPessoas modelPessoas){
		return pessoaRepository.save(modelPessoas);
	}

}
