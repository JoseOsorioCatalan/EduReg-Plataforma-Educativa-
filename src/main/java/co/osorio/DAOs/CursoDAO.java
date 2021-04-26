
package co.osorio.DAOs;

import co.osorio.modelo.Curso;
import java.util.List;


public interface CursoDAO extends DAO<Curso,Integer>{
    
   public Curso BuscarPorCurso(String cursoABuscar);
    
    
}
