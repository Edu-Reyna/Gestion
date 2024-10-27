package Gestion.GestionProjects.Repositories;

import Gestion.GestionProjects.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {
}
