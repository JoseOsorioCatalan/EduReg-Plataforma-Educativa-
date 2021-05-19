
package co.osorio.DAOs;

import co.osorio.controlador.DataStudents;
import co.osorio.modelo.Estudiante;
import java.util.List;

public interface EstudianteDAO extends DAO<Estudiante,Integer>{
    
     public List<Estudiante> ListarActivos() throws Exception;  
     public List<DataStudents> BuscarPorCursoYAsignatura(int IdCurso,int IdAsignatura, int Codigo, int peiodo);
}
