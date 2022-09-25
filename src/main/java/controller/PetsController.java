package controller;

import DAO.ClienteRepositorio;
import DAO.PetsRepositorio;
import model.Cliente;
import model.Pets;
import model.Servicos;

import java.util.List;


public class PetsController {
    PetsRepositorio petsRepositorio = PetsRepositorio.getInstance();
    ClienteRepositorio clienteRepositorio = ClienteRepositorio.getInstance();

    public boolean cadastrarPet(Pets pet) {
        if (validarPet(pet)) {
            petsRepositorio.addPet(pet);
            adicionarPetAoCliente(pet);
            return true;
        }
        return false;
    }

    public boolean removerPet(int id) {
        for (Pets pet : petsRepositorio.getPets()) {
            if (pet.getId() == id) {
                Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
                removerPetDoCliente(pet);
                petsRepositorio.removerPet(pet.getId());
                return true;
            }
        }
        return false;
    }

    public boolean editarPet(Pets pet, int id) {
        if (validarPet(pet)) {
            Pets editarPet = petsRepositorio.verificarPet(id);
            if (editarPet != null) {
                editarPet.setNome(pet.getNome());
                editarPet.setDono(pet.getDono());
                editarPet.setRaca(pet.getRaca());
                editarPet.setServicos(pet.getServicos());
                return true;
            }
        }
        return false;
    }

    public List<Pets> listarPet() {
        return petsRepositorio.getPets();

    }

    public boolean validarPet(Pets pet) {
        if (pet.getNome().equals("") || pet.getNome().matches(".*[[0-9]].*")) {
            return false;

        }
        if (pet.getDono() == null) {
            return false;
        }
        if (clienteRepositorio.verificarCliente(pet.getDono().getId()) == null) {
            return false;
        }
        if (pet.getRaca().equals("") || pet.getRaca().matches(".*[[0-9]].*")) {
            return false;
        }

        return true;
    }

    public boolean adicionarPetAoCliente(Pets pet) {
        Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
        if (cliente != null) {
            List<Pets> petsList = cliente.getPets();
            petsList.add(pet);
            cliente.setPets(petsList);
            clienteRepositorio.atualizarCliente(cliente, cliente.getId());
            return true;
        }
        return false;
    }

    public boolean removerPetDoCliente(Pets pet) {
        Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
        if (cliente != null) {
            List<Pets> petsList = cliente.getPets();
            petsList.remove(pet);
            cliente.setPets(petsList);
            clienteRepositorio.atualizarCliente(cliente, cliente.getId());
            return true;
        }
        return false;
    }
    public List<Servicos> pegarServicosDoPet(Pets pet){
        Pets pett = petsRepositorio.verificarPet(pet.getId());
        if(pett != null){
            return pett.getServicos();
        }
        return null;
    }

    public Pets pegarUmPet(int id){
        Pets pet = petsRepositorio.verificarPet(id);
        if(pet != null){
            return pet;
        }
        return null;
    }
}
