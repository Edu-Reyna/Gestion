package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.DTO.TareaDTO;
import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;
import Gestion.GestionProjects.Services.ITareaServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@RestController
public class TareaController {

    @Autowired
    private ITareaServices iTareaServices;

    //Funcion que recibe un objeto de tipo tarea y lo inserta en la base de datos
    @PostMapping("/tareas/registrar")
    public String saveTarea(@RequestBody Tarea tarea) {
        tarea.setEstado(false);

        iTareaServices.saveTarea(tarea);
        return "Tarea guardada";
    }

    //Funcion que recibe una tarea y la actualiza
    @PutMapping("/tareas/actualizar")
    public String updateTarea(@RequestBody Tarea tarea) {

        iTareaServices.updateTarea(tarea);
        return "Tarea actualizada";

    }

    //Funcion que recibe un id de tarea y lo elimina de la base de datos
    @DeleteMapping("/tareas/eliminar/{id}")
    public String deleteTarea(@PathVariable("id") Long id) {
        iTareaServices.deleteTarea(id);
        return "Tarea eliminada";
    }

    //Funcion que recibe un id de estudiante y devuelve su respectiva lista de tareas
    @PostMapping("/tareas/lista")
    public List<TareaDTO> getAllTareas(@RequestBody Estudiante estudiante) {

        var tareas = iTareaServices.getAllTareas(estudiante);
        List<TareaDTO> tareasDTO = new ArrayList<>();

        for (Tarea tarea : tareas) {
            TareaDTO tareaDTO = new TareaDTO(
                    tarea.getId(),
                    tarea.getTitulo(),
                    tarea.getFechaFin(),
                    tarea.getPrioridad(),
                    tarea.isEstado(),
                    tarea.getCategoria(),
                    tarea.getEstudiante()
            );
            tareasDTO.add(tareaDTO);
        }
        return tareasDTO;
    }

    //Funcion que recibe un id de tarea y cambia su estado de true a false o viceversa
    @PutMapping("/tareas/cambiarEstado/{id}")
    public String ChangeStatus(@PathVariable("id") Long id) {
        Tarea tarea = iTareaServices.getTareaById(id);

        tarea.setEstado(!tarea.isEstado());
        iTareaServices.updateTarea(tarea);
        return "Tarea actualizada";
    }

}
