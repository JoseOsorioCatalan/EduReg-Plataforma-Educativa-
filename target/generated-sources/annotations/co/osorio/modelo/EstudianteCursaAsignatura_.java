package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(EstudianteCursaAsignatura.class)
public class EstudianteCursaAsignatura_ { 

    public static volatile SingularAttribute<EstudianteCursaAsignatura, Estudiante> estudiante;
    public static volatile SingularAttribute<EstudianteCursaAsignatura, Boolean> estado;
    public static volatile SingularAttribute<EstudianteCursaAsignatura, Asignatura> asignatura;
    public static volatile SingularAttribute<EstudianteCursaAsignatura, Integer> idRegistro;

}