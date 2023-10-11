package pe.isil.microservicios_2978.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.microservicios_2978.model.Docente;

import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    Optional<Docente> findByEmail(String email); //select * from docente where email = ?

    //boolean existsByDni(String dni);
}
