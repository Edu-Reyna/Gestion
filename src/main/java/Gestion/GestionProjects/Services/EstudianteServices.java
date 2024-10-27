package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServices implements IEstudianteServices {
    @Override
    public List<Estudiante> getAllEstudiantes() {
        return List.of();
    }

    @Override
    public void saveEstudiante(Estudiante estudiante) {

    }

    @Override
    public void deleteEstudiante(Long id) {

    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {

    }

    @Override
    public Estudiante getEstudiante(Estudiante estudiante) {
        return null;
    }
}
