package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;

public class ServicioGuardarUsuario {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el usuario con los datos ingresados";
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final UsuarioRepositorioComando usuarioRepositorioComando;


    public ServicioGuardarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, UsuarioRepositorioComando usuarioRepositorioComando) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;

        this.usuarioRepositorioComando = usuarioRepositorioComando;
    }
    public Long ejecutar(Persona persona)
    {
         if(this.personaRepositorioConsulta.consultarPorCorreo(persona.getCorreo()) != null)
         {
             throw new IllegalStateException(MENSAJE_YA_EXISTE);
         }
         this.usuarioRepositorioComando.guardar(persona.getCorreo(),persona.getClave());
         return this.personaRepositorioComando.guardar(persona);
    }
}
