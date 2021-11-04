package br.com.zup.projetoSimulacao.mensagemdeerro;

import br.com.zup.projetoSimulacao.investidordto.Risco;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception) {

        List<MensagemDeErro> mensagens = new ArrayList<>();

        for (FieldError fieldError: exception.getFieldErrors()) {
            mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage(), fieldError.getField()));
        }
        return mensagens;
    }

    @ExceptionHandler(RiscoNaoEncontrado.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarExcecoes(RiscoNaoEncontrado riscoNaoEncontrado) {
        return new MensagemDeErro(riscoNaoEncontrado.getMessage(),"risco");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarErroRisco(RuntimeException runtimeException) {
        return new MensagemDeErro("Risco não reconhecido","risco");
    }
}
