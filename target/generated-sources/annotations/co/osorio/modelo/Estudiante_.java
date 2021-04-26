package co.osorio.modelo;

import co.osorio.modelo.Curso;
import co.osorio.modelo.EstudianteCursaAsignatura;
import co.osorio.modelo.Nota;
import co.osorio.modelo.Observacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-26T00:11:24")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> segundoNombre;
    public static volatile SingularAttribute<Estudiante, Boolean> estado;
    public static volatile SingularAttribute<Estudiante, Curso> cursoAsignado;
    public static volatile SingularAttribute<Estudiante, String> segundoApellido;
    public static volatile SingularAttribute<Estudiante, String> pagarMatricula;
    public static volatile SingularAttribute<Estudiante, String> fechaDeNacimiento;
    public static volatile SingularAttribute<Estudiante, String> anoVigente;
    public static volatile SingularAttribute<Estudiante, String> genero;
    public static volatile SingularAttribute<Estudiante, Long> idEstudiante;
    public static volatile SingularAttribute<Estudiante, String> municipioNacimiento;
    public static volatile SingularAttribute<Estudiante, String> telefono;
    public static volatile ListAttribute<Estudiante, Observacion> observacionList;
    public static volatile SingularAttribute<Estudiante, String> barrio;
    public static volatile SingularAttribute<Estudiante, String> primerNombre;
    public static volatile SingularAttribute<Estudiante, String> primerApellido;
    public static volatile SingularAttribute<Estudiante, String> acudiente;
    public static volatile SingularAttribute<Estudiante, String> sede;
    public static volatile SingularAttribute<Estudiante, String> direccion;
    public static volatile SingularAttribute<Estudiante, String> departamentoActual;
    public static volatile ListAttribute<Estudiante, EstudianteCursaAsignatura> estudianteCursaAsignaturaList;
    public static volatile SingularAttribute<Estudiante, String> departamentoNacimiento;
    public static volatile SingularAttribute<Estudiante, String> municipioActual;
    public static volatile ListAttribute<Estudiante, Nota> notaList;
    public static volatile SingularAttribute<Estudiante, String> tipoDocumento;
    public static volatile SingularAttribute<Estudiante, String> nuevo;
    public static volatile SingularAttribute<Estudiante, String> sitioPoblacional;
    public static volatile SingularAttribute<Estudiante, Integer> codigoEstudiante;

}