package br.com.zup.projetoSimulacao.investidordto;

public enum Risco {
ALTO (0.025), MEDIO(0.015), BAIXO(0.005);

private double valor;

    Risco(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
