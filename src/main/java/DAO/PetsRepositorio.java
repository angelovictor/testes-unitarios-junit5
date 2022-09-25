package DAO;

import model.Pets;

import java.util.ArrayList;
import java.util.List;

public class PetsRepositorio {
    private static PetsRepositorio petsRepositorio;
    private List<Pets> pets = new ArrayList<>();
    private ClienteRepositorio clienteRepositorio = ClienteRepositorio.getInstance();

    public static PetsRepositorio getInstance() {
        if (petsRepositorio == null) {
            petsRepositorio = new PetsRepositorio();
        }
        return petsRepositorio;
    }

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }

    public void addPet(Pets pet) {
        int ultimoID = 1;
        for (int i = 0; i < pets.size(); i++) {
            ultimoID++;
        }
        pet.setId(ultimoID);
        pets.add(pet);

    }

    public void removerPet(int id) {
        Pets removerPet = verificarPet(id);
        pets.remove(removerPet);
    }

    public Pets verificarPet(int id) {
        for (Pets pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public void editarPet(Pets pet, int id) {
        Pets atualizarPet = verificarPet(id);
        if (atualizarPet != null) {
            atualizarPet.setRaca(pet.getRaca());
            atualizarPet.setDono(pet.getDono());
            atualizarPet.setNome(pet.getNome());
            atualizarPet.setServicos(pet.getServicos());
        }
    }
}
