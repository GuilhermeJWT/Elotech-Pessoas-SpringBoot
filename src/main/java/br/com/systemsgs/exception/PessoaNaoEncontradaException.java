package br.com.systemsgs.exception;

public class PessoaNaoEncontradaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException() {
		super("Pessoa não Encontrada!!!");
	}

}
