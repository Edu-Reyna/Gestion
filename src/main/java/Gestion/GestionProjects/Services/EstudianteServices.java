package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Repositories.IEstudianteRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EstudianteServices implements IEstudianteServices {

    @Autowired
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return List.of();
    }

    @Override
    public void saveEstudiante(Estudiante estudiante) {

        iEstudianteRepository.save(estudiante);
    }

    @Override
    public void deleteEstudiante(Long id) {

        iEstudianteRepository.deleteById(id);

    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {

        iEstudianteRepository.save(estudiante);
    }

    @Transactional
    @Override
    public Estudiante getEstudiante(Estudiante estudiante) {

        return iEstudianteRepository.getEstudentId(estudiante.getEmail(), estudiante.getContrasena());
    }

    @Override
    public Estudiante getEstudentId(String id) {
        Long id2 = Long.parseLong(id);
        return (Estudiante) iEstudianteRepository.findAllById(Collections.singleton(id2));
    }
}
