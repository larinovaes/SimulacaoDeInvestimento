package br.com.zup.projetoSimulacao.mensagemdeerro;

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

    @ExceptionHandler(InvestimentoInvalido.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarErroInvestimento(InvestimentoInvalido investimentoInvalido) {
        return new MensagemDeErro("Esse valor é invalido para o tipo de risco","Valor Investido");
    }
    @ExceptionHandler(InvestidorNaoEncontrado.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarErroInvestidorNaoEncontrado(InvestidorNaoEncontrado investidorNaoEncontrado) {
        return new MensagemDeErro("Esse investidor não existe","Nome de Investidor");
    }
    @ExceptionHandler(EmailJaCadastrado.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarErroEmailRepetido(EmailJaCadastrado emailJaCadastrado) {
        return new MensagemDeErro("Esse email já está cadastrado no sistema","Email");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipluarErroRisco(RuntimeException runtimeException) {
        return new MensagemDeErro("Risco não reconhecido","risco");
    }
}
