package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;
import java.util.List;

@Getter
public class Persona
{
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;
    private List<Rol> roles;

    private Persona(String nombre, String apellidos, String correo, String clave, List<Rol> roles)
    {
        setNombre(nombre);
        setApellidos(apellidos);
        setCorreo(correo);
        setClave(clave);
        setRoles(roles);
    }

    public static Persona crear(String nombre, String apellidos, String correo, String clave, List<Rol> roles)
    {
        return new Persona(nombre, apellidos, correo, clave, roles);
    }

    private void setNombre(String nombre)
    {
        if(ValidarTexto.cadenaEstaVacia(nombre))
        {
            throw new IllegalArgumentException(Mensajes.NOMBRE_NO_PUEDE_ESTAR_VACIO);
        }

        if(!ValidarTexto.cadenaAlfanumerica(nombre))
        {
            throw new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(nombre, 1, 50))
        {
            throw new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }

    public void setApellidos(String apellidos)
    {
        if(ValidarTexto.cadenaEstaVacia(apellidos))
        {
            throw new IllegalArgumentException("Los apellidos de una persona no pueden ser vacios");
        }

        if(!ValidarTexto.cadenaAlfanumerica(apellidos))
        {
            throw new IllegalArgumentException("Los apellidos solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(apellidos, 1, 50))
        {
            throw new IllegalArgumentException("La longitud de los apellidos debe estar entre 1 y 50 caracteres");
        }

        this.apellidos = apellidos;
    }

    private void setCorreo(String correo)
    {
        if(ValidarTexto.cadenaEstaVacia(correo))
        {
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }

        if(!ValidarTexto.cadenaCorreo(correo))
        {
            throw new IllegalArgumentException("el correo debe cumplir el patron de @example.com");
        }

        if(!ValidarTexto.longitudEsValida(correo, 10, 100))
        {
            throw new IllegalArgumentException("La longitud del correo debe estar entre 10 y 100 caracteres");
        }

        this.correo = correo;
    }

    public void setClave(String clave)
    {
        if(ValidarTexto.cadenaEstaVacia(clave))
        {
            throw new IllegalArgumentException("La clave no puede estar vacia");
        }

        if(!ValidarTexto.cadenaClave(clave))
        {
            throw new IllegalArgumentException("La clave debe cumplir el patron de @example.com");
        }

        if(!ValidarTexto.longitudEsValida(clave, 10, 100))
        {
            throw new IllegalArgumentException("La longitud de la clave debe estar entre 8 y 100 caracteres");
        }

        this.clave = clave;
    }

    private void setRoles(List<Rol> roles)
    {
        this.roles = roles;
    }
}