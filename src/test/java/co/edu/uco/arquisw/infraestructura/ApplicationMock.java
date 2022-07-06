package co.edu.uco.arquisw.infraestructura;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"co.uco.edu.arquisw"})
@EnableJpaRepositories(basePackages = "co.uco.edu.arquisw")
public class ApplicationMock
{

}