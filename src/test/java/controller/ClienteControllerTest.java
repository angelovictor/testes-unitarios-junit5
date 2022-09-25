package controller;

import model.Cliente;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteControllerTest {
    private ClienteController clienteController = new ClienteController();
    private Object resultado;

    @BeforeEach
    public void criarCliente() {
        clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
    }

    @AfterEach
    public void capturarResultado(){
        //String resultado = "";
        System.out.println("Informações dos testes: " + resultado);
    }

    @Test
    public void cadastrarCliente() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
        assertTrue(clienteTestes);

        resultado = clienteTestes;
    }

    @Test
    public void cadastrarClienteCamposVazio() {
        boolean clienteTestes01 = clienteController.cadastrarCliente(new Cliente("", "12345678910", "81912345678"));
        boolean clienteTestes02 = clienteController.cadastrarCliente(new Cliente("Angelo", "", "81912345678"));
        boolean clienteTestes03 = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", ""));

        assertFalse(clienteTestes01);
        assertFalse(clienteTestes02);
        assertFalse(clienteTestes03);

        resultado = clienteTestes01 + ", " + clienteTestes02 + ", " + clienteTestes03;
    }

    @Test
    public void cadastrarClienteValidarCampoNome() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("1", "12345678910", "81912345678"));

        assertFalse(clienteTestes);

        resultado = clienteTestes;
    }

    @Test
    public void cadastrarClienteValidarCampoCPF() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "A", "81912345678"));

        assertFalse(clienteTestes);

        resultado = clienteTestes;
    }

    @Test
    public void cadastrarClienteValidarCampoTelefone() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "A"));

        assertFalse(clienteTestes);

        resultado = clienteTestes;
    }

    @Test
    public void removerCliente() {
        assertTrue(clienteController.removerCliente(1));
    }

    @Test
    public void removerClienteErrado() {
        assertFalse(clienteController.removerCliente(50));
    }

    @Test
    public void editarCliente() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
        assertTrue(clienteTestes);

        Cliente cliente = new Cliente("Angelo Victor", "12345678910", "81912345678");
        clienteTestes = clienteController.editarCliente(cliente, 1);
        assertTrue(clienteTestes);

        resultado = cliente;
    }

    @Test
    public void editarClienteErrado() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
        assertTrue(clienteTestes);

        Cliente cliente = new Cliente("Angelo Victor", "12345678910", "81912345678");
        clienteTestes = clienteController.editarCliente(cliente, 2);
        assertTrue(clienteTestes);

        resultado = cliente;
    }

    @Test
    public void consultarCliente() {
        Cliente cliente = clienteController.pegarCliente(1);

        assertEquals(cliente, clienteController.pegarCliente(1));

        resultado = cliente;
    }

    @Test
    public void consultarClienteErrado() {
        assertEquals(null, clienteController.pegarCliente(50));
    }
}