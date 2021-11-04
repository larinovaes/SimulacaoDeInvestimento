package br.com.zup.projetoSimulacao.investidordto;

public class Investidor {
    private String nome;
    private  String email;
    private String cpf;
    private double valorInvestido;
    private int periodoDeAplicacaoMeses;
    private Risco taxaDeRisco;

    public Investidor(String nome, String email, String cpf, double valorInvestido, int periodoDeAplicacaoMeses, Risco taxaDeRisco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.valorInvestido = valorInvestido;
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
        this.taxaDeRisco = taxaDeRisco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public int getPeriodoDeAplicacaoMeses() {
        return periodoDeAplicacaoMeses;
    }

    public void setPeriodoDeAplicacaoMeses(int periodoDeAplicacaoMeses) {
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
    }

    public Risco getTaxaDeRisco() {
        return taxaDeRisco;
    }

    public void setTaxaDeRisco(Risco taxaDeRisco) {
        this.taxaDeRisco = taxaDeRisco;
    }
}
