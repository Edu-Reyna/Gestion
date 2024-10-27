package Gestion.GestionProjects.Services;

import Gestion.GestionProjects.Entities.Estudiante;

import java.util.List;

public interface IEstudianteServices {

    public List<Estudiante> getAllEstudiantes();

    public void saveEstudiante(Estudiante estudiante);

    public void deleteEstudiante(Long id);

    public void updateEstudiante(Estudiante estudiante);

    public Estudiante getEstudiante(Estudiante estudiante);

}
