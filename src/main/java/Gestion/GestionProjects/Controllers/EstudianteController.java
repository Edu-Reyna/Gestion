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

    //Funcion para registrar un estudiante en la base de datos
    @PostMapping("/usuarios/registrar")
    public String saveEstudiante(@RequestBody Estudiante estudiante) {

        iEstudianteServices.saveEstudiante(estudiante);
        return "Estudiante guardado";

    }

    //Funcion que busca encontrar un estudiante y devolver su id
    @PostMapping("/login")
    public String getEstudiante(@RequestBody Estudiante estudiante) {

        Estudiante estudiante1 = iEstudianteServices.getEstudiante(estudiante);

        if (estudiante1 != null) {
            return estudiante1.getId_estudiante().toString();
        } else {
            return null;
        }
    }


}
