package co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.mapeador.UsuarioMapeador;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.RolPersonaDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepositorioComandoImplementacion implements PersonaRepositorioComando
{
    @Autowired
    PersonaMapeador personaMapeador;
    @Autowired
    UsuarioMapeador usuarioMapeador;
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    RolPersonaDAO rolPersonaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public Long guardar(Persona persona)
    {
        this.usuarioDAO.save(this.usuarioMapeador.construirEntidad(persona.getCorreo(), persona.getClave()));

        return this.personaDAO.save(this.personaMapeador.construirEntidad(persona)).getId();
    }

    @Override
    public Long actualizar(Persona persona, Long id)
    {
        var entidad = this.personaMapeador.construirEntidad(persona);
        var usuario = this.usuarioDAO.findById(id).orElse(null);

        entidad.setId(id);

        assert usuario != null;
        usuario.setCorreo(persona.getCorreo());
        usuario.setClave(persona.getClave());

        this.usuarioDAO.save(usuario);
        return this.personaDAO.save(entidad).getId();
    }

    @Override
    public void eliminar(Long id)
    {
        var persona = this.personaDAO.findById(id).orElse(null);

        assert persona != null;
        persona.getRoles().forEach(rol ->
        {
            this.rolPersonaDAO.deleteById(rol.getId());
        });

        this.usuarioDAO.deleteById(id);

        this.personaDAO.deleteById(id);
    }
}