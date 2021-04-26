package co.osorio.modelo;

import co.osorio.modelo.Docente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> descripcion;
    public static volatile SingularAttribute<Eventos, String> color;
    public static volatile SingularAttribute<Eventos, Docente> docenteAdministradorResponsable;
    public static volatile SingularAttribute<Eventos, Date> start;
    public static volatile SingularAttribute<Eventos, Date> end;
    public static volatile SingularAttribute<Eventos, Integer> id;
    public static volatile SingularAttribute<Eventos, String> title;
    public static volatile SingularAttribute<Eventos, String> textColor;

}