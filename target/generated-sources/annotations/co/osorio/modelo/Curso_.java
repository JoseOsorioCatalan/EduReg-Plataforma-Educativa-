package co.osorio.modelo;

import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.CursoTieneLogro;
import co.osorio.modelo.DocenteDirectorGrupo;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Grado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile ListAttribute<Curso, CursoTieneLogro> cursoTieneLogroList;
    public static volatile SingularAttribute<Curso, Grado> grado;
    public static volatile ListAttribute<Curso, Asignacionesasignaturas> asignacionesasignaturasList;
    public static volatile SingularAttribute<Curso, String> curso;
    public static volatile ListAttribute<Curso, Estudiante> estudianteList;
    public static volatile SingularAttribute<Curso, Integer> idCurso;
    public static volatile ListAttribute<Curso, DocenteDirectorGrupo> docenteDirectorGrupoList;

}