package co.edu.uco.arquisw.infraestructura.asociacion.adaptador.repositorio.implementacion;

import co.edu.uco.arquisw.dominio.asociacion.modelo.Asociacion;
import co.edu.uco.arquisw.dominio.asociacion.puerto.comando.AsociacionRepositorioComando;
import org.springframework.stereotype.Repository;

@Repository
public class AsociacionRepositorioComandoImplementacion implements AsociacionRepositorioComando
{
    @Override
    public Long guardar(Asociacion asociacion, Long usuarioID)
    {
        return null;
    }

    @Override
    public Long actualizar(Asociacion asociacion, Long id)
    {
        return null;
    }
}