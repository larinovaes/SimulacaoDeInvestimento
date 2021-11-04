package br.com.zup.projetoSimulacao.investidordto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvestidorDto {

    @Size(min = 2, max = 20 , message = "O Nome do investidor deve ter no minimo 2 letras e no maxima 20")
    @NotBlank
    private String nome;
    @Email(message = "Email invalido")
    private  String email;
    @CPF (message = "CPF invalido")
    private String cpf;
    private double valorInvestido;
    @Min(2)
    private int periodoDeAplicacaoMeses;
    private Risco risco;

    public InvestidorDto() {

    }

    public InvestidorDto(String nome, String email, String cpf, double valorInvestido, int periodoDeAplicacaoMeses, Risco taxaDeRisco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.valorInvestido = valorInvestido;
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
        this.risco = taxaDeRisco;
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

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }
}
