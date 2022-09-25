package model;

public class Servicos {
    private int id;
    private static int proxid = 1;
    private String nomeServico;
    private double preco;

    public Servicos(String nomeServico, double preco) {
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.IncrementarId();
    }

    public String getNomeServico() {
        return nomeServico;
    }


    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id + " ");
        sb.append("nome: ");
        sb.append(this.nomeServico + " ");
        sb.append("preco: ");
        sb.append(this.preco + " ");
        return sb.toString();
    }
}
