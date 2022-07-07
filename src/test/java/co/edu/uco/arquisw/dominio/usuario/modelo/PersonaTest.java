package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.excepciones.LongitudExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.PatronExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorObligatorioExcepcion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonaTest {
    @Test
    void  validarCreacionPersonaExitosa()
    {
         String nombre = "juan";
         String apellidos = "Valencia";
         String correo = "jjuandiego23@gmail.com";
         String clave = "ASDasd1234";
         List<Rol> roles = new ArrayList<>();
         Rol rol =  Rol.crear("administrador");
         roles.add(rol);

         Persona persona = Persona.crear(nombre, apellidos,correo,clave,roles);

        Assertions.assertEquals(nombre,persona.getNombre());
        Assertions.assertEquals(apellidos,persona.getApellidos());
        Assertions.assertEquals(correo,persona.getCorreo());
        Assertions.assertEquals(clave,persona.getClave());
        Assertions.assertEquals(rol,roles.get(0));

    }

    @Test
    void validarCamposFaltantes()
    {
        List<Rol> roles = new ArrayList<>();
        Rol rol =  Rol.crear("administrador");
        roles.add(rol);
        Assertions.assertEquals("El nombre no puede estar vacio",Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("","valencia","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("Los apellidos de una persona no pueden ser vacios",Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("El correo no puede estar vacio",Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","valencia","","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("La clave no puede estar vacia",Assertions.assertThrows(ValorObligatorioExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego23@gmail.com","",roles)).getMessage());

    }

    @Test
    void validarLongitudesCorrectas()
    {
        List<Rol> roles = new ArrayList<>();
        Rol rol =  Rol.crear("administrador");
        roles.add(rol);
        Assertions.assertEquals("La longitud del nombre debe estar entre 1 y 50 caracteres",Assertions.assertThrows(LongitudExcepcion.class,() ->
                Persona.crear("" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","valencia","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("La longitud de los apellidos debe estar entre 1 y 50 caracteres",Assertions.assertThrows(LongitudExcepcion.class,() ->
                Persona.crear("juan","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                        "jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("La longitud del correo debe estar entre 10 y 100 caracteres",Assertions.assertThrows(LongitudExcepcion.class,() ->
                Persona.crear("juan","valencia","jju@com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("La longitud de la clave debe estar entre 8 y 100 caracteres",Assertions.assertThrows(LongitudExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego23@gmail.com","Asd",roles)).getMessage());
    }

    @Test
    void validarPatronesCorrectos()
    {
        List<Rol> roles = new ArrayList<>();
        Rol rol =  Rol.crear("administrador");
        roles.add(rol);
        Assertions.assertEquals("El nombre solo puede contener letras y numeros",Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan1234-","valencia","jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("Los apellidos solo puede contener letras y numeros",Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia123-",
                        "jjuandiego23@gmail.com","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("El correo debe cumplir el patron de @example.com",Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego@asffgh","ASDasd1234",roles)).getMessage());

        Assertions.assertEquals("La clave debe tener minimo una minuscula, una mayuscula y un numero",Assertions.assertThrows(PatronExcepcion.class,() ->
                Persona.crear("juan","valencia","jjuandiego23@gmail.com","aaaaaaaaaaaa",roles)).getMessage());
    }
}
