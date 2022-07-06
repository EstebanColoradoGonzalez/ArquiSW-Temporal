package co.edu.uco.arquisw.dominio.usuario.puerto;

import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import java.util.List;

public interface UsuarioRepositorio
{
    List<PersonaDTO> consultar();
    PersonaDTO consultarPorCodigo(int codigo);
    PersonaDTO consultarPorCorreo(String correo);
    Persona consultarPorCorreoConClave(String correo);
    PersonaDTO consultarPorNumeroIdentificacion(String numeroIdentificacion);
    void guardar(Persona persona);
    void actualizar(Persona persona, int codigo);
    void eliminar(int codigo);
    boolean existe(Persona persona);
}