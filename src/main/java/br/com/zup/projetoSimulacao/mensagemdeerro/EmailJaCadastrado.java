package br.com.zup.projetoSimulacao.mensagemdeerro;

public class EmailJaCadastrado extends RuntimeException{
    private String mensagem;

    public EmailJaCadastrado(String message, String mensagem) {
        super(message);

    }
}
