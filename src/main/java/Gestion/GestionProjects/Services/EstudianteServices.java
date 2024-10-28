package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Repositories.IEstudianteRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Estudiante getEstudiante(Estudiante estudiante) {
        List<Estudiante> lista = iEstudianteRepository.findAll().stream()
                .filter(n -> n.getEmail().equals(estudiante.getEmail())).toList();
        if (lista.isEmpty()){
            return null;
        }
        String passwordHash = lista.getFirst().getContrasena();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHash, estudiante.getContrasena())) {
            return lista.getFirst();
        }
        return null;
    }
}
