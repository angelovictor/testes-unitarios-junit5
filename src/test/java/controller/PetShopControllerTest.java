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
        System.out.println("Informações do teste: " + resultado);
    }

    @Test
    public void addDinheiroCaixa() {
        boolean valorEntrada = petshopController.addDinheiroCaixa(150);
        assertTrue(valorEntrada);

        resultado = valorEntrada;
    }

    @Test
    public void addDinheiroCaixa2() {
        boolean valorEntradaNegativa = petshopController.addDinheiroCaixa(-200);
        assertFalse(valorEntradaNegativa);

        resultado = valorEntradaNegativa;
    }

    @Test
    public void addDinheiroCaixa3() {
        boolean valorEntradaInvalida = petshopController.addDinheiroCaixa(0);
        assertFalse(valorEntradaInvalida);

        resultado = valorEntradaInvalida;
    }

    @Test
    public void addDinheiroCaixaSaldoNegativo() {
        petshopController.addDinheiroCaixa(-150);

        boolean valorEntrada = petshopController.addDinheiroCaixa(50);
        assertTrue(valorEntrada);

        resultado = valorEntrada;
    }

    @Test
    public void removerDinheiroCaixa() {
        petshopController.addDinheiroCaixa(100);

        boolean valorRetirada = petshopController.removerDinheiroCaixa(25);
        assertTrue(valorRetirada);

        resultado = valorRetirada;
    }

    @Test
    public void removerDinheiroCaixaNulo() {
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
        boolean teste1 = petshopController.solicitarServico(pet,servico);
        assertTrue(teste1);
        resultado = teste1;

    }

    @Test
    public void solicitarServicoClienteInexistente(){
        Cliente cliente = new Cliente("Wagner","36829130190","81990766290");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Bobô","Basset", null);
        petsController.cadastrarPet(pet);

        Servicos servico = new Servicos("Consulta", 145);


        boolean teste1 = petshopController.solicitarServico(pet,servico);
        assertFalse(teste1);
        resultado = teste1;
    }
    @Test
    public void solicitarServicoServicoInexistente(){
        Cliente cliente = new Cliente("Wagner","36829130190","81990766290");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Bobô","Basset", null);
        petsController.cadastrarPet(pet);

        Servicos servico = new Servicos("Consulta", 145);


        boolean teste1 = petshopController.solicitarServico(pet,null);
        assertFalse(teste1);
        resultado = teste1;
    }
}
