package pe.isil.microservicios_2978.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.microservicios_2978.model.Alumno;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    Optional<Alumno> findByDni(String dni);
}
