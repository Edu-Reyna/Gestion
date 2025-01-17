package Gestion.GestionProjects.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;


    @Column
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @OneToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria", nullable = true)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id_estudiante", nullable = true)
    @JsonBackReference
    private Estudiante estudiante;


    private boolean estado;
}
