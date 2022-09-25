package DAO;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {
    private static ClienteRepositorio clienteRepositorio;
    private List<Cliente> clientes = new ArrayList<>();

    public static ClienteRepositorio getInstance() {
        if (clienteRepositorio == null) {
            clienteRepositorio = new ClienteRepositorio();
        }
        return clienteRepositorio;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean addCliente(Cliente cliente) {
        int ultimoID = 1;
        for(int i=0; i<clientes.size(); i++){
            ultimoID++;
        }
        cliente.setId(ultimoID);
        return clientes.add(cliente);
    }

    public boolean removerCliente(int id) {
        Cliente removerCliente = verificarCliente(id);
        if(removerCliente != null){
            clientes.remove(removerCliente);
            return true;
        }
        return false;
    }

    public Cliente verificarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void atualizarCliente(Cliente cliente, int id) {
        Cliente clienteAntigo = verificarCliente(id);
        if (clienteAntigo != null) {
            clienteAntigo.setNome(cliente.getNome());
            clienteAntigo.setTelefone(cliente.getTelefone());
            clienteAntigo.setCpf(cliente.getCpf());
            clienteAntigo.setPets(cliente.getPets());
        }

    }

}
