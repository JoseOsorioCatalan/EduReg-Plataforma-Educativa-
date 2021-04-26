package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Docente;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Periodo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Observacion.class)
public class Observacion_ { 

    public static volatile SingularAttribute<Observacion, Estudiante> estudiante;
    public static volatile SingularAttribute<Observacion, Asignatura> asignatura;
    public static volatile SingularAttribute<Observacion, Docente> docente;
    public static volatile SingularAttribute<Observacion, Periodo> periodoAcademico;
    public static volatile SingularAttribute<Observacion, Integer> idObservacion;
    public static volatile SingularAttribute<Observacion, String> observacion;

}