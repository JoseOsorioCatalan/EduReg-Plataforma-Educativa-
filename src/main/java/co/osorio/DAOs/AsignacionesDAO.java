
package co.osorio.DAOs ;


import co.osorio.controlador.DataStudents;
import co.osorio.modelo.Asignacionesasignaturas;
import java.util.List; 


public interface AsignacionesDAO  extends DAO<Asignacionesasignaturas,Integer >{
    
    public List<DataStudents> BuscarPorCursoYAsignatura(int IdCurso,int IdAsignatura, int Codigo);
    
}
