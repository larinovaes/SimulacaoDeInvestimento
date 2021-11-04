package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.Investidor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoInvestimento {

    private List<Investidor> investidores = new ArrayList<>();

    public List<Investidor> exibirInvestidor(){
        return investidores;
    }

    public void cadastrarInvestidor(Investidor investidor) {
        investidores.add(investidor);
    }

    public void calcularRetorno() {
        double valorInvestido = 0;
        double valorTotalDoLucro = 0;
        double valorTotal = 0;



    }
}
