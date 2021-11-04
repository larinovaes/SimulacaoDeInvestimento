package br.com.zup.projetoSimulacao.mensagemdeerro;

public class RiscoNaoEncontrado extends RuntimeException {

    public RiscoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
