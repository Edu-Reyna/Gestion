package Gestion.GestionProjects.Repositories;

import Gestion.GestionProjects.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    @Procedure(name = "GetAllCategorias")
    List<Categoria> getAllCategorias();

    @Procedure(name = "GetCategoryId")
    Categoria getCategoryId( @Param("categoria") Long id);

}
