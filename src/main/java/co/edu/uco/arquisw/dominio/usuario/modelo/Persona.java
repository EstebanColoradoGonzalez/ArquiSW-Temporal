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
    private List<Rol> roles;

    private Persona(String nombre, String apellidos, List<Rol> roles)
    {
        setNombre(nombre);
        setRoles(roles);
    }

    public static Persona crear(String nombre, String apellidos, List<Rol> roles)
    {
        return new Persona(nombre, apellidos, roles);
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

    private void setRoles(List<Rol> roles)
    {
        this.roles = roles;
    }
}