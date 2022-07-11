package co.edu.uco.arquisw.dominio.proyecto.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class EstadoProyecto
{
    private String nombre;

    private EstadoProyecto(String nombre)
    {
        setNombre(nombre);
    }

    public static EstadoProyecto crear(String nombre)
    {
        return new EstadoProyecto(nombre);
    }

    public void setNombre(String nombre)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_ESTADO_PROYECTO_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarSiLongitudEsValida(nombre, 10, 13, Mensajes.LONGITUD_NOMBRE_ESTADO_PROYECTO_INVALIDA);
        ValidarTexto.validarPatronTextoEsValido(nombre, Mensajes.PATRON_NOMBRE_ESTADO_PROYECTO_NO_ES_VALIDO);

        this.nombre = nombre;
    }
}