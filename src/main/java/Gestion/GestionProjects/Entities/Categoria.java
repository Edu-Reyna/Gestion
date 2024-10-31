package Gestion.GestionProjects.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id_categoria;

    private String tipo_categoria;

    @OneToMany(mappedBy = "categoria")
    @JsonManagedReference("tarea-categoria")
    private List<Tarea> tareas;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id_categoria +
                ", tipoCategoria='" + tipo_categoria + '\'' +
                '}';
    }
}
