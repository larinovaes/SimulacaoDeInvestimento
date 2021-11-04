package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.RetornoDeInvestimentoDto;
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

    public RetornoDeInvestimentoDto cadastrarInvestidor(InvestidorDto investidorDto) {
        if (investidorDto.getValorInvestido() < 5000 && investidorDto.getRisco().equals(Risco.ALTO)) {
            throw new InvestimentoInvalido("Esse valor é invalido para o tipo de risco");
        }
        RetornoDeInvestimentoDto retornoDeInvestimentoDto = new RetornoDeInvestimentoDto();
        retornoDeInvestimentoDto.setValorInvestido(investidorDto.getValorInvestido());
        retornoDeInvestimentoDto.setTotalDoLucuro(calcularLucro(investidorDto));
        retornoDeInvestimentoDto.setValorTotal(calcularValorTotal(investidorDto));
        investidores.add(investidorDto);
        return retornoDeInvestimentoDto;
    }

    public double calcularValorTotal(InvestidorDto investidorDto) {
      return calcularLucro(investidorDto) + investidorDto.getValorInvestido();
    }

    public double calcularLucro(InvestidorDto investidorDto) {
        return investidorDto.getPeriodoDeAplicacaoMeses() * (investidorDto.getRisco().getValor() * 1);
    }
}
