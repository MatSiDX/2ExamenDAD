package pe.upeu.edu.pe.graphQl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_libro;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String pagina;

    @Column
    private String edicion;

    @ManyToOne
    @JoinColumn(name="id_autor", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="id_editorial", nullable=false)
    private Editorial editorial;


}
