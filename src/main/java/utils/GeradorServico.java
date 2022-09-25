package utils;

import controller.ServicoController;
import model.Servicos;

public class GeradorServico {
    private ServicoController servicoController = new ServicoController();

    public void geradorServico(){
        servicoController.criarServico(new Servicos("Banho", (float) 20));
        servicoController.criarServico(new Servicos("Cortar Unhas", (float) 30));
        servicoController.criarServico(new Servicos("Tosar", (float) 15.5));
        servicoController.criarServico(new Servicos("Aplicar Injecão", (float) 11.5));
    }
}
