package Gestion.GestionProjects.Repositories;

import Gestion.GestionProjects.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Procedure(name = "GetEstudentId")
    Estudiante getEstudentId(@Param("e_mail") String email, @Param("contra") String contrasena);
}
