package pe.isil.microservicios_2978.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.microservicios_2978.model.Proveedor;
import pe.isil.microservicios_2978.repository.ProveedorRepository;

@RestController
@RequestMapping("proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    //insertar un nuevo proveedor
    @PostMapping("/store")
    public Proveedor store(@RequestBody Proveedor proveedor){
        proveedor.setCodigo(0);//seteando el valor 0 en el id, para que inserte
        return proveedorRepository.save(proveedor);
    }
}
