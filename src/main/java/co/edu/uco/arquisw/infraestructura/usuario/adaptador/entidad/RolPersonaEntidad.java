package co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rolusuario")
public class RolPersonaEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rolusuario_code_seq")
    @SequenceGenerator(name="rolusuario_code_seq", sequenceName="rolusuario_code_seq", allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rol")
    private RolEntidad rol;
}