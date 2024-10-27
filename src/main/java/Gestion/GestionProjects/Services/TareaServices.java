package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServices implements ITareaServices {
    @Override
    public List<Tarea> getAllTareas(Estudiante estudiante) {
        return List.of();
    }

    @Override
    public String saveTarea(Tarea tarea) {
        return "";
    }

    @Override
    public void deleteTarea(Long id) {

    }

    @Override
    public Tarea updateTarea(Tarea tarea) {
        return null;
    }
}
