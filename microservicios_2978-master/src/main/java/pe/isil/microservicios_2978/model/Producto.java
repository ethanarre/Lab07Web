package pe.isil.microservicios_2978.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;
    private String descripcion;
    private String nombre;
    private Float precio;
    private String categoria;
    private Integer stock;

}
