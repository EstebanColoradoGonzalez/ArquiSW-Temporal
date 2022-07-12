package co.edu.uco.arquisw.dominio.proyecto.servicio;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.proyecto.modelo.Necesidad;
import co.edu.uco.arquisw.dominio.proyecto.puerto.comando.NecesidadRepositorioComando;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarObjeto;

public class ServicioGuardarNesecidad {

    private final NecesidadRepositorioComando necesidadRepositorioComando;
    private final AsociacionRepositorioConsulta asociacionRepositorioConsulta;

    public ServicioGuardarNesecidad(NecesidadRepositorioComando necesidadRepositorioComando, AsociacionRepositorioConsulta asociacionRepositorioConsulta) {
        this.necesidadRepositorioComando = necesidadRepositorioComando;
        this.asociacionRepositorioConsulta = asociacionRepositorioConsulta;
    }

    public Long ejecutar(Necesidad necesidad, Long asociacionID)
    {
        validarSiExisteAsociacionConId(asociacionID);
        return this.necesidadRepositorioComando.guardar(necesidad, asociacionID);
    }

    private void validarSiExisteAsociacionConId(Long asociacionID)
    {
        if(!ValidarObjeto.esNulo(this.asociacionRepositorioConsulta.consultarPorID(asociacionID)))
        {
            throw new NullPointerException(Mensajes.NO_EXISTE_ASOCIACION_CON_EL_ID + asociacionID);
        }
    }

}
