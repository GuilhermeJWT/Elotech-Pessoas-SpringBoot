package br.com.systemsgs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoas")
public class ModelPessoas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome não pode estar em Branco!")
	@NotEmpty(message = "Nome não pode estar Vazio!")
	@NotNull(message = "Nome não pode estar Nulo!")
	private String nome;
	
	@NotBlank(message = "Cpf não pode estar em Branco!")
	@NotEmpty(message = "Cpf não pode estar Vazio!")
	@NotNull(message = "Cpf não pode estar Nulo!")
	@CPF(message = "Informe um Cpf Válido!")
	private String cpf;
	
	@NotBlank(message = "Data de Nascimento não pode estar em Branco!")
	@NotEmpty(message = "Data de Nascimento não pode estar Vazio!")
	@NotNull(message = "Data de Nascimento não pode estar Nulo!")
	private Date data_nascimento;

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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelPessoas other = (ModelPessoas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
