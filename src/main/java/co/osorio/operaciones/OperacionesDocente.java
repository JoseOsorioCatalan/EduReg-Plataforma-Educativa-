package co.osorio.operaciones;

import co.osorio.DAOs.DocenteDAO;
import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import co.osorio.modelo.DocenteDirectorGrupo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class OperacionesDocente implements DocenteDAO {

    Conexion conectando = null;

    public OperacionesDocente() {
        conectando = new Conexion();
    }

    @Override
    public void registrar(Docente doc) throws Exception {
        EntityTransaction ET = conectando.getEm().getTransaction();
        try {

            ET.begin();
            conectando.getEm().persist(doc);
            ET.commit();
        } catch (Exception e) {
            ET.rollback();
        }

    }

    @Override
    public void modificar(Docente doc) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(doc);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(Docente doc) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(doc);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    public boolean QuitarCursosAlDocente(int Dato) {
        try {
            Docente docente = Buscar(Dato);

            for (DocenteDirectorGrupo DocCur : docente.getDocenteDirectorGrupoList()) {

                DocCur.setEstado(false);
            }

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(docente);
            conectando.getEm().getTransaction().commit();
            return true;

        } catch (Exception e) {

            conectando.getEm().getTransaction().rollback();
        }

        return false;

    }

    public Docente DevuelveDocente() {
        final String SQL = "SELECT distinct * from docente inner join on Docente_Director_Grupo where docente.codigo_docente=1 and Docente_Director_Grupo.estado=1;";

        Query readQuery = conectando.getEm().createNativeQuery(SQL, Docente.class);

        return (Docente) readQuery.getSingleResult();

    }

    @Override
    public List<Docente> listarTodos() throws Exception {
        String SQL = "select p from Docente p";
        return conectando.getEm().createQuery(SQL).getResultList();
    }

    @Override
    public List<Docente> ListarActivos() throws Exception {
        //   

        String SQL = "select p from Docente p WHERE p.estado= 1";
        Query readQuery = conectando.getEm().createQuery(SQL);

        return readQuery.getResultList();

    }

    public List<Docente> ListarDocentesConCursos() {

        String SQL = "SELECT * FROM docente WHERE `codigo_docente` in (SELECT docente FROM Docente_Director_Grupo where  Docente_Director_Grupo.estado = true ) ";
        Query readQuery = conectando.getEm().createNativeQuery(SQL, Docente.class);

        return (List<Docente>) readQuery.getResultList();

    }

    @Override
    public Docente Buscar(Integer codigo) throws Exception {

        return conectando.getEm().find(Docente.class, codigo);
    }

    public static void main(String args[]) throws Exception {
        /*
        OperacionesDocente operaciones = new OperacionesDocente();
        OperacionesCurso OpCur = new OperacionesCurso();
        OperacionesTablaDocentes_Curso OpeDocCur = new OperacionesTablaDocentes_Curso();

// Esta es la lista que me manda el usuario 
        List<Integer> ListaDeIds = new ArrayList<>();
        ListaDeIds.add(662);
        ListaDeIds.add(3444);
        ListaDeIds.add(3445);

        Docente d = operaciones.Buscar(1);

        System.out.println("Hasta ahora tenemos: ");

        for (DocenteTieneCurso docc : d.getDocenteTieneCursoList()) {

            System.out.println("Id registro: " + docc.getIdRegistro() + " , Curso: "
                    + docc.getIdCursoAsignado().getCurso() + " , Y el Id del curso es: " + docc.getIdCursoAsignado().getIdCurso() + " , Docente: " + docc.getIdDocente().getPrimerNombre() + " " + docc.getIdDocente().getPrimerApellido());

        }

        System.out.println("");
        System.out.println("Vamos a averiguar si en la lista de cursos Del DOCENTE se encuentra algún curso de los que mandamos en la lista ...");
        System.out.println("Si no encontramos el curso pasariamos a establecerlo como INACTIVO (FALSO)");
        System.out.println("");

        for (DocenteTieneCurso docenteCur : d.getDocenteTieneCursoList()) {
            if (!(ListaDeIds.contains(docenteCur.getIdCursoAsignado().getIdCurso()))) {
                System.out.println("La lista NO contiene al curso: " + docenteCur.getIdCursoAsignado().getIdCurso());
                docenteCur.setEstado(false);
            } else {
                System.out.println("La lista Sí contiene al curso: " + docenteCur.getIdCursoAsignado().getIdCurso());
                ListaDeIds.removeIf(p -> p.equals(docenteCur.getIdCursoAsignado().getIdCurso()));
            }

        }

        System.out.println("");
        System.out.println("Se empieza a filtrar la Lista...");
        System.out.println("");

        ListaDeIds.stream().forEach(System.out::println);

        System.out.println("Vamos a agregar El registro que quedo filtrado...");

        for (Integer dato : ListaDeIds) {
            Curso curso = OpCur.Buscar(dato);
            DocenteTieneCurso DocCurso = new DocenteTieneCurso();

            DocCurso.setIdDocente(d);
            DocCurso.setIdCursoAsignado(curso);
            DocCurso.setFecha(new Date());
            DocCurso.setEstado(true);
            OpeDocCur.registrar(DocCurso);

        }

        operaciones.modificar(d);

    }
         */
        OperacionesDocente operaciones = new OperacionesDocente();
        Docente docente = operaciones.Buscar(1);
        List<Curso> cursos = new ArrayList<>();

        for (Asignacionesasignaturas AsignacionesDoc : docente.getAsignacionesasignaturasList()) {
            cursos.add(AsignacionesDoc.getCurso());
        }
        
        
        for (Curso curso : cursos) {
            System.out.println(curso.getCurso());
        }

    }
}
