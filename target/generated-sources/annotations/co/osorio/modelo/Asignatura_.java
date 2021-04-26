package co.osorio.modelo;

import co.osorio.modelo.Area;
import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.EstudianteCursaAsignatura;
import co.osorio.modelo.Logro;
import co.osorio.modelo.Nota;
import co.osorio.modelo.Observacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Asignatura.class)
public class Asignatura_ { 

    public static volatile SingularAttribute<Asignatura, Area> area;
    public static volatile ListAttribute<Asignatura, Observacion> observacionList;
    public static volatile ListAttribute<Asignatura, Asignacionesasignaturas> asignacionesasignaturasList;
    public static volatile ListAttribute<Asignatura, Logro> logroList;
    public static volatile SingularAttribute<Asignatura, Integer> idAsignatura;
    public static volatile ListAttribute<Asignatura, EstudianteCursaAsignatura> estudianteCursaAsignaturaList;
    public static volatile SingularAttribute<Asignatura, String> nombreAsignatura;
    public static volatile ListAttribute<Asignatura, Nota> notaList;

}