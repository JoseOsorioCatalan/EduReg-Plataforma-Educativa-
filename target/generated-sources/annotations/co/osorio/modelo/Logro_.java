package co.osorio.modelo;

import co.osorio.modelo.Asignatura;
import co.osorio.modelo.CursoTieneLogro;
import co.osorio.modelo.Periodo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Logro.class)
public class Logro_ { 

    public static volatile ListAttribute<Logro, CursoTieneLogro> cursoTieneLogroList;
    public static volatile SingularAttribute<Logro, Asignatura> asignatura;
    public static volatile SingularAttribute<Logro, Integer> idLogro;
    public static volatile SingularAttribute<Logro, String> logro;
    public static volatile SingularAttribute<Logro, Periodo> periodo;

}