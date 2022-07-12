package co.edu.uco.arquisw.aplicacion.proyecto.comando.fabrica;

import co.edu.uco.arquisw.aplicacion.proyecto.comando.ProyectoComando;
import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Proyecto;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProyectoFabrica
{
    @Autowired
    TipoConsultoriaFabrica tipoConsultoriaFabrica;

    public Proyecto construir(ProyectoComando proyecto)
    {
        return Proyecto.crear(proyecto.getNombre(), proyecto.getDescripcion(), obtenerEstadoPorDefecto(), tipoConsultoriaFabrica.construirTodos(proyecto.getTiposConsultoria()));
    }

    private EstadoProyecto obtenerEstadoPorDefecto()
    {
        return EstadoProyecto.crear(TextoConstante.ESTADO_EN_DESARROLLO);
    }
}