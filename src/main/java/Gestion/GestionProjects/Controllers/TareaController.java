package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;
import Gestion.GestionProjects.Services.ITareaServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@RestController
public class TareaController {

    @Autowired
    private ITareaServices iTareaServices;

    @PostMapping("/tareas/registrar")
    public String saveTarea(@RequestBody Tarea tarea) {

        return iTareaServices.saveTarea(tarea);
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

    @GetMapping("/tareas/lista")
    public List<Tarea> getAllTareas(Estudiante estudiante) {

        return iTareaServices.getAllTareas(estudiante);
    }

}
