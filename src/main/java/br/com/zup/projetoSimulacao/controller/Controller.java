package br.com.zup.projetoSimulacao.controller;

import br.com.zup.projetoSimulacao.investidordto.Investidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulacaoDeInvestimento")
public class Controller {

    @Autowired
   private ServicoInvestimento servicoInvestimento;

    @GetMapping
   public List<Investidor> mostrarInvestidor() {
       return servicoInvestimento.exibirInvestidor();
   }

   @PutMapping
   public void cadastrarInvestidor (@RequestBody Investidor investidor) {
        servicoInvestimento.cadastrarInvestidor(investidor);
   }
}
