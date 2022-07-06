package co.edu.uco.arquisw.dominio.usuario.modelo;

import co.edu.uco.arquisw.dominio.transversal.validador.ValidarTexto;

public class Usuario
{
    private String correo;
    private String clave;

    public Usuario(String correo, String clave)
    {
        setCorreo(correo);
        setClave(clave);
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
}