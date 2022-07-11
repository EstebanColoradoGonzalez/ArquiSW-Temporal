package co.edu.uco.arquisw.dominio.usuario.puerto.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;

public interface PersonaRepositorioConsulta
{
    PersonaDTO consultarPorId(Long id);
    PersonaDTO consultarPorCorreo(String correo);
    UsuarioDTO consultarConCorreoYClave(String correo);
    boolean existeConCorreo(String correo);
}