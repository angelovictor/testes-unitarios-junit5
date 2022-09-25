package model;

import java.util.ArrayList;
import java.util.List;

public class Petshop {
    private double caixa;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Servicos> servicos = new ArrayList<>();

    public Petshop(double caixa) {
        this.caixa = caixa;
    }

    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean addCliente(Cliente cliente){
        return clientes.add(cliente);
    }

    public boolean removerCliente(Cliente cliente){
        return clientes.remove(cliente);
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public boolean addServico(Servicos servico){
        return servicos.add(servico);
    }

    public boolean removerServico(Servicos servico){
        return servicos.remove(servico);
    }
}
