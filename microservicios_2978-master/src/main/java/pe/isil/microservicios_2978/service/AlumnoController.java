package pe.isil.microservicios_2978.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.microservicios_2978.model.Alumno;
import pe.isil.microservicios_2978.repository.AlumnoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody Alumno alumno){
        String nombre = alumno.getNombre();
        String apellido = alumno.getApellido();
        Integer edad = alumno.getEdad();
        String correo = alumno.getCorreo();
        String dni = alumno.getDni();

        LoginResult loginResult = validateCredentials(nombre,apellido,edad,correo,dni);

        switch (loginResult) {
            case LOGIN_SUCCESSFUL:
                return ResponseEntity.ok("Login successful");
            case INVALID_CREDENTIALS:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            case USER_NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown error");
        }
    }
    public enum LoginResult{
        LOGIN_SUCCESSFUL,
        INVALID_CREDENTIALS,
        USER_NOT_FOUND
    }

    public LoginResult validateCredentials(String nombre, String apellido, Integer edad, String correo, String dni){
        Optional<Alumno> optionalAlumno = alumnoRepository.findByDni(dni);
        if(optionalAlumno.isPresent()){
            Alumno alumno = optionalAlumno.get();
            if (nombre.equals(alumno.getNombre())){
                return LoginResult.LOGIN_SUCCESSFUL;
            }else {
                return LoginResult.INVALID_CREDENTIALS;
            }
        }
        return LoginResult.USER_NOT_FOUND;
    }
}
