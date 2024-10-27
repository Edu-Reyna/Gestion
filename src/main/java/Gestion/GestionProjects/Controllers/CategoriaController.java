package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.Services.ICategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaServices iCategoriaServices;


}
