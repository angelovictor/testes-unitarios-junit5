package controller;

import DAO.ServicosRepositorio;
import model.Servicos;

import java.util.List;

public class ServicoController {
    static ServicosRepositorio servicosRepositorio = ServicosRepositorio.getInstance();

    public boolean criarServico(Servicos servico) {
        if(validarServico(servico)){
            servicosRepositorio.addServico(servico);
            return true;
        }
        return false;

    }

    public boolean removerServico(int id) {
        Servicos removerServico = servicosRepositorio.VerificarServico(id);
        if(removerServico != null){
            servicosRepositorio.removerServico(removerServico.getId());
            return true;
        }
        return false;
    }

    public boolean editarServico(Servicos servico, int id) {
        if(validarServico(servico)){
            Servicos editarServico = servicosRepositorio.VerificarServico(id);
            if(editarServico != null){
                editarServico.setPreco(servico.getPreco());
                editarServico.setNomeServico(servico.getNomeServico());
                return true;
            }
        }

        return false;
    }

    public static List<Servicos> mostrarServicos() {
        return servicosRepositorio.getServicos();
    }

    public boolean validarServico(Servicos servico) {
        if (servico.getNomeServico().equals("")|| servico.getNomeServico().matches(".*[0-9].*")){
            return false;
        }
        if (servico.getPreco() <= 0) {
            return false;
        }
        return true;
    }
    public static Servicos pegarUmServico(int id){
        return servicosRepositorio.VerificarServico(id);
    }
}
