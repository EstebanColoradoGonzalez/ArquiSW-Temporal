package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.NecesidadComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoNecesidad;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.beans.factory.annotation.Autowired;

public class NecesidadFabrica
{
    @Autowired
    ProyectoFabrica proyectoFabrica;

    public Necesidad construir(NecesidadComando necesidad)
    {
        return Necesidad.crear(necesidad.getRutaArchivo(), obtenerEstadoPorDefecto(), proyectoFabrica.construir(necesidad.getProyecto()));
    }

    private EstadoNecesidad obtenerEstadoPorDefecto()
    {
        return EstadoNecesidad.crear(TextoConstante.ESTADO_EN_ESPERA);
    }
}