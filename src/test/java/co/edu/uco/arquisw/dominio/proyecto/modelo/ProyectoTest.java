package co.edu.uco.arquisw.dominio.proyecto.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class ProyectoTest
{
    @Test
    void validarCreacionExitosa()
    {
        String nombre = "Facebook";
        String descripcion = "Red Social";
        String estado = "En Desarrollo";
        String tipo = "Ingeniería de Requisitos";

        var estadoProyecto = EstadoProyecto.crear(estado);
        var tipoConsultoria = TipoConsultoria.crear(tipo);

        var proyecto = Proyecto.crear(nombre, descripcion, estadoProyecto, List.of(tipoConsultoria));

        Assertions.assertEquals(nombre, proyecto.getNombre());
        Assertions.assertEquals(descripcion, proyecto.getDescripcion());
        Assertions.assertEquals(estado, proyecto.getEstado().getNombre());
        Assertions.assertEquals(tipo, proyecto.getTiposConsultoria().get(0).getNombre());
    }
}