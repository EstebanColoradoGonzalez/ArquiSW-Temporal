package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ServicioGuardarUsuarioTest {

    @Test
    void guardarExitoso()
    {
        var persona= new PersonaTestDataBuilder().build();

        var repositorioPersonaComando = Mockito.mock(PersonaRepositorioComando.class);
        var repositorioPersonaConsulta= Mockito.mock(PersonaRepositorioConsulta.class);
        var repositorioUsuarioConsulta= Mockito.mock(UsuarioRepositorioComando.class);

        var servicio = new ServicioGuardarUsuario(repositorioPersonaComando,repositorioPersonaConsulta,repositorioUsuarioConsulta);

        Mockito.when(repositorioPersonaComando.guardar(Mockito.any(Persona.class))).thenReturn(1l);

        var id = servicio.ejecutar(persona);

        Mockito.verify(repositorioPersonaComando,Mockito.times(1)).guardar(persona);

        Assertions.assertEquals(1L,id);
        Assertions.assertEquals("juan",persona.getNombre());

    }
}


