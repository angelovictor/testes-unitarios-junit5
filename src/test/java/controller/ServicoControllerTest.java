package controller;

import model.Servicos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static DAO.ServicosRepositorio.servicosRepositorio;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoControllerTest {
    private ServicoController servicoController = new ServicoController();
    private Object resultado;


    @AfterEach
    public void capturarResultado() {
        //String resultado = "";
        System.out.println("Informações dos testes: " + resultado);
    }


    @Test
    public void criarServicoTrue() {
        boolean criarServico = servicoController.criarServico((new Servicos("Banho", 20)));
        assertTrue(criarServico);
        resultado = "Serviço criado" ;
    }

    @Test
    public void criarServicoFalse() {

        boolean criarServico = servicoController.criarServico(new Servicos("Cortar 2 Unhas", -15.5));
        assertFalse(criarServico);

    }

    @Test
    public void validarServicoTrue() {
        boolean validarServico = servicoController.validarServico(new Servicos("Banho", 20));
        assertTrue(validarServico);

        resultado = "Serviço validado" ;
    }

    @Test
    public void validarServicoFalse() {
        boolean validarServico = servicoController.validarServico(new Servicos("Fazer 2 unhas", -15.5));
        assertFalse(validarServico);

    }

    @Test
    public void removerServicoTrue() {
        servicoController.criarServico(new Servicos("Banho", 20));
        assertTrue(servicoController.removerServico(1));

        resultado = "Serviço Removido";
    }

    @Test
    public void removerServicoFalse() {
        Servicos servicosRemovidos = ServicoController.pegarUmServico(50);
        assertFalse(servicosRepositorio.removerServico(50));

        resultado = "Nao foi removido" ;

    }


    @Test
    public void editarServicoTrue() {
        boolean criarServico = servicoController.criarServico(new Servicos("Tosar", 15.5));
        assertTrue(criarServico);

        Servicos editServicos = new Servicos("Cortar Unhas", 30);
        boolean criarNovoServico = servicoController.editarServico(editServicos, 1);
        assertTrue(criarNovoServico);

        resultado = "Serviço editado: " + editServicos;
    }

    @Test
    public void editarServicoFalse() {
        Servicos editServico = new Servicos("Aplicar Injeção", 11.5);
        boolean resultado = servicoController.editarServico(editServico, 1);
        assertFalse(resultado);

    }

    @Test
    public void consultarServico() {
        Servicos servicos = ServicoController.pegarUmServico(1);

        assertEquals(servicos, ServicoController.pegarUmServico(1));

        resultado = servicos;
    }

    @Test
    public void mostrarServicos() {
        List<Servicos> servicos = ServicoController.mostrarServicos();
        for (Servicos servicos1 : servicos
        ) {
            System.out.println(servicos.toString());
        }
    }
}