package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;
import lombok.Getter;

@Getter
public class Rol
{
    private String nombre;

    private Rol(String nombre)
    {
        setNombre(nombre);
    }

    public static Rol crear(String nombre)
    {
        return new Rol(nombre);
    }

    private void setNombre(String nombre)
    {
        if(ValidarTexto.cadenaEstaVacia(nombre))
        {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if(!ValidarTexto.cadenaLetrasYEspacios(nombre))
        {
            throw new IllegalArgumentException("El nombre solo puede contener letras y numeros");
        }

        if(!ValidarTexto.longitudEsValida(nombre, 1, 50))
        {
            throw new IllegalArgumentException("La longitud del nombre debe estar entre 1 y 50 caracteres");
        }

        this.nombre = nombre;
    }
}
