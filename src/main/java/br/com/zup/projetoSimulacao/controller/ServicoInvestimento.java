package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.Risco;
import br.com.zup.projetoSimulacao.mensagemdeerro.InvestimentoInvalido;
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
        if (investidorDto.getValorInvestido() < 5000 && investidorDto.getRisco().equals(Risco.ALTO)) {
            throw new InvestimentoInvalido("Esse valor é invalido para o tipo de risco");
        }
        investidores.add(investidorDto);
    }

    public double calcularInvestimento(InvestidorDto investidorDto, Risco risco) {
        double valorDeInvestimento = investidorDto.getPeriodoDeAplicacaoMeses() * risco.getValor();
        double valorTotal = valorDeInvestimento + investidorDto.getValorInvestido();

       return valorTotal;
    }


}
