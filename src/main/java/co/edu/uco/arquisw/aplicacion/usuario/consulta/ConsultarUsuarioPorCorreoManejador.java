package co.edu.uco.arquisw.aplicacion.usuario.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.usuario.servicio.ServicioConsultarUsuarioPorCorreo;
import org.springframework.stereotype.Component;

@Component
public class ConsultarUsuarioPorCorreoManejador
{
    private final ServicioConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo;

    public ConsultarUsuarioPorCorreoManejador(ServicioConsultarUsuarioPorCorreo servicioConsultarUsuarioPorCorreo)
    {
        this.servicioConsultarUsuarioPorCorreo = servicioConsultarUsuarioPorCorreo;
    }

        public UsuarioDTO ejecutar(String correo)
    {
        return this.servicioConsultarUsuarioPorCorreo.ejecutar(correo);
    }
}