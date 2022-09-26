package DAO;

import model.Servicos;
import java.util.ArrayList;
import java.util.List;


public class ServicosRepositorio {
    public static ServicosRepositorio servicosRepositorio;
    private List<Servicos> servicos = new ArrayList<>();

    public static ServicosRepositorio getInstance() {
        if (servicosRepositorio == null) {
            servicosRepositorio = new ServicosRepositorio();
        }
        return servicosRepositorio;
    }

    public void addServico(Servicos servico){
        int ultimoID = 1;
        for(int i=0; i<servicos.size(); i++){
            ultimoID++;
        }
        servico.setId(ultimoID);
        servicos.add(servico);
    }

    public boolean removerServico(int id){
        Servicos removerServico = VerificarServico(id);
        if(removerServico != null){
            servicos.remove(removerServico);
            return true;
        }
        return false;
    }

    public void atualizarServico(Servicos servico, int id){
        Servicos atualizarServico = VerificarServico(id);
        if(atualizarServico != null){
            atualizarServico.setNomeServico(servico.getNomeServico());
            atualizarServico.setPreco(servico.getPreco());
        }
    }

    public List<Servicos> mostrarServicos(){
        return servicos;
    }

    public Servicos VerificarServico(int id){
        for (Servicos servico: servicos ) {
            if(servico.getId() == id){
                return servico;
            }
        }
        return null;
    }


    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

}
