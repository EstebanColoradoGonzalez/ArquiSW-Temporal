package co.edu.uco.arquisw.infraestructura.usuario.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginControlador
{
    @GetMapping
    public String IniciarSesion()
    {
        return "Aceptado";
    }
}
