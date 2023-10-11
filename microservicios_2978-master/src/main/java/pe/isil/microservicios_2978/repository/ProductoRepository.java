package pe.isil.microservicios_2978.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.microservicios_2978.model.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    //listar los 10 productos mas caros
    List<Producto> findTop10ByOrderByPrecioDesc();

    //Listar productos por categoria
    List<Producto> findByCategoria(String categoria);

    //listar producto con el stock mayor a cero (GreaterThan: Mayor que)
    //SELECT * FROM producto WHERE stock > 0;
    List<Producto> findByStockGreaterThan(Integer stock);

    //listar productos con un rango de precios
    //SELECT * FROM producto WHERE precio between 90 and 100 ;
    List<Producto> findByPrecioBetween(float precio_inicial, float precio_final);

}
