package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorioConsultaImplementacion implements PersonaRepositorioConsulta
{
    @Autowired
    PersonaMapeador personaMapeador;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public PersonaDTO consultarPorId(Long id)
    {
        var entidad = this.personaDAO.findById(id).orElse(null);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public PersonaDTO consultarPorCorreo(String correo)
    {
        var entidad = this.personaDAO.findByCorreo(correo);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public boolean existeConCorreo(String correo)
    {
        return !ValidarObjeto.esNulo(this.usuarioDAO.findByCorreo(correo));
    }
}