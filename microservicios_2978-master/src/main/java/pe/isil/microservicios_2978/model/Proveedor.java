package pe.isil.microservicios_2978.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id /*Es la marca para decir que ese campo es PK*/
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;

    @Column(name="ruc")
    private String ruc;

    @Column(name="razon_social")
    private String razonSocial;

    @Column(name="direccion")
    private String direccion;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
