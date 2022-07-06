package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioActualizarUsuario {

    private static final String MENSAJE_NO_EXISTE = "Ya exixste un usuario con ese correo";
    private final PersonaRepositorioComando personaRepositorioComando;
    private final UsuarioRepositorioComando usuarioRepositorioComando;

    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarUsuario(PersonaRepositorioComando personaRepositorioComando, UsuarioRepositorioComando usuarioRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.usuarioRepositorioComando = usuarioRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Persona persona, Long id)
    {
        if(this.usuarioRepositorioComando.existeCorreo(persona.getCorreo()))
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        this.usuarioRepositorioComando.actualizar(persona.getCorreo(), persona.getClave(), id);
        return this.personaRepositorioComando.actualizar(persona,id);
    }
}
