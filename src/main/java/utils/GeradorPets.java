package utils;

import controller.ClienteController;
import controller.PetsController;
import model.Pets;
import org.junit.jupiter.api.Test;

public class GeradorPets {
    PetsController petsController = new PetsController();
    GeradorClients geradorClients = new GeradorClients();
    ClienteController clienteController = new ClienteController();

    @Test
    public void gerarPets() {
        geradorClients.criarClientes();
        petsController.cadastrarPet(new Pets("Naruto", "Kyuubi", clienteController.pegarCliente(1)));
        petsController.cadastrarPet(new Pets("Gaara", "Ichibi", clienteController.pegarCliente(2)));
        petsController.cadastrarPet(new Pets("Shikamaru", "Nibi", clienteController.pegarCliente(3)));
        petsController.cadastrarPet(new Pets("Sasuke", "Sanbi", clienteController.pegarCliente(4)));
        petsController.cadastrarPet(new Pets("Shino", "Yonbi", clienteController.pegarCliente(5)));
        petsController.cadastrarPet(new Pets("Ino", "Gobi", clienteController.pegarCliente(6)));

    }
}
