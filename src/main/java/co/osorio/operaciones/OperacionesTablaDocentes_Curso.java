package co.osorio.operaciones;

import co.osorio.modelo.Asignacionesasignaturas;
import java.util.List;
import co.osorio.DAOs.DAODocenteCurso;
import co.osorio.modelo.DocenteDirectorGrupo;
import javax.persistence.Query;

public class OperacionesTablaDocentes_Curso implements DAODocenteCurso {

    Conexion conectando = null;

    public OperacionesTablaDocentes_Curso() {
        conectando = new Conexion();
    }

    @Override
    public void registrar(DocenteDirectorGrupo ob) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().persist(ob);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }

    }

    @Override
    public void modificar( DocenteDirectorGrupo ob) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(ob);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    @Override
    public void eliminar( DocenteDirectorGrupo ob) throws Exception {
        try {

            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(ob);
            conectando.getEm().getTransaction().commit();
        } catch (Exception e) {
            conectando.getEm().getTransaction().rollback();
        }
    }

    @Override
    public List<DocenteDirectorGrupo> listarTodos() throws Exception {
        String SQL = null;
        SQL = "select c from DocenteDirectorGrupo c WHERE c.estado=1";
        return conectando.getEm().createQuery(SQL).getResultList();

    }

    @Override 
    public  DocenteDirectorGrupo Buscar(Integer dato) throws Exception {
        conectando = new Conexion();
        return conectando.getEm().find( DocenteDirectorGrupo.class, dato);
    }

    public DocenteDirectorGrupo BuscarPorDocente(int num) {
       DocenteDirectorGrupo cursoEncontrado = new DocenteDirectorGrupo();
        final String SQL;
        SQL = " SELECT p FROM Docente_Director_Grupo p JOIN p.idDocente m where m.codigoDocente= :num";
        Query query = conectando.getEm().createQuery(SQL);
        query.setParameter("num", num);
        try {
            cursoEncontrado = (DocenteDirectorGrupo) query.getSingleResult();
            return cursoEncontrado;
        } catch (Exception e) {
            return cursoEncontrado;
        }

    }

}
