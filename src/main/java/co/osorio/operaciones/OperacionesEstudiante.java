package co.osorio.operaciones;

import co.osorio.DAOs.EstudianteDAO;
import co.osorio.modelo.Estudiante;
import co.osorio.modelo.Nota;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String args[]) {
        try {

            OperacionesEstudiante operaciones = new OperacionesEstudiante();
             List<Estudiante> lista = operaciones.ListarActivos();
            
            for (Estudiante estudiante : lista) {
                
                System.out.println( estudiante.getPrimerNombre() );
                
                
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
