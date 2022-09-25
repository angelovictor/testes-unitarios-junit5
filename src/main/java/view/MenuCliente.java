package view;

import controller.ClienteController;
import controller.PetsController;
import controller.PetshopController;
import controller.ServicoController;
import model.Cliente;
import model.Pets;
import model.Servicos;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;


public class MenuCliente {

    public void mostrarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("ID do cliente:" + cliente.getId() + " \n" +
                    "Nome do cliente:" + cliente.getNome() + " \n" +
                    "CPF do cliente:" + cliente.getCpf() + " \n" +
                    "Telefone do cliente:" + cliente.getTelefone() + " \n");
        }

    }

    public void mostrarPets(List<Pets> pets) {
        for (Pets pet : pets) {
            System.out.println("ID do pet:" + pet.getId() + " \n" +
                    "Nome do pet:" + pet.getNome() + " \n" +
                    "Raca do pet:" + pet.getRaca() + " \n" +
                    "Nome do dono:" + pet.getDono().getNome() + " \n" +
                    "ID do dono: " + pet.getDono().getId());
        }

    }

    public void mostrarServicos(List<Servicos> servicos) {
        for (Servicos servico: servicos) {
            servico.toString();
        }

    }
    @Test
    public void mostrarMenu() {
        PetsController petsController = new PetsController();
        ClienteController clienteController = new ClienteController();
        ServicoController servicoController = new ServicoController();
        PetshopController petshopController = new PetshopController();
        Scanner sc = new Scanner(System.in);
        int chave = 0;
        int opcao = 0;
        String nome, raca;
        while (true) {
            System.out.println("Digite a opcão:");
            System.out.println("Digite 1 para adicionar Pet");
            System.out.println("Digite 2 para editar Pet");
            System.out.println("Digite 3 para remover Pet");
            System.out.println("Digite 4 para listar os Pets");
            System.out.println("Digite 5 para solicitar um Servico");
            System.out.println("Digite 6 para listar servicos solicitados");
            System.out.println("Digite 7 para editar nome");
            System.out.println("Digite 8 para editar CPF");
            System.out.println("Digite 9 para editar telefone");
            System.out.println("Digite -1 para sair");
            chave = sc.nextInt();
            switch (chave) {
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome do pet");
                    nome = sc.nextLine();
                    System.out.println("Digite a raca do pet");
                    raca = sc.nextLine();
                    System.out.println("Selecione o id do dono do pet");
                    clienteController.listarClientes();
                    opcao = sc.nextInt();
                    Cliente cliente = clienteController.pegarCliente(opcao);
                    if (petsController.cadastrarPet(new Pets(nome, raca, cliente))) {
                        System.out.println("Pet cadastrado com sucessso");
                    } else {
                        System.out.println("Falha ao cadastrar o pet. Por favor, tente novamente.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do pet que será editado");
                    List<Pets> pets = petsController.listarPet();
                    mostrarPets(pets);
                    opcao = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite novo nome do pet");
                    nome = sc.nextLine();
                    System.out.println("Digite a nova raca do pet");
                    raca = sc.nextLine();
                    Pets atualizadoPet = petsController.pegarUmPet(opcao);
                    atualizadoPet.setNome(nome);
                    atualizadoPet.setRaca(raca);
                    atualizadoPet.toString();
                    break;
                case 3:
                    System.out.println("Digite o ID do pet que será removido");
                    List<Pets> petss = petsController.listarPet();
                    mostrarPets(petss);
                    opcao = sc.nextInt();
                    petsController.removerPet(opcao);
                    break;
                case 4:
                    List<Pets> todosPets = petsController.listarPet();
                    for (Pets pet: todosPets) {
                        System.out.println(pet.toString());
                    }

                    break;
                case 5:
                    System.out.println("Selecione o servico desejado");
                    List<Servicos> servicos = servicoController.mostrarServicos();
                    for (Servicos servico: servicos) {
                        System.out.println(servico.toString());
                    }
                    int servico = sc.nextInt();
                    System.out.println("Selecione o pet desejado");
                    todosPets = petsController.listarPet();
                    for (Pets petArray: todosPets) {
                        System.out.println(petArray.toString());
                    }
                    int pet = sc.nextInt();
                    petsController.pegarUmPet(pet);
                    if(petshopController.solicitarServico(petsController.pegarUmPet(pet), servicoController.pegarUmServico(servico))){
                        System.out.println("Servico feito com sucesso");
                    }else{
                        System.out.println("Falha ao solicitar servico");
                    }
                    break;
                case 6:
                    System.out.println("Selecione o pet o qual você quer visualizar o histórico de servicos");
                    todosPets = petsController.listarPet();
                    for (Pets petArray: todosPets) {
                        System.out.println(petArray.toString());
                    }
                    pet = sc.nextInt();
                    Pets petListar = petsController.pegarUmPet(pet);
                    List<Servicos> servicosPet = petListar.getServicos();
                    for (Servicos servicoPet: servicosPet
                    ) {
                        System.out.println(servicoPet.toString());
                    }
                    break;
                case 7:
                    System.out.println("Selecione o nome do cliente que será editado");
                    List<Cliente> clients = clienteController.listarClientes();
                    for (Cliente clienteArray: clients
                    ) {
                        System.out.println(clienteArray.toString());
                    }
                    opcao = sc.nextInt();
                    cliente = clienteController.pegarCliente(opcao);
                    System.out.println("Digite o novo nome do cliente");
                    sc.nextLine();
                    nome = sc.nextLine();
                    cliente.setNome(nome);
                    break;
                case 8:
                    System.out.println("Selecione o nome do CPF que será editado");
                    clients = clienteController.listarClientes();
                    for (Cliente clienteArray: clients
                    ) {
                        System.out.println(clienteArray.toString());
                    }
                    opcao = sc.nextInt();
                    cliente = clienteController.pegarCliente(opcao);
                    System.out.println("Digite o CPF nome do cliente");
                    sc.nextLine();
                    String cpf = sc.nextLine();
                    cliente.setCpf(cpf);
                    break;
                case 9:
                    System.out.println("Selecione o nome do telefone que será editado");
                    clients = clienteController.listarClientes();
                    for (Cliente clienteArray: clients
                    ) {
                        System.out.println(clienteArray.toString());
                    }
                    opcao = sc.nextInt();
                    cliente = clienteController.pegarCliente(opcao);
                    System.out.println("Digite o novo telefone do cliente");
                    sc.nextLine();
                    String telefone = sc.nextLine();
                    cliente.setTelefone(telefone);
                    break;
                case -1:
                    return;

            }
        }
    }
}
