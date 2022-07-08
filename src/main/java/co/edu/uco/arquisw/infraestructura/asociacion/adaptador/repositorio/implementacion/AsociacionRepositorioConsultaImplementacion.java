package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import org.springframework.stereotype.Repository;

@Repository
public class AsociacionRepositorioConsultaImplementacion implements AsociacionRepositorioConsulta
{
    @Override
    public AsociacionDTO consultarPorID(Long id)
    {
        return null;
    }

    @Override
    public AsociacionDTO consultarPorNIT(String nit)
    {
        return null;
    }
}