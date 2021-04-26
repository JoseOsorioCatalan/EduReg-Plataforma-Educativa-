package co.osorio.modelo;

import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.DocenteDirectorGrupo;
import co.osorio.modelo.Eventos;
import co.osorio.modelo.Nota;
import co.osorio.modelo.Observacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, String> segundoNombre;
    public static volatile SingularAttribute<Docente, Boolean> estado;
    public static volatile ListAttribute<Docente, Asignacionesasignaturas> asignacionesasignaturasList;
    public static volatile SingularAttribute<Docente, String> fechaNacimiento;
    public static volatile SingularAttribute<Docente, String> segundoApellido;
    public static volatile SingularAttribute<Docente, Long> idDocente;
    public static volatile ListAttribute<Docente, DocenteDirectorGrupo> docenteDirectorGrupoList;
    public static volatile SingularAttribute<Docente, String> rol;
    public static volatile SingularAttribute<Docente, String> anoVigente;
    public static volatile SingularAttribute<Docente, String> genero;
    public static volatile SingularAttribute<Docente, String> municipioNacimiento;
    public static volatile SingularAttribute<Docente, String> contrasena;
    public static volatile SingularAttribute<Docente, String> telefono;
    public static volatile SingularAttribute<Docente, String> email;
    public static volatile ListAttribute<Docente, Observacion> observacionList;
    public static volatile SingularAttribute<Docente, String> barrio;
    public static volatile SingularAttribute<Docente, String> primerNombre;
    public static volatile SingularAttribute<Docente, String> primerApellido;
    public static volatile SingularAttribute<Docente, String> sede;
    public static volatile SingularAttribute<Docente, String> direccion;
    public static volatile SingularAttribute<Docente, String> departamentoActual;
    public static volatile SingularAttribute<Docente, String> departamentoNacimiento;
    public static volatile SingularAttribute<Docente, String> municipioActual;
    public static volatile SingularAttribute<Docente, String> especialidad;
    public static volatile ListAttribute<Docente, Nota> notaList;
    public static volatile SingularAttribute<Docente, String> tipoDocumento;
    public static volatile SingularAttribute<Docente, Integer> edadDocente;
    public static volatile SingularAttribute<Docente, String> nuevo;
    public static volatile SingularAttribute<Docente, String> sitioPoblacional;
    public static volatile ListAttribute<Docente, Eventos> eventosList;
    public static volatile SingularAttribute<Docente, String> usuario;
    public static volatile SingularAttribute<Docente, Integer> codigoDocente;

}