package co.osorio.modelo;

import co.osorio.modelo.Logro;
import co.osorio.modelo.Nota;
import co.osorio.modelo.Observacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile ListAttribute<Periodo, Observacion> observacionList;
    public static volatile SingularAttribute<Periodo, String> nombrePeriodo;
    public static volatile SingularAttribute<Periodo, String> estado;
    public static volatile ListAttribute<Periodo, Logro> logroList;
    public static volatile SingularAttribute<Periodo, Integer> idPeriodo;
    public static volatile ListAttribute<Periodo, Nota> notaList;

}