package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;

public class ServicioConsultarUsuarioPorId
{
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ServicioConsultarUsuarioPorId(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(Long id)
    {
        validarSiNoExisteUsuarioConId(id);

        return personaRepositorioConsulta.consultarPorId(id);
    }

    private void validarSiNoExisteUsuarioConId(Long id)
    {
        if(ValidarObjeto.esNulo(this.personaRepositorioConsulta.consultarPorId(id)))
        {
            throw new ValorInvalidoExcepcion(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + id);
        }
    }
}