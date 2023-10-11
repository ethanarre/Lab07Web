package pe.isil.microservicios_2978.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.microservicios_2978.model.Producto;
import pe.isil.microservicios_2978.repository.ProductoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api_2978/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    //insertar un nuevo producto
    @PostMapping("/store")
    public Producto store(@RequestBody Producto producto){
        producto.setId(0);//seteando el valor 0 en el id, para que inserte
        return productoRepository.save(producto);
    }

    //obtener producto por su id
    @GetMapping("/getById/{id}")
    public Optional<Producto> getById(@PathVariable("id") Integer id){
        return productoRepository.findById(id);
    }

    //Obtener todos los productos
    @GetMapping("/getAll")
    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    //obtener productos por categoria
    @GetMapping("/getByCategoria/{categoria}")
    public List<Producto> getByCategoria(@PathVariable("categoria") String categoria){
        return productoRepository.findByCategoria(categoria);
    }

    //obtener los productos con stock mayor a cero
    @GetMapping("/getByStock")
    public List<Producto> getByStock()
    {
        return productoRepository.findByStockGreaterThan(0);
    }

    //actualizar un producto
    @PutMapping("/update/{id}")
    public Producto actualizar(@RequestBody Producto producto, @PathVariable("id") Integer id){
        Producto productoFromDB = productoRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("El producto no fue encontrado con el id: " + id));

        productoFromDB.setCodigo(producto.getCodigo());
        productoFromDB.setCategoria(producto.getCategoria());
        productoFromDB.setNombre(producto.getNombre());
        productoFromDB.setPrecio(producto.getPrecio());
        productoFromDB.setStock(producto.getStock());
        productoFromDB.setDescripcion(producto.getDescripcion());

        return productoRepository.save(productoFromDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try {
            productoRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
