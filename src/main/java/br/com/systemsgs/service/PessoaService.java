package br.com.systemsgs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.systemsgs.exception.RecursoNaoEncontradoException;
import br.com.systemsgs.model.ModelPessoas;
import br.com.systemsgs.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public ModelPessoas salvar (ModelPessoas modelPessoas){
		return pessoaRepository.save(modelPessoas);
	}

	public List<ModelPessoas> retornaListaPessoas() {
		return pessoaRepository.findAll();
	}

	public Optional<ModelPessoas> pesquisaPorId(Long id) {
		return pessoaRepository.findById(id);
	}

	@Transactional
	public ResponseEntity<?> deletePessoa(Long id) {
		pessoaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Transactional
	public ModelPessoas atualizarPessoa(ModelPessoas modelPessoas) {
		ModelPessoas pessoas = pessoaRepository.findById(modelPessoas.getId()).orElseThrow(() -> new RecursoNaoEncontradoException());
		
		pessoas.setCpf(modelPessoas.getCpf());
		pessoas.setNome(modelPessoas.getNome());
		pessoas.setDataNascimento(modelPessoas.getDataNascimento());
		
		return pessoaRepository.save(pessoas);
	}

}
