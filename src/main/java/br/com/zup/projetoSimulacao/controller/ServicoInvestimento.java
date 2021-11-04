package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.Risco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoInvestimento {

    private List<InvestidorDto> investidores = new ArrayList<>();

    public List<InvestidorDto> exibirInvestidor() {
        return investidores;
    }

    public void cadastrarInvestidor(InvestidorDto investidorDto) {
        investidores.add(investidorDto);
    }

    public double calculoDeInvestimento(InvestidorDto investidorDto, Risco risco) {
        double valorDeInvestimento = investidorDto.getPeriodoDeAplicacaoMeses() * risco.getValor();
        double valorTotal = valorDeInvestimento + investidorDto.getValorInvestido();

       return valorTotal;
    }

    public void validacaoDeRisco( Risco risco) {
        if (risco.getValor() < 5000) {
            throw new RuntimeException();
        }
    }


}
