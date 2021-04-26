package co.osorio.operaciones;

import co.osorio.DAOs.AsignaturaDAO;
import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.Asignatura;
import java.util.List;
import co.osorio.operaciones.Conexion;
import java.util.ArrayList;

public class OperacionesAsignatura implements AsignaturaDAO {

    Conexion conectando = null;

    public OperacionesAsignatura() {
        conectando = new Conexion();
    }

    @Override
    public void registrar(Asignatura ob) throws Exception {
    }

    @Override
    public void modificar(Asignatura ob) throws Exception {
    }

    @Override
    public void eliminar(Asignatura ob) throws Exception {
    }

    @Override
    public List<Asignatura> listarTodos() throws Exception {

        String jpql = "select p from Asignatura p";
        return conectando.getEm().createQuery(jpql).getResultList();

    }

    @Override
    public Asignatura Buscar(Integer dato) throws Exception {
        return conectando.getEm().find(Asignatura.class, dato); 
    }
    
    
    public static void main(String[] args) throws Exception {
        
        OperacionesAsignatura op = new OperacionesAsignatura(); 
        Asignatura as = op.Buscar(2);
        System.out.println( as.getNombreAsignatura() );
    }

}
