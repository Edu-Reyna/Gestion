package Gestion.GestionProjects.DTO;

import Gestion.GestionProjects.Entities.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CategoriaDTO {

    private Long id_categoria;
    private String tipo_categoria;
    private Estudiante estudiante;
}
