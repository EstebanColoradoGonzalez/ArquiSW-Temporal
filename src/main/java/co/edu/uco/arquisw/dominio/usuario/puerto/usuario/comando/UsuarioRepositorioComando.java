package co.edu.uco.arquisw.dominio.usuario.puerto.usuario.comando;

public interface UsuarioRepositorioComando
{
    void guardar(String correo, String clave);
    void actualizar(String correo, String clave, Long id);
    void eliminar(Long id);
    boolean existeCorreo(String correo);

}