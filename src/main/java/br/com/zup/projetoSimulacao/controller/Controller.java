package br.com.zup.projetoSimulacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulacaoDeInvestimento")
public class Controller {

    @Autowired
   private ServicoInvestimento servicoInvestimento;


}
