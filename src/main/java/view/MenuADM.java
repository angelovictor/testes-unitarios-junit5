package view;

import controller.ClienteController;
import controller.PetshopController;
import controller.ServicoController;
import model.Cliente;
import model.Servicos;

import java.util.Scanner;

public class MenuADM {

    public void mostrarMenu() {
        ClienteController clienteController = new ClienteController();
        PetshopController petshopController = new PetshopController();
        ServicoController servicoController = new ServicoController();
        Scanner sc = new Scanner(System.in);
        int chave = 0;
        int opcao = 0;
        String nome, cpf, telefone;
        while(true){
            System.out.println("Digite a opcão:");
            System.out.println("Digite 1 para adicionar Cliente");
            System.out.println("Digite 2 para remover Cliente");
            System.out.println("Digite 3 para listar os Clientes");
            System.out.println("Digite 4 para adicionar Servico");
            System.out.println("Digite 5 para editar Servico");
            System.out.println("Digite 6 para remover Servico");
            System.out.println("Digite 7 para listar Servico");
            System.out.println("Digite 8 para mostrar o valor no caixa");
            System.out.println("Digite -1 para sair");
            chave = sc.nextInt();
            switch(chave){
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome do cliente");
                    nome = sc.nextLine();
                    System.out.println("Digite a CPF do cliente");
                    cpf = sc.nextLine();
                    System.out.println("Digite o telefone do cliente");
                    telefone = sc.nextLine();
                    if(clienteController.cadastrarCliente(new Cliente(nome,cpf,telefone))){
                        System.out.println("Cliente cadastrado com sucesso");
                    }else{
                        System.out.println("Falha ao cadastrar cliente");
                    }
                    break;
                case 2:
                    System.out.println("Selecione o cliente a ser removido");
                    for (Cliente cliente: clienteController.listarClientes()
                    ) {
                        System.out.println(cliente.toString());
                    }
                    opcao = sc.nextInt();
                    sc.nextLine();
                    if(clienteController.removerCliente(opcao)){
                        System.out.println("Cliente removido com sucesso");
                    }else{
                        System.out.println("Falha ao remover o cliente");
                    }

                    break;
                case 3:
                    for (Cliente cliente: clienteController.listarClientes()
                    ) {
                        System.out.println(cliente.toString());
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Digite o nome do servico");
                    nome = sc.nextLine();
                    System.out.println("Digite o valor do servico");
                    double valor = sc.nextDouble();
                    if(servicoController.criarServico(new Servicos(nome,valor))){
                        System.out.println("Servico cadastrado com sucesso");
                    }else{
                        System.out.println("Falha ao cadastrar servico");
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Selecione o servico a ser editado");
                    for (Servicos servico: servicoController.mostrarServicos()
                    ) {
                        System.out.println(servico.toString());
                    }
                    opcao = sc.nextInt();
                    sc.nextLine();
                    Servicos servicoEdit = servicoController.pegarUmServico(opcao);
                    System.out.println("Digite o novo nome do servico");
                    nome = sc.nextLine();
                    System.out.println("Digite o novo preco do servico");
                    double preco = sc.nextDouble();
                    servicoController.editarServico(new Servicos(nome,preco), opcao);
                    break;
                case 6:
                    System.out.println("Selecione o servico a ser removido");
                    for (Servicos servicos : servicoController.mostrarServicos()
                    ) {
                        System.out.println(servicos.toString());
                    }
                    opcao = sc.nextInt();
                    sc.nextLine();
                    if(servicoController.removerServico(opcao)){
                        System.out.println("Servico removido com sucesso");
                    }else{
                        System.out.println("Falha ao remover o servico");
                    }
                    break;
                case 7:
                    for (Servicos servico: servicoController.mostrarServicos()
                    ) {
                        System.out.println(servico.toString());
                    }
                    break;
                case 8:
                    System.out.println(petshopController.getCaixa());
                    break;
                case -1:
                    return;

            }
        }
    }

}
