package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Asignacionesasignaturas.class)
public class Asignacionesasignaturas_ { 

    public static volatile SingularAttribute<Asignacionesasignaturas, Date> fecha;
    public static volatile SingularAttribute<Asignacionesasignaturas, Integer> ponderacion;
    public static volatile SingularAttribute<Asignacionesasignaturas, Boolean> estado;
    public static volatile SingularAttribute<Asignacionesasignaturas, Asignatura> asignatura;
    public static volatile SingularAttribute<Asignacionesasignaturas, Curso> curso;
    public static volatile SingularAttribute<Asignacionesasignaturas, Docente> docente;
    public static volatile SingularAttribute<Asignacionesasignaturas, Integer> horasSemanales;
    public static volatile SingularAttribute<Asignacionesasignaturas, Integer> idRegistro;

}