package co.edu.uco.arquisw.dominio.usuario.puerto.usuario.consulta;

import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;

public interface UsuarioRepositorioConsulta
{
    UsuarioDTO consultarPorCorreoYClave(String clave);
}
