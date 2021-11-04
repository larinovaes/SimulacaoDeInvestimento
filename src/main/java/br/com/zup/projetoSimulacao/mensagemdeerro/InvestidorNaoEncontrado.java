package br.com.zup.projetoSimulacao.mensagemdeerro;

public class InvestidorNaoEncontrado extends RuntimeException {

    private String mensagem;

    public InvestidorNaoEncontrado(String message) {
        super(message);
    }
}
