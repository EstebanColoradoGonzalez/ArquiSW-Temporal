package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.LongitudExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RolTest {

    @Test
    void validarCreacionExitosa()
    {
        String nombre = "Administrasdor";

        Rol rol = Rol.crear(nombre);

        Assertions.assertEquals(nombre, rol.getNombre());
    }
    @Test
    void validarCampoFaltante()
    {
        String nombre = "";

        Assertions.assertEquals("El nombre no puede estar vacio",Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Rol.crear(nombre)).getMessage());
    }

    @Test
    void validarLongitudesInorrectas()
    {
        String nombre = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        Assertions.assertEquals(Mensajes.LONGITUD_NOMBRE_ROL_INVALIDA,Assertions.assertThrows(LongitudExcepcion.class,() ->
                Rol.crear(nombre)).getMessage());
    }

    @Test
    void validarPatronesInorrectas()
    {
        String nombre = "admin-1234";

        Assertions.assertEquals(Mensajes.PATRON_NOMBRE_ROL_INVALIDO,Assertions.assertThrows(PatronExcepcion.class,() ->
                Rol.crear(nombre)).getMessage());
    }
}
