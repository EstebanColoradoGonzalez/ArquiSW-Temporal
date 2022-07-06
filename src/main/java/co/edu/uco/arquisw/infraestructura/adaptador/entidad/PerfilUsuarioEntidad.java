package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "perfilusuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilUsuarioEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="perfilusuario_code_seq")
    @SequenceGenerator(name="perfilusuario_code_seq", sequenceName="perfilusuario_code_seq", allocationSize=1)
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "perfil")
    private PerfilEntidad perfil;
}