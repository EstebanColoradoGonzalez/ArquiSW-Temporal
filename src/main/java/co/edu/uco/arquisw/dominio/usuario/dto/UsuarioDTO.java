package co.edu.uco.arquisw.dominio.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO
{
    private Long id;
    private String correo;
    private String clave;
    private List<RolDTO> roles;
}