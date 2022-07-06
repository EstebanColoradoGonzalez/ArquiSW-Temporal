package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.DuplicidadExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioActualizarUsuario
{
    private final PersonaRepositorioComando personaRepositorioComando;
    private final UsuarioRepositorioComando usuarioRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioActualizarUsuario(PersonaRepositorioComando personaRepositorioComando, UsuarioRepositorioComando usuarioRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioComando = personaRepositorioComando;
        this.usuarioRepositorioComando = usuarioRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Persona persona, Long id)
    {
        validarSiExisteUsuarioConCorreo(persona);

        this.usuarioRepositorioComando.actualizar(persona.getCorreo(), persona.getClave(), id);

        return this.personaRepositorioComando.actualizar(persona,id);
    }

    private void validarSiExisteUsuarioConCorreo(Persona persona)
    {
        if(this.usuarioRepositorioComando.existeCorreo(persona.getCorreo()))
        {
            throw new DuplicidadExcepcion(Mensajes.EXISTE_USUARIO_CON_CORREO);
        }
    }
}
