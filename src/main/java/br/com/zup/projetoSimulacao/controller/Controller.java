package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.InvestidorDto;
import br.com.zup.projetoSimulacao.investidordto.RetornoDeInvestimentoDto;
import br.com.zup.projetoSimulacao.investidordto.Risco;
import br.com.zup.projetoSimulacao.mensagemdeerro.RiscoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/simulacaoDeInvestimento")
public class Controller {

    @Autowired
   private ServicoInvestimento servicoInvestimento;

    @GetMapping
   public List<InvestidorDto> mostrarInvestidor() {
       return servicoInvestimento.exibirInvestidor();
   }

   @PutMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void cadastrarInvestidor (@RequestBody @Valid InvestidorDto investidorDto) {
       servicoInvestimento.cadastrarInvestidor(investidorDto);
   }
}
