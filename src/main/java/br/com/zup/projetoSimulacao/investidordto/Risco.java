package br.com.zup.projetoSimulacao.investidordto;

public enum Risco {
    ALTO(0.25),
    MEDIO(0.15),
    BAIXO(0.05);

    private double valor;

    Risco(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
