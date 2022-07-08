package co.edu.uco.arquisw.dominio.asociacion.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Asociacion
{
    private String nombre;
    private String nit;
    private String numeroContacto;

    private Asociacion(String nombre, String nit, String numeroContacto)
    {
        setNombre(nombre);
        setNit(nit);
        setNumeroContacto(numeroContacto);
    }

    public static Asociacion crear(String nombre, String nit, String numeroContacto)
    {
        return new Asociacion(nombre, nit, numeroContacto);
    }

    public void setNombre(String nombre)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NOMBRE_ASOCIACION_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarSiLongitudEsValida(nombre, 1, 50, Mensajes.LONGITUD_NOMBRE_ASOCIACION_INVALIDO);
        ValidarTexto.validarPatronAlfanumericoEsValido(nombre, Mensajes.PATRON_NOMBRE_ASOCIACION_NO_ES_VALIDO);

        this.nombre = nombre;
    }

    public void setNit(String nit)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NIT_ASOCIACION_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarSiLongitudEsValida(nombre, 1, 11, Mensajes.LONGITUD_NIT_ASOCIACION_INVALIDO);
        ValidarTexto.validarPatronNITEsValido(nombre, Mensajes.PATRON_NIT_ASOCIACION_NO_ES_VALIDO);

        this.nit = nit;
    }

    public void setNumeroContacto(String numeroContacto)
    {
        ValidarTexto.validarObligatorio(nombre, Mensajes.NUMERO_ASOCIACION_NO_PUEDE_ESTAR_VACIO);
        ValidarTexto.validarSiLongitudEsValida(nombre, 1, 15, Mensajes.LONGITUD_NUMERO_ASOCIACION_INVALIDO);
        ValidarTexto.validarPatronNumeroEsValido(nombre, Mensajes.PATRON_NUMERO_ASOCIACION_NO_ES_VALIDO);

        this.numeroContacto = numeroContacto;
    }
}