package controller;

import model.Pets;
import model.Petshop;
import model.Servicos;

import java.util.List;

public class PetshopController {
    private Petshop petshop = new Petshop(0);
    private PetsController petsController = new PetsController();
    private ServicoController servicoController = new ServicoController();

    public double getCaixa(){return petshop.getCaixa();}

    public boolean addDinheiroCaixa(double dinheiro){
        if(dinheiro > 0){
            petshop.setCaixa(petshop.getCaixa() + dinheiro);
            return true;
        }
        return false;
    }

    public boolean removerDinheiroCaixa(double dinheiro){
        if((petshop.getCaixa() - dinheiro) >= 0 ){
            petshop.setCaixa(petshop.getCaixa() - dinheiro);
            return true;
        }
        return false;
    }

    public boolean solicitarServico(Pets pet, Servicos servico) {
        Pets pett = petsController.pegarUmPet(pet.getId());
        if (pett != null) {
            List<Servicos> servicos = petsController.pegarServicosDoPet(pet);
            servicos.add(servico);
            addDinheiroCaixa(servico.getPreco());
            pet.setServicos(servicos);
            petsController.editarPet(pet, pet.getId());
            return true;
        }
        return false;
    }
}
