package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelPessoas;

@Repository
public interface PessoaRepository extends JpaRepository<ModelPessoas, Long>{

}
