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

    @PostMapping("/tareas/registrar")
    public String saveTarea(@RequestBody Tarea tarea) {
        tarea.setEstado(false);

        iTareaServices.saveTarea(tarea);
        return "Tarea guardada";
    }

    @PutMapping("/tareas/actualizar")
    public String updateTarea(@RequestBody Tarea tarea) {


        iTareaServices.updateTarea(tarea);
        return "Tarea actualizada";
    }

    @DeleteMapping("/tareas/eliminar/{id}")
    public String deleteTarea(@PathVariable("id") Long id) {
        iTareaServices.deleteTarea(id);
        return "Tarea eliminada";
    }

    @PostMapping("/tareas/lista")
    public List<TareaDTO> getAllTareas(@RequestBody Estudiante estudiante) {

        var tareas = iTareaServices.getAllTareas(estudiante);
        List<TareaDTO> tareasDTO = new ArrayList<>();

        for (Tarea tarea : tareas) {
            String tipoCategoria = tarea.getCategoria() != null ? tarea.getCategoria().getTipo_categoria() : null;
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


    @PutMapping("/tareas/cambiarEstado/{id}")
    public String ChangeStatus(@PathVariable("id") Long id) {
        Tarea tarea = iTareaServices.getTareaById(id);

        tarea.setEstado(!tarea.isEstado());
        iTareaServices.updateTarea(tarea);
        return "Tarea actualizada";
    }

}
