package br.com.systemsgs.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.systemsgs.model.ModelContatos;

public class ModelPessoasDTO {
	
	private Long id;
	
	@NotBlank(message = "Nome não pode estar em Branco!")
	private String nome;
	
	@NotBlank(message = "Cpf não pode estar em Branco!")
	@CPF(message = "Informe um Cpf Válido!")
	private String cpf;

	@NotNull(message = "A Data de Nascimento não pode ser Nula!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotBlank(message = "Nome do Contato não pode estar em Branco!")
	private String nomeContato;
	
	@NotBlank(message = "Telefone do Contato não pode estar em Branco!")
	private String telefone;
	
	@NotBlank(message = "E-Mail do Contato não pode estar em Branco!")
	@Email(message = "E-Mail deve ser Válido!")
	private String email;
	
	private List<ModelContatos> contatos;
	
	public List<ModelContatos> getContatos() {
		return contatos;
	}
	
	public void setContatos(List<ModelContatos> contatos) {
		this.contatos = contatos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
