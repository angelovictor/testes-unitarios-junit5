package controller;

import DAO.ClienteRepositorio;
import model.Cliente;
import model.Pets;

import java.util.List;

public class ClienteController {
    private ClienteRepositorio clienteRepositorio = ClienteRepositorio.getInstance();

    public boolean cadastrarCliente(Cliente cliente) {
        if (validarCliente(cliente)) {
            clienteRepositorio.addCliente(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(int id) {
        for (Cliente cliente : clienteRepositorio.getClientes()) {
            if (cliente.getId() == id) {
                removerTodosOsPets(cliente.getId());
                clienteRepositorio.removerCliente(cliente.getId());
                return true;
            }
        }
        return false;
    }

    public boolean editarCliente(Cliente cliente, int id) {
        if (validarCliente(cliente)) {
            clienteRepositorio.atualizarCliente(cliente, id);
            return true;
        }
        return false;
    }

    public List<Cliente> listarClientes() {
        return clienteRepositorio.getClientes();
    }

    public boolean validarCliente(Cliente cliente) {
        if (cliente.getNome().equals("") || cliente.getNome().matches(".*[[0-9]].*")) {
            return false;
        }
        if (cliente.getCpf().equals("") || cliente.getCpf().matches(".*[[A-Z][a-z]].*")) {
            return false;
        }
        if (cliente.getTelefone().equals("") || cliente.getTelefone().matches(".*[[A-Z][a-z]].*")) {
            return false;
        }
        return true;
    }

    public void removerTodosOsPets(int id) {
        Cliente cliente = clienteRepositorio.verificarCliente(id);
        List<Pets> pets = cliente.getPets();
        int aux = pets.size();
        for (int i = 0; i < aux; i++) {
            pets.remove(pets.get(0));
        }

        cliente.setPets(pets);
        clienteRepositorio.atualizarCliente(cliente, cliente.getId());
    }

    public Cliente pegarCliente(int id) {

        return clienteRepositorio.verificarCliente(id);

    }

}
