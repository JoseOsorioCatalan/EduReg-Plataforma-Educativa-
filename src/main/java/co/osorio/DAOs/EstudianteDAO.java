
package co.osorio.DAOs;

import co.osorio.modelo.Estudiante;
import java.util.List;

public interface EstudianteDAO extends DAO<Estudiante,Integer>{
    
     public List<Estudiante> ListarActivos() throws Exception;  
     
}
