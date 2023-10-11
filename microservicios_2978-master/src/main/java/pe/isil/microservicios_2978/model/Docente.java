package pe.isil.microservicios_2978.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombres_apellidos;

    private String email;
}
