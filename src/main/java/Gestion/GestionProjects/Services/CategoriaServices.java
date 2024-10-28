package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Categoria;
import Gestion.GestionProjects.Repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServices implements ICategoriaServices {

    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    @Override
    public List<Categoria> getAllCategorias() {
        return List.of();
    }

    @Override
    public void saveCategoria(Categoria categoria) {

    }

    @Override
    public void deleteCategoria(Long id) {

    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return null;
    }
}
