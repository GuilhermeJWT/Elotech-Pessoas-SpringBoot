package br.com.systemsgs.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(PessoaNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestApiErrorsException pessoaNaoEncontradaException(PessoaNaoEncontradaException pessoaNaoEncontrada) {
		return new RestApiErrorsException(pessoaNaoEncontrada.getMessage());
	}
	
	@ExceptionHandler(GenerationExceptionClass.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestApiErrorsException tratamentoException(GenerationExceptionClass generationExceptionClass) {
		String mensagemErro = generationExceptionClass.getLocalizedMessage();
		return new RestApiErrorsException(mensagemErro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RestApiErrorsException exibeErrosParaCliente(MethodArgumentNotValidException methodArgumentNotValidException) {
		List<String> errors = methodArgumentNotValidException.getBindingResult().getAllErrors().stream()
				.map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

		return new RestApiErrorsException(errors);

	}

}
