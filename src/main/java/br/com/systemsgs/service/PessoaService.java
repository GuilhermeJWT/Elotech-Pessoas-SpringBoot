package br.com.systemsgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public ModelPessoasDTO salvar(ModelPessoasDTO modelPessoasDTO) {
		ModelPessoas pessoasEntity = DozerConverter.converteEntidade(modelPessoasDTO, ModelPessoas.class);
		ModelPessoasDTO pessoaConvertida = DozerConverter.converteEntidade(pessoaRepository.save(pessoasEntity), ModelPessoasDTO.class);
		
		return pessoaConvertida;
	}
	
	public ModelPessoas salvar2(ModelPessoas modelPessoas) {
		return pessoaRepository.save(modelPessoas);
	}
	
	public List<ModelPessoasDTO> findAll() {
		return DozerConverter.converteList(pessoaRepository.findAll(), ModelPessoasDTO.class);
	}

	public ModelPessoasDTO findById(Long id) {
		ModelPessoas pessoasEntity = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException());
		
		return DozerConverter.converteEntidade(pessoasEntity, ModelPessoasDTO.class);
	}
		
	public ModelPessoasDTO atualizar(ModelPessoasDTO modelPessoasDTO) {
		ModelPessoas pessoasEntity = pessoaRepository.findById(modelPessoasDTO.getId()).orElseThrow(() -> new PessoaNaoEncontradaException());
		
		pessoasEntity.setCpf(modelPessoasDTO.getCpf());
		pessoasEntity.setNome(modelPessoasDTO.getNome());
		pessoasEntity.setDataNascimento(modelPessoasDTO.getDataNascimento());
		
		ModelPessoasDTO pessoaConvertida = DozerConverter.converteEntidade(pessoaRepository.save(pessoasEntity), ModelPessoasDTO.class);
		return pessoaConvertida;
	}	
	
	public void delete(Long id) {
		ModelPessoas pessoaEntity = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException());
		pessoaRepository.delete(pessoaEntity);
	}

}
