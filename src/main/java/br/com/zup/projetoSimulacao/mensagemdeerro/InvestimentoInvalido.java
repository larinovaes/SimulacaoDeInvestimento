package br.com.zup.projetoSimulacao.mensagemdeerro;

public class InvestimentoInvalido extends RuntimeException {

    private String mensagem;

    public InvestimentoInvalido(String mensagem) {
    super(mensagem);
    }
}
