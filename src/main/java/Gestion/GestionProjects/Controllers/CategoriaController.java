package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.DTO.CategoriaDTO;
import Gestion.GestionProjects.Entities.Categoria;
import Gestion.GestionProjects.Services.ICategoriaServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaServices iCategoriaServices;


    //Funcion que recibe un objeto de tipo categoria y lo inserta en la base de datos
    @PostMapping("/categorias/registrar")
    public String saveCategoria(@RequestBody Categoria categoria) {

        iCategoriaServices.saveCategoria(categoria);
        return "Categoria guardada";
    }

    //Funcion que recibe un id de estudiante y devuelve su respectiva lista de categorias
    @GetMapping("/categorias/lista/{id}")
    public List<CategoriaDTO> getAllCategorias(@PathVariable("id") Long id) {

        var catego = iCategoriaServices.getAllCategorias(id);
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();

        for (Categoria cat : catego) {

            CategoriaDTO categoriaDTO = new CategoriaDTO(
                    cat.getId_categoria(),
                    cat.getTipo_categoria(),
                    cat.getEstudiante()
            );

            categoriasDTO.add(categoriaDTO);
        }
        return categoriasDTO;
    }

    //Funcion que recibe un id de categoria y lo elimina de la base de datos
    @DeleteMapping("/categorias/eliminar/{id}")
    public String deleteCategoria(@PathVariable("id") Long id) {

        iCategoriaServices.deleteCategoria(id);
        return "Categoria eliminada";
    }

    //Funcion a futuro que recibe una categoria y se podria usar para actualizar la categoria en la base de datos
    public Categoria getCategoria( @RequestBody Categoria categoria) {

        return iCategoriaServices.getCategoria(categoria);
    }

}
