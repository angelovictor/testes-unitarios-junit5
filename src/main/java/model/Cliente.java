package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private static int proxid = 1;
    private String nome;
    private String cpf;
    private List<Pets> pets = new ArrayList<>();
    private String telefone;


    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.IncrementarId();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Pets> getPets() {
        return pets;
    }


    public int getId() {
        return id;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getProxid() {
        return proxid;
    }

    public void IncrementarId() {
        this.id = this.proxid;
        this.proxid++;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id + " ");
        sb.append("nome: ");
        sb.append(this.nome + " ");
        sb.append("cpf: ");
        sb.append(this.cpf + " ");
        sb.append("telefone: ");
        sb.append(this.telefone);
        sb.append("Pets: ");
        sb.append(this.pets);
        return sb.toString();
    }
}
