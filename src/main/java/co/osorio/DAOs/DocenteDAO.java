
package co.osorio.DAOs;

import co.osorio.modelo.Docente;
import java.util.List;

public interface DocenteDAO extends DAO<Docente,Integer>{

 public List<Docente> ListarActivos() throws Exception;  
 

}
