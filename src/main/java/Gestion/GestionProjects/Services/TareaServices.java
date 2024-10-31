package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Entities.Tarea;
import Gestion.GestionProjects.Repositories.ITareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TareaServices implements ITareaServices {

    @Autowired
    private ITareaRepository tareaRepository;

    @Override
    public List<Tarea> getAllTareas(Estudiante estudiante) {
        List<Tarea> allTareas = tareaRepository.findAll();
        return allTareas.stream()
                .filter(tarea -> tarea.getEstudiante() != null && tarea.getEstudiante().getId_estudiante().equals(estudiante.getId_estudiante()))
                .toList();
    }


    @Transactional
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

    @Override
    public Tarea getTareaById(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        return tarea;
    }
}
