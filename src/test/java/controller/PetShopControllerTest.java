package controller;

import model.Cliente;
import model.Pets;
import model.Servicos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetShopControllerTest {
    private PetshopController petshopController = new PetshopController();
    private PetsController petsController = new PetsController();
    private ClienteController clienteController = new ClienteController();

    private ServicoController servicoController = new ServicoController();
    private Object resultado;

    @AfterEach
    public void capturarResultado(){
        //String resultado = "";
        System.out.println("Informações dos testes: " + resultado);
    }

    @Test
    public void addDinheiroCaixa() {
        boolean valorEntrada = petshopController.addDinheiroCaixa(150);
        assertTrue(valorEntrada);

        boolean valorEntradaNegativa = petshopController.addDinheiroCaixa(-200);
        assertFalse(valorEntradaNegativa);

        boolean valorEntradaInvalida = petshopController.addDinheiroCaixa(0);
        assertFalse(valorEntradaInvalida);

        resultado = valorEntrada + ", " + valorEntradaNegativa + "," + valorEntradaInvalida;
    }

    @Test
    public void removerDinheiroCaixa() {
        petshopController.addDinheiroCaixa(100);

        boolean valorRetirada = petshopController.removerDinheiroCaixa(25);
        assertTrue(valorRetirada);

        boolean valorRetirada2 = petshopController.removerDinheiroCaixa(110);
        assertFalse(valorRetirada2);

        boolean valorRetirada3 = petshopController.removerDinheiroCaixa(0);
        assertTrue(valorRetirada3);

        resultado = valorRetirada + ", " + valorRetirada2 + ", " + valorRetirada3;
    }

    @Test
    public void removerDinheiroCaixaNegativo() {
        petshopController.addDinheiroCaixa(0);

        boolean valorRetirada = petshopController.removerDinheiroCaixa(138);
        assertFalse(valorRetirada);

        resultado = valorRetirada;
    }

    @Test
    public void solicitarServico(){
        Cliente cliente = new Cliente("Vanessa","24229138067","81998765276");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Pepita","Poodle", cliente);
        petsController.cadastrarPet(pet);

        Servicos servico = new Servicos("Tosa Higiênica", 45);
        petshopController.solicitarServico(pet,servico);

        boolean servico1 = petshopController.solicitarServico(pet, servico);
        assertTrue(servico1);

        resultado = servico1;
    }
}
