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
}
