package utils;

import controller.ClienteController;
import model.Cliente;

public class GeradorClients {
    private ClienteController clienteController = new ClienteController();

    public void criarClientes(){
        clienteController.cadastrarCliente(new Cliente("Adan", "15975325896", "88996358596"));
        clienteController.cadastrarCliente(new Cliente("Ian", "25836914785", "85996375737"));
        clienteController.cadastrarCliente(new Cliente("Matheus", "15748596358", "85996392858"));
        clienteController.cadastrarCliente(new Cliente("Anthony", "15335785236", "85996372717"));

    }
}
