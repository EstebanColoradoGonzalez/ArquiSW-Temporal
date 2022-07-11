package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;

public class ServicioConsultarUsuarioPorCorreo
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarUsuarioPorCorreo(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UsuarioDTO ejecutar(String correo)
    {
        validarSiNoExisteUsuarioConId(correo);

        return personaRepositorioConsulta.consultarConCorreoYClave(correo);
    }

    private void validarSiNoExisteUsuarioConId(String correo)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarConCorreoYClave(correo)))
        {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_CORREO + correo);
        }
    }
}