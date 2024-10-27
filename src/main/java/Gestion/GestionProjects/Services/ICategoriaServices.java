package Gestion.GestionProjects.Services;


import Gestion.GestionProjects.Entities.Categoria;

import java.util.List;

public interface ICategoriaServices {

    public List<Categoria> getAllCategorias();

    public void saveCategoria(Categoria categoria);

    public void deleteCategoria(Long id);

    public Categoria getCategoria(Categoria categoria);
}
