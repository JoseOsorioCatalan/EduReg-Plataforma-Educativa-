package co.osorio.operaciones;

import co.osorio.controlador.DataStudents;
import co.osorio.DAOs.AsignacionesDAO;
import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Nota;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.Query;

public class OperacionesAsignacionesAsignaturas implements AsignacionesDAO {

    Conexion conectando;

    public OperacionesAsignacionesAsignaturas() {
        conectando = new Conexion();
    }

    @Override
    public void registrar(Asignacionesasignaturas ob) throws Exception {
        try {
            conectando.getEm().getTransaction().begin();

            if (!conectando.getEm().contains(ob)) {
                ob = conectando.getEm().merge(ob);
            }

            conectando.getEm().persist(ob);
            conectando.getEm().getTransaction().commit();

        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }

    }

    @Override
    public void modificar(Asignacionesasignaturas ob) throws Exception {
    }

    @Override
    public void eliminar(Asignacionesasignaturas ob) throws Exception {
    }

    @Override
    public List<Asignacionesasignaturas> listarTodos() throws Exception {
        return null;
    }

    @Override
    public Asignacionesasignaturas Buscar(Integer dato) throws Exception {
        return null;
    }

   
    public static void main(String[] args) throws Exception {

        /* 
        OperacionesAsignacionesAsignaturas op = new OperacionesAsignacionesAsignaturas();
        Asignacionesasignaturas asig = new Asignacionesasignaturas();
        OperacionesCurso operacionescursos = new OperacionesCurso();
        // Obtenemos el docente a guardar
        OperacionesDocente operacionesdocente = new OperacionesDocente();

        // Creamos un objeto de operaciones asignaturas 
        OperacionesAsignatura operacionesasignatura = new OperacionesAsignatura();

        Docente doc = operacionesdocente.Buscar(9);
        Curso cur = operacionescursos.Buscar(1);
        Asignatura asi = operacionesasignatura.Buscar(1);
        asig.setAsignatura(asi);
        asig.setCurso(cur);
        asig.setDocente(doc);
        asig.setFecha(new Date());
        op.registrar(asig);
         */
      

    }

}
