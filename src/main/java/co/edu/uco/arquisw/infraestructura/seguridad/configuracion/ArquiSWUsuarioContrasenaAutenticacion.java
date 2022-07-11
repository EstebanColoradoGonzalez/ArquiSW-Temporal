package co.edu.uco.arquisw.infraestructura.seguridad.configuracion;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarUsuarioPorCorreoManejador;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.UsuarioDTO;
import co.edu.uco.arquisw.infraestructura.seguridad.entidad.UsuarioSeguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArquiSWUsuarioContrasenaAutenticacion implements AuthenticationProvider
{
    private final ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ArquiSWUsuarioContrasenaAutenticacion(ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador)
    {
        this.consultarUsuarioPorCorreoManejador = consultarUsuarioPorCorreoManejador;
    }

    @Override
    public Authentication authenticate(Authentication autenticacion) throws AuthenticationException
    {
        String correo = autenticacion.getName();
        String clave = autenticacion.getCredentials().toString();
        UsuarioDTO usuario = this.consultarUsuarioPorCorreoManejador.ejecutar(correo);

        if(usuario!=null)
        {
            if(passwordEncoder.matches(clave,usuario.getClave()))
            {
                UsuarioSeguridad usuarioSeguridad= new UsuarioSeguridad(usuario);
                return new UsernamePasswordAuthenticationToken(usuarioSeguridad,clave,getGrantedAuthorities(usuario.getRoles()));
            }
            else
            {
                throw new IllegalArgumentException(Mensajes.AUTENTICACION_NO_SATISFACTIORIA);
            }
        }
        else
        {
            throw new IllegalArgumentException(Mensajes.AUTENTICACION_NO_SATISFACTIORIA);
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<RolDTO> roles)
    {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        roles.forEach(perfil ->
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(perfil.getNombre()));
        });

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> autenticacion)
    {
        return autenticacion.equals(UsernamePasswordAuthenticationToken.class);
    }
}