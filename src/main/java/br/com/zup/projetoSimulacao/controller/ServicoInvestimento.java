package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.RetornoDeInvestimentoDto;
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

    public RetornoDeInvestimentoDto calculoDeRendimento(RetornoDeInvestimentoDto retornoDeInvestimentoDto, InvestidorDto investidorDto) {
        double guardarValor = investidorDto.getRisco().getValor() * investidorDto.getValorInvestido();
       double valorTotal = retornoDeInvestimentoDto.getValorTotal();
       valorTotal = guardarValor * investidorDto.getPeriodoDeAplicacaoMeses();

       return retornoDeInvestimentoDto;
    }

}
