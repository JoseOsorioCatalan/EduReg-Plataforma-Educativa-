
package co.osorio.DAOs;

import java.util.List;

public interface DAO<T,K>  {
    
      
 public void registrar(T ob) throws Exception;
 public void modificar(T ob) throws Exception;
 public void eliminar(T ob) throws Exception;    
 public List<T> listarTodos() throws Exception;
 public T Buscar(K dato) throws Exception;
 
    
    
}
