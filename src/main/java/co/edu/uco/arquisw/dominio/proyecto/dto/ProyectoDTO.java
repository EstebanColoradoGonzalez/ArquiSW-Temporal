package co.edu.uco.arquisw.dominio.proyecto.dto;

import co.edu.uco.arquisw.dominio.proyecto.modelo.EstadoProyecto;
import co.edu.uco.arquisw.dominio.proyecto.modelo.TipoConsultoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO
{
    private String nombre;
    private String descripcion;
    private EstadoProyecto estado;
    private List<TipoConsultoria> tiposConsultoria;
}