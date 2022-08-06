package me.java.spring.venda.config.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//tratamentos de erros:

@RestControllerAdvice
public class ErroValidacaoHandler {
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormulario> handle(MethodArgumentNotValidException e) {
		
		// lista com as mensagens de erros:
		List<ErroFormulario> listaErros = new ArrayList<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(err -> {
			String mensagem = messageSource.getMessage(err, LocaleContextHolder.getLocale());
			ErroFormulario erro = new ErroFormulario(err.getField(),mensagem );
			listaErros.add(erro);
		});
		return listaErros;	
	}
	

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public String handle(EntityNotFoundException e) {
			return "Recurso não encontrado";
	}
}
