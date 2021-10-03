package br.com.systemsgs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.systemsgs.config.DozerConverter;
import br.com.systemsgs.dto.ModelPessoasDTO;
import br.com.systemsgs.exception.PessoaNaoEncontradaException;
import br.com.systemsgs.model.ModelPessoas;
import br.com.systemsgs.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public ModelPessoasDTO salvar(ModelPessoasDTO modelPessoasDTO){
		ModelPessoas pessoasEntity = DozerConverter.converteEntidade(modelPessoasDTO, ModelPessoas.class);
		ModelPessoasDTO pessoaDTO = DozerConverter.converteEntidade(pessoaRepository.save(pessoasEntity), ModelPessoasDTO.class);
		
		return pessoaDTO;
	}
	
	@Transactional
	public ModelPessoas salvar2(ModelPessoas modelPessoas) {
		return pessoaRepository.save(modelPessoas);
	}

	public List<ModelPessoasDTO> retornaListaPessoas() {
		return DozerConverter.converteList(pessoaRepository.findAll(), ModelPessoasDTO.class);
	}

	public ResponseEntity<ModelPessoasDTO> pesquisaPorId(Long id) {
		ModelPessoas pessoasEntity = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException());
		ModelPessoasDTO pessoaConvertida = DozerConverter.converteEntidade(pessoasEntity, ModelPessoasDTO.class);
		return new ResponseEntity<ModelPessoasDTO>(pessoaConvertida, HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<ModelPessoas> deletePessoa(Long id) {
		pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException());
		
		return ResponseEntity.ok().build();
	}

	@Transactional
	public ModelPessoasDTO atualizarPessoa(ModelPessoasDTO modelPessoasDTO) {
		ModelPessoas pessoasEntity = pessoaRepository.findById(modelPessoasDTO.getId()).orElseThrow(() -> new PessoaNaoEncontradaException());
		
		pessoasEntity.setCpf(modelPessoasDTO.getCpf());
		pessoasEntity.setNome(modelPessoasDTO.getNome());
		pessoasEntity.setDataNascimento(modelPessoasDTO.getDataNascimento());
		
		ModelPessoasDTO pessoaDTO = DozerConverter.converteEntidade(pessoaRepository.save(pessoasEntity), ModelPessoasDTO.class);
		
		return pessoaDTO;
	}

}
