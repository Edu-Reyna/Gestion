package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;

import java.util.List;

public interface ITareaServices {

    public List<Tarea> getAllTareas(Estudiante estudiante);

    public void saveTarea(Tarea tarea);

    public void deleteTarea(Long id);

    public void updateTarea(Tarea tarea);

    public Tarea getTareaById(Long id);
}
