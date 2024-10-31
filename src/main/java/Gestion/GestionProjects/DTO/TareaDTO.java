package Gestion.GestionProjects.DTO;

import Gestion.GestionProjects.Entities.Categoria;
import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Prioridad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TareaDTO {

    private Long id;
    private String titulo;
    private Date fechaFin;
    private Prioridad prioridad;
    private boolean estado;
    private Categoria categoria;
    private Estudiante estudiante;

}
