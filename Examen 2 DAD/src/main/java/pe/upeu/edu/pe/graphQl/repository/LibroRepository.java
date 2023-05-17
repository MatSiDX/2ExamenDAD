package pe.upeu.edu.pe.graphQl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.pe.graphQl.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
