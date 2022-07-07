package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.persona.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando.UsuarioRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.testdatabuilder.PersonaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarUsuarioTest {

    @Test
    void noExistePersonaParaActualizar()
    {
        var persona = new PersonaTestDataBuilder().build();

        var  personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var  usuarioRepositorioComando = Mockito.mock(UsuarioRepositorioComando.class);
        var  personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);

        var servicio= new ServicioActualizarUsuario(personaRepositorioComando,usuarioRepositorioComando, personaRepositorioConsulta);



        Assertions.assertEquals("" + 1,Assertions.assertThrows(ValorInvalidoExcepcion.class,()-> servicio.ejecutar(persona,1L)).getMessage());
    }
}
