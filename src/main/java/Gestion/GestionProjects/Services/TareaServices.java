package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;
import Gestion.GestionProjects.Repositories.ITareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServices implements ITareaServices {

    @Autowired
    private ITareaRepository tareaRepository;

    @Override
    public List<Tarea> getAllTareas(Estudiante estudiante) {
        return tareaRepository.getTareas(estudiante.getId_estudiante());
    }

    @Override
    public void saveTarea(Tarea tarea) {
        tareaRepository.save(tarea);

    }

    @Override
    public void deleteTarea(Long id) {

        tareaRepository.deleteById(id);
    }

    @Override
    public void updateTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }
}
