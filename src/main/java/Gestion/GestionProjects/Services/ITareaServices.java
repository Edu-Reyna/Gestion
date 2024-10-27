package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;

import java.util.List;

public interface ITareaServices {

    public List<Tarea> getAllTareas(Estudiante estudiante);

    public String saveTarea(Tarea tarea);

    public void deleteTarea(Long id);

    public Tarea updateTarea(Tarea tarea);
}
