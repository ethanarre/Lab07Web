package pe.isil.microservicios_2978.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.microservicios_2978.model.Docente;
import pe.isil.microservicios_2978.repository.DocenteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api_2978/docentes")
public class DocenteController {
    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/getAll")
    public List<Docente> getAll(){
        return docenteRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Docente> getById(@PathVariable ("id") Integer id){
        return docenteRepository.findById(id);
    }

    @PostMapping("/store")
    public Docente store(@RequestBody Docente docente){
        docente.setId(0);
        return docenteRepository.save(docente);
    }

    @PutMapping("/update/{id}")
    public Docente update(@RequestBody Docente docente, @PathVariable ("id") Integer id){
        Docente docenteFromDB = docenteRepository.getById(id);

        docenteFromDB.setEmail(docente.getEmail());
        docenteFromDB.setNombres_apellidos(docente.getNombres_apellidos());

        return docenteRepository.save(docenteFromDB);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Docente> delete(@PathVariable ("id") Integer id){
        docenteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //public boolean existe(@PathVariable ("dni"))

    @GetMapping("/getByEmail/{email}")
    public Optional<Docente> getByEmail(@PathVariable ("email") String email){
        return docenteRepository.findByEmail(email);
    }

}
