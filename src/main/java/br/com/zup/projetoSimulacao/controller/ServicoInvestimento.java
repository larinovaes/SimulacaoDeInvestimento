package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.RetornoDeInvestimentoDto;
import br.com.zup.projetoSimulacao.investidordto.Risco;
import br.com.zup.projetoSimulacao.mensagemdeerro.InvestidorNaoEncontrado;
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
        verificarEmailRepetido(investidorDto);
        investidores.add(investidorDto);
        return verificarRisco(investidorDto);

    }

    public double calcularValorTotal(InvestidorDto investidorDto) {
        return calcularLucro(investidorDto) + investidorDto.getValorInvestido();
    }

    public double calcularLucro(InvestidorDto investidorDto) {
        return investidorDto.getPeriodoDeAplicacaoMeses() * (investidorDto.getRisco().getValor() * 1);
    }

    public InvestidorDto buscarInvestidor(String nomeDoInvestidor) {

        for (InvestidorDto investidorDto : investidores) {
            if (investidorDto.getNome().equalsIgnoreCase(nomeDoInvestidor)) {
                return investidorDto;
            }
        }
        throw new InvestidorNaoEncontrado("Esse investidor não existe");
    }

    public InvestidorDto verificarEmailRepetido(InvestidorDto novoinvestidorDto) {
        for (InvestidorDto investidorDto : investidores) {
            if (investidorDto.getEmail().equalsIgnoreCase(novoinvestidorDto.getEmail())) {
                throw new InvestimentoInvalido("Esse email já está cadastrado no sistema");
            }
        }
        return novoinvestidorDto;
    }

    public RetornoDeInvestimentoDto verificarRisco(InvestidorDto investidorDto) {
        if (investidorDto.getValorInvestido() < 5000 && investidorDto.getRisco().equals(Risco.ALTO)) {
            throw new InvestimentoInvalido("Esse valor é invalido para o tipo de risco");
        }
        RetornoDeInvestimentoDto retornoDeInvestimentoDto = new RetornoDeInvestimentoDto();
        retornoDeInvestimentoDto.setValorInvestido(investidorDto.getValorInvestido());
        retornoDeInvestimentoDto.setTotalDoLucuro(calcularLucro(investidorDto));
        retornoDeInvestimentoDto.setValorTotal(calcularValorTotal(investidorDto));
        return retornoDeInvestimentoDto;
    }
}
