package co.edu.uco.arquisw.dominio.usuario.servicio;


import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioEliminarUsuario
{
    private final PersonaRepositorioComando personaRepositorioComando;
    private final UsuarioRepositorioComando usuarioRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioEliminarUsuario(PersonaRepositorioComando personaRepositorioComando, UsuarioRepositorioComando usuarioRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioComando = personaRepositorioComando;
        this.usuarioRepositorioComando = usuarioRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Long ejecutar(Long id)
    {
        validarSiNoExisteUsuarioConId(id);

        this.usuarioRepositorioComando.eliminar(id);
        this.personaRepositorioComando.eliminar(id);

        return id;
    }

    private void validarSiNoExisteUsuarioConId(Long id)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id)))
        {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}