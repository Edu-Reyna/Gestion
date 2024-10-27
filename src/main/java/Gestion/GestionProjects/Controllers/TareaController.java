package Gestion.GestionProjects.Controllers;

import Gestion.GestionProjects.Services.ITareaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TareaController {

    @Autowired
    private ITareaServices iTareaServices;
}
