package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> area;
    public static volatile SingularAttribute<Area, String> abreviatura;
    public static volatile SingularAttribute<Area, Integer> idArea;
    public static volatile ListAttribute<Area, Asignatura> asignaturaList;

}