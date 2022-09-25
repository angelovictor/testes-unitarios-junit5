package model;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    private int id;
    private static int proxid = 1;
    private String nome;
    private String raca;
    private Cliente dono;
    private List<Servicos> servicos = new ArrayList<>();

    public Pets(String nome, String raca, Cliente dono) {
        this.nome = nome;
        this.raca = raca;
        this.dono = dono;
        this.IncrementarId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public Cliente getDono() {
        return dono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getProxid() {
        return proxid;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    public void IncrementarId(){
        this.id = this.proxid;
        this.proxid++;
    }

    public static void setProxid(int proxid) {
        Pets.proxid = proxid;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id + " ");
        sb.append("nome: ");
        sb.append(this.nome + " ");
        sb.append("raca: ");
        sb.append(this.raca + " ");
        sb.append("dono: ");
        sb.append(this.dono.getId() + " " + this.dono.getNome());
        return sb.toString();

    }
}
