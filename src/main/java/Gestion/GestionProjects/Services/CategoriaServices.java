package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Categoria;
import Gestion.GestionProjects.Repositories.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServices implements ICategoriaServices {

    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    @Transactional
    @Override
    public List<Categoria> getAllCategorias(Long id) {

        return iCategoriaRepository.getAllCategorias(id);
    }

    @Override
    public void saveCategoria(Categoria categoria) {

        iCategoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {

        iCategoriaRepository.deleteById(id);
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return iCategoriaRepository.getCategoryId(categoria.getId_categoria());
    }
}
