package co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando;

public interface UsuarioRepositorioComando
{
    Long guardar(String correo, String clave);
    Long actualizar(String correo, String clave, Long id);
    void eliminar(Long id);
}