package co.osorio.operaciones;

import co.osorio.DAOs.EstudianteDAO;
import co.osorio.controlador.DataStudents;
import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Nota;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class OperacionesEstudiante implements EstudianteDAO {

    Conexion conectando;

    public OperacionesEstudiante() {

        conectando = new Conexion();
    }

    @Override
    public List<Estudiante> ListarActivos() throws Exception {
        String SQL = "select p from Estudiante p WHERE p.estado=1";
        return conectando.getEm().createQuery(SQL).getResultList();
    }

    @Override
    public void registrar(Estudiante est) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();

            if (!conectando.getEm().contains(est)) {
                est = conectando.getEm().merge(est);
            }

            conectando.getEm().persist(est);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }

    }

    @Override
    public void modificar(Estudiante est) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(est);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Estudiante est) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(est);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    @Override
    public List<Estudiante> listarTodos() throws Exception {
        String SQL = "select p from Estudiante p ";
        return conectando.getEm().createQuery(SQL).getResultList();
    }

    @Override
    public Estudiante Buscar(Integer codigo) throws Exception {
        return conectando.getEm().find(Estudiante.class, codigo);
    }

    public List<Estudiante> getAllStudentsWithCurse(int curso) {
        String SQLCursos = "select * from Estudiante WHERE cursoAsignado=? and estado=1";
        Query readQuery = conectando.getEm().createNativeQuery(SQLCursos, Estudiante.class);
        readQuery.setParameter(1, curso);
        return (List<Estudiante>) readQuery.getResultList();
    }

    
     @Override
    public List<DataStudents> BuscarPorCursoYAsignatura(int Asignatura, int Curso, int Docente, int periodo) {

        // Consulta para obtener si el docente tiene agregada la asignatura 
        final String consulta = "select * from asignacionesasignaturas "
                + "where docente=? and curso =? and asignatura=?  ";

        //Ejecucion de consulta 
        Query readQuery = conectando.getEm().createNativeQuery(consulta, Asignacionesasignaturas.class);

        // Parametros 
        readQuery.setParameter(1, Docente);
        readQuery.setParameter(2, Curso);
        readQuery.setParameter(3, Asignatura);

        List<DataStudents> ListaDeEstudiantesFiltrada = new ArrayList<>();;

       
        //Preguntamos si el resultado que nos devuelve es vacio o tiene resultados mediante una lista
        if (!readQuery.getResultList().isEmpty()) {

            System.out.println("LA LISTA TIENE DATOS!");
            final String ConsultaNota = "select nota.id_nota, nota.Nota, nota.estudiante from nota "
                    + " inner join estudiante on nota.estudiante = estudiante.codigo_estudiante where"
                    + " nota.asignatura=? and estudiante.cursoAsignado=? and  nota.periodo=? ;";

            Query EjecutarConsulta = conectando.getEm().createNativeQuery(ConsultaNota, Nota.class);
            EjecutarConsulta.setParameter(1, Asignatura);
            EjecutarConsulta.setParameter(2, Curso);
            EjecutarConsulta.setParameter(3, periodo);

            List<Nota> ListaNotas = EjecutarConsulta.getResultList();

            //Evaluamos si las notas estan cargadas
            if (!ListaNotas.isEmpty()) {
                for (Nota notas : ListaNotas) {
                    DataStudents datos = new DataStudents();
                    datos.setCodigoEstudiante(notas.getEstudiante().getCodigoEstudiante());
                    datos.setPrimerApellido(notas.getEstudiante().getPrimerApellido());
                    datos.setSegundoApellido(notas.getEstudiante().getSegundoApellido());
                    datos.setPrimerNombre(notas.getEstudiante().getPrimerNombre());
                    datos.setSegundoNombre(notas.getEstudiante().getSegundoNombre());
                    datos.setIdNota(notas.getIdNota());
                    datos.setNota(notas.getNota());
                    ListaDeEstudiantesFiltrada.add(datos);
                }
            } else {

                OperacionesEstudiante op = new OperacionesEstudiante();
                List<Estudiante> estudiantes = op.getAllStudentsWithCurse(Curso);

                for (Estudiante estudiante : estudiantes) {
                    DataStudents objeto = new DataStudents();
                    objeto.setCodigoEstudiante(estudiante.getCodigoEstudiante());
                    objeto.setPrimerApellido(estudiante.getPrimerApellido());
                    objeto.setSegundoApellido(estudiante.getSegundoApellido());
                    objeto.setPrimerNombre(estudiante.getPrimerNombre());
                    objeto.setSegundoNombre(estudiante.getSegundoNombre());
                    List<String> lista = estudiante.devuelveNota(periodo, Asignatura);
                    objeto.setIdNota(Integer.parseInt(lista.get(0)));
                    objeto.setNota(lista.get(1));
                    System.out.println("El curso es: " + estudiante.getCursoAsignado().getIdCurso());
                    ListaDeEstudiantesFiltrada.add(objeto);
                }

            }

        }

        return ListaDeEstudiantesFiltrada;

    }

    
    
    
    
    public static void main(String args[]) {
       
        OperacionesEstudiante op = new OperacionesEstudiante();
        
        

        List<DataStudents> lista = op.BuscarPorCursoYAsignatura(2, 2, 1, 3);

        for (DataStudents dataStudents : lista) {
            System.out.println(dataStudents.getCodigoEstudiante() + ", con Nombres: " + dataStudents.getPrimerNombre()
                    + " " + dataStudents.getPrimerApellido() + " , su nota es: " + dataStudents.getNota() + " y el id de la nota es: "
                    + dataStudents.getIdNota());
        }

    }

}
