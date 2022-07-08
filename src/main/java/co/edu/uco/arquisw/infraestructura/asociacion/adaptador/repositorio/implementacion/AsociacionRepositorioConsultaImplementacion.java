package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.mapeador.AsociacionMapeador;
import co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.jpa.AsociacionDAO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsociacionRepositorioConsultaImplementacion implements AsociacionRepositorioConsulta
{
    @Autowired
    AsociacionMapeador asociacionMapeador;
    @Autowired
    AsociacionDAO asociacionDAO;
    @Autowired
    PersonaDAO personaDAO;

    @Override
    public AsociacionDTO consultarPorID(Long id)
    {
        var usuario = this.personaDAO.findById(id).orElse(null);
        var entidad = this.asociacionDAO.findByUsuario(id);

        assert usuario != null;
        return this.asociacionMapeador.construirDTO(entidad, usuario.getNombre());
    }

    @Override
    public AsociacionDTO consultarPorNIT(String nit)
    {
        var entidad = this.asociacionDAO.findByNit(nit);

        if(ValidarObjeto.esNulo(entidad))
        {
            return null;
        }

        return this.asociacionMapeador.construirDTO(entidad, TextoConstante.VACIO);
    }
}