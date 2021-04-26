package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Docente;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Periodo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Nota.class)
public class Nota_ { 

    public static volatile SingularAttribute<Nota, Estudiante> estudiante;
    public static volatile SingularAttribute<Nota, Date> fecha;
    public static volatile SingularAttribute<Nota, Asignatura> asignatura;
    public static volatile SingularAttribute<Nota, Periodo> periodo;
    public static volatile SingularAttribute<Nota, Docente> docente;
    public static volatile SingularAttribute<Nota, Integer> idNota;
    public static volatile SingularAttribute<Nota, String> nota;

}