package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.Entities.Estudiante;
import Gestion.GestionProjects.Services.IEstudianteServices;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor @NoArgsConstructor
@RestController
public class EstudianteController {

    @Autowired
    private IEstudianteServices iEstudianteServices;

    @PostMapping("/usuarios/registrar")
    public String saveEstudiante(@RequestBody Estudiante estudiante) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, estudiante.getContrasena());
        estudiante.setContrasena(hash);

        iEstudianteServices.saveEstudiante(estudiante);
        return "Estudiante guardado";

    }


    @GetMapping("/login")
    public String getEstudiante(@RequestBody Estudiante estudiante) {

        Estudiante estudiante1 = iEstudianteServices.getEstudiante(estudiante);

        if (estudiante1 != null) {
            return estudiante1.getId_estudiante().toString();
        } else {
            return "Estudiante no encontrado";
        }
    }


}
