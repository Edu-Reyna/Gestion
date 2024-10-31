package Gestion.GestionProjects.Repositories;

import Gestion.GestionProjects.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {

    @Procedure(name = "getAllTaskId")
    List<Tarea> getAllTaskId(@Param("estu") Long idEstudiante);

}
