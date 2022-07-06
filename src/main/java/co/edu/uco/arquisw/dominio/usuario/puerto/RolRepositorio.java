package co.edu.uco.arquisw.dominio.usuario.puerto;

import co.edu.uco.arquisw.dominio.usuario.modelo.Rol;

public interface RolRepositorio
{
    Rol consultarPorCodigo(int codigo);
    void guardar(Rol rol);
    void actualizar(int codigo, Rol rol);
    void eliminar(int codigo);
    boolean existe(Rol rol);
}
