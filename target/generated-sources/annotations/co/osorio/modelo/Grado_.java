package co.osorio.modelo;

import co.osorio.modelo.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Grado.class)
public class Grado_ { 

    public static volatile SingularAttribute<Grado, Integer> idGrado;
    public static volatile SingularAttribute<Grado, String> nombreGrado;
    public static volatile ListAttribute<Grado, Curso> cursoList;

}