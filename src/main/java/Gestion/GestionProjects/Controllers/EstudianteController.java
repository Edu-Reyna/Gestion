package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.Services.IEstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteController {

    @Autowired
    private IEstudianteServices iEstudianteServices;
}
