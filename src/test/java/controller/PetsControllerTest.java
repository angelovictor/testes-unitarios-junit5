package controller;

import model.Cliente;
import model.Pets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PetsControllerTest {
    private PetsController petsController = new PetsController();
    private ClienteController clienteController = new ClienteController();
    private Object resultado;

    @AfterEach
    public void capturarResultado() {
        //String resultado = "";
        System.out.println("Informações dos testes: " + resultado);
    }

    @Test
    public void cadastrarPet() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes = petsController.cadastrarPet(new Pets("Lilica", "poodle", cliente));
        assertTrue(petTestes);

        resultado = petTestes;
    }

    @Test
    public void cadastrarPetCamposVazio() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes = petsController.cadastrarPet(new Pets("Lilica", "", cliente));
        assertFalse(petTestes);

        resultado = petTestes;
    }

    @Test
    public void removerPet() {
        Cliente cliente = new Cliente("marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        petsController.cadastrarPet(new Pets("Chiwito", "chihuahua", cliente));
        petsController.cadastrarPet(new Pets("Belinha", "pinscher", cliente));
        assertEquals(true, petsController.removerPet(1));

    }

    @Test
    public void removerPetInexistente() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Lulu", "poodle", cliente);
        petsController.cadastrarPet(new Pets("Belinha", "pinscher", cliente));
        assertEquals(false, petsController.removerPet(10));

    }

    @Test
    public void editarPet() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes = petsController.cadastrarPet(new Pets("Lilica", "poodle", cliente));
        assertTrue(petTestes);

        Pets pet = new Pets("Lulu", "poodle", cliente);
        boolean petTestesEdit = petsController.editarPet(pet, 1);
        assertTrue(petTestes);

        resultado = pet;
    }

    @Test
    public void validarPet() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes01 = petsController.validarPet(new Pets("Lilica", "poodle", cliente));
        boolean petTestes02 = petsController.validarPet(new Pets("Hulk", "bulldog", null));

        assertTrue(petTestes01);
        assertFalse(petTestes02);

        resultado = petTestes01 + "," + petTestes02;

    }

    @Test
    public void adicionarPetAoCliente() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes = petsController.adicionarPetAoCliente(new Pets("Lilica", "poodle", cliente));
        assertTrue(petTestes);

        resultado = petTestes;

    }

    @Test
    public void removerPetDoCliente() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        boolean petTestes01 = petsController.adicionarPetAoCliente(new Pets("Lilica", "poodle", cliente));
        assertTrue(petTestes01);

        boolean petTestes02 = petsController.removerPetDoCliente(cliente.getPets().get(0));
        assertTrue(petTestes02);

        resultado = petTestes01 + "," + petTestes02;

    }

    @Test
    public void editarPetInexistente() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Lulu", "poodle", cliente);
        assertEquals(false, petsController.editarPet(pet, 10));

        resultado = pet;

    }

    @Test
    public void listarPet() {
        Cliente cliente = new Cliente("Marcelle", "15975325896", "81996788310");
        clienteController.cadastrarCliente(cliente);

        petsController.cadastrarPet(new Pets("Chiwito", "chihuahua", cliente));
        petsController.cadastrarPet(new Pets("Belinha", "pinscher", cliente));

        List<Pets> pets = petsController.listarPet();
        for (Pets pet : pets) {
            System.out.println(pet.toString());
        }
    }

}