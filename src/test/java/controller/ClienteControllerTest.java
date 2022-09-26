package controller;

import model.Cliente;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteControllerTest {
    private final ClienteController clienteController = new ClienteController();
    private Object resultado;

    @BeforeEach
    public void criarCliente() {
        clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        System.out.println("Teste: "+testInfo.getTestMethod().get().getName());
    }

    @AfterEach
    public void capturarResultado(){
        //String resultado = "";
        System.out.println("Informações do teste: " + resultado + "\n----------");
    }

    @Test
    public void cadastrarCliente() {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente("Angelo", "12345678910", "81912345678"));
        assertTrue(clienteTestes);

        resultado = clienteTestes;
    }

    @ParameterizedTest
    @CsvSource({
            "'',12345678910,81912345678",
            "Angelo,'',81912345678",
            "Angelo,12345678910,''"
    })
    void cadastrarClienteCamposVazio(ArgumentsAccessor clientes) {
        boolean clienteTestes = clienteController.cadastrarCliente(new Cliente(clientes.getString(0), clientes.getString(1), clientes.getString(2)));
        assertFalse(clienteTestes);

        resultado = clientes.toList();
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
        Cliente clienteRemovido = clienteController.pegarCliente(1);
        assertTrue(clienteController.removerCliente(1));

        resultado = "Cliente removido: " + clienteRemovido.getNome() + ", CPF: " + clienteRemovido.getCpf();
    }

    @Test
    public void removerClienteErrado() {
        assertFalse(clienteController.removerCliente(50));

        resultado = "Cliente não localizado";
    }

    @Test
    public void editarCliente() {
        Cliente cliente = new Cliente("Angelo Victor", "12345678910", "81912345678");
        boolean clienteTestes = clienteController.editarCliente(cliente, 1);

        assertTrue(clienteTestes);

        resultado = cliente;
    }

    @Test
    public void editarClienteErrado() {
        Cliente cliente = new Cliente("Angelo Victor", "A", "81912345678");
        boolean clienteTestes = clienteController.editarCliente(cliente, 2);

        assertFalse(clienteTestes);

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
        assertNull(clienteController.pegarCliente(50));

        resultado = "Cliente não localizado";
    }

    @Test
    public void listarClientes() {
        List<Cliente> clientes = clienteController.listarClientes();
        for (Cliente cliente: clientes
        ) {
            System.out.println(cliente.toString());
        }
    }
}