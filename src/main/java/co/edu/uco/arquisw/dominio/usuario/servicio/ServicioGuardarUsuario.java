package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioGuardarUsuario
{
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final UsuarioRepositorioComando usuarioRepositorioComando;

    public ServicioGuardarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, UsuarioRepositorioComando usuarioRepositorioComando)
    {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.usuarioRepositorioComando = usuarioRepositorioComando;
    }

    public Long ejecutar(Persona persona)
    {
         if(!ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorCorreo(persona.getCorreo())))
         {
             throw new ValorInvalidoExcepcion(Mensajes.EXISTE_USUARIO_CON_CORREO);
         }

         this.usuarioRepositorioComando.guardar(persona.getCorreo(),persona.getClave());

         return this.personaRepositorioComando.guardar(persona);
    }
}
