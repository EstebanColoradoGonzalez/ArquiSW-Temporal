package co.edu.uco.arquisw.aplicacion.usuario.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.usuario.comando.PersonaComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonaFabrica
{
    public Persona construir(PersonaComando persona)
    {
        return Persona.crear(persona.getNombre(), persona.getApellidos(), persona.getCorreo(), persona.getClave(), obtenerRolesPorDefecto());
    }

    private List<Rol> obtenerRolesPorDefecto()
    {
        return List.of(Rol.crear(TextoConstante.ROL_USUARIO));
    }
}