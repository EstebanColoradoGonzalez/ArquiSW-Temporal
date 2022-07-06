package co.edu.uco.arquisw.dominio.usuario.servicio;


import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioEliminarUsuario {
    private static final String MENSAJE_NO_EXISTE = "No existe el Usuario con los datos ingresados";
    private final PersonaRepositorioComando personaRepositorioComando;
    private final UsuarioRepositorioComando usuarioRepositorioComando;

    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioEliminarUsuario(PersonaRepositorioComando personaRepositorioComando, UsuarioRepositorioComando usuarioRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.usuarioRepositorioComando = usuarioRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public void ejecutar(Long id)
    {
        if(this.personaRepositorioConsulta.consultarPorId(id) == null)
        {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
        this.usuarioRepositorioComando.eliminar(id);
        this.personaRepositorioComando.eliminar(id);
    }
}
