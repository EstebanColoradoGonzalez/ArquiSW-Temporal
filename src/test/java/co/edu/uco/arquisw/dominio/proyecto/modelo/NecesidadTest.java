package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.EstadoNesecidadTestDataBuilder;
import co.edu.uco.arquisw.dominio.proyecto.testdatabuilder.ProyectoTestDataBuilder;
import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NecesidadTest
{
    @Test
    void validarCreacionExitosa()
    {
        String nombre = "Facebook";
        String descripcion = "Red Social";
        String estado = "En Desarrollo";
        String tipo = "Ingeniería de Requisitos";
        String rutaArchivo = "http://www.direccion.org/ejemplo/item.html";
        String estadoN= "En Espera";

        var estadoProyecto = EstadoProyecto.crear(estado);
        var tipoConsultoria = TipoConsultoria.crear(tipo);
        var estadoNecesidad = EstadoNecesidad.crear(estadoN);

        var proyecto = Proyecto.crear(nombre, descripcion, estadoProyecto, List.of(tipoConsultoria));
        var necesidad = Necesidad.crear(rutaArchivo,estadoNecesidad, proyecto);

        Assertions.assertEquals(rutaArchivo, necesidad.getRutaArchivo());
        Assertions.assertEquals(nombre, necesidad.getProyecto().getNombre());
        Assertions.assertEquals(descripcion, necesidad.getProyecto().getDescripcion());
        Assertions.assertEquals(estado, necesidad.getProyecto().getEstado().getNombre());
        Assertions.assertEquals(tipo, necesidad.getProyecto().getTiposConsultoria().get(0).getNombre());
    }
    @Test
    void validarCamposFaltantes()
    {
        Assertions.assertEquals(Mensajes.RUTA_ARCHIVO_NECESIDAD_NO_PUEDE_ESTAR_VACIO,Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Necesidad.crear("",new EstadoNesecidadTestDataBuilder().build(),new ProyectoTestDataBuilder().build())).getMessage());
    }
    @Test
    void validarPatronIncorrecto()
    {
        Assertions.assertEquals(Mensajes.PATRON_RUTA_ARCHIVO_NECESIDAD_NO_ES_VALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Necesidad.crear("www.direccion.org/ejemplo/item.html",new EstadoNesecidadTestDataBuilder().build(),new ProyectoTestDataBuilder().build())).getMessage());
    }
}