
package co.osorio.operaciones;

import co.osorio.DAOs.EventoDAO;
import co.osorio.modelo.Docente; 
import co.osorio.modelo.Eventos;
import co.osorio.servlets.CalendarDTO;
import co.osorio.servlets.DTOEventos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OperacionesEventos implements EventoDAO{
       
    
    Conexion conectando = null; 
    
    
    public OperacionesEventos()
    {
        conectando = new Conexion(); 
    }
 
    @Override
    public void registrar(Eventos evento) throws Exception {
       try
       {
        
       conectando.getEm().getTransaction().begin();
        conectando.getEm().persist(evento);
       conectando.getEm().getTransaction().commit();   
       }catch(Exception e)
       {
           conectando.getEm().getTransaction().rollback();
       }

    }

    @Override
    public void modificar(Eventos evento) throws Exception {
        try
        {
            conectando.getEm().getTransaction().begin();
            conectando.getEm().merge(evento); 
            conectando.getEm().getTransaction().commit();
        }catch(Exception e)
        {
            conectando.getEm().getTransaction().rollback();
        }
        
        
    }

    @Override
    public void eliminar(Eventos evento) throws Exception {
        
        try
        {
             conectando.getEm().getTransaction().begin();
            conectando.getEm().remove(evento);
             conectando.getEm().getTransaction().commit();
        }catch(Exception e)
        {
            conectando.getEm().getTransaction().rollback();
          //   e.printStackTrace();
        }
    
    }

    
    @Override
    public List<Eventos> listarTodos() throws Exception {
        String SQL=null;
      SQL="select p from Eventos p";
      return   conectando.getEm().createQuery(SQL).getResultList();
    }

    @Override
    public Eventos Buscar(Integer dato) throws Exception {
          
        return conectando.getEm().getReference( Eventos.class  , dato); 
   
    }  
    
    
    public List<Eventos> ListarTresPrimerosEventos()
    {
          DateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        // Inicializamos la variable asignandole una consulta SQL nativa 
        String SQL ="select eventos.id, eventos.title, eventos.descripcion, eventos.`start`  from eventos " +
"where eventos.`start`> ' " + formato.format( new Date() ) +  " ' order by  eventos.`start` asc Limit 3;"; 
        
       
        Query query = conectando.getEm().createNativeQuery(SQL, Eventos.class );
       return  (List<Eventos>) query.getResultList();
        //return conectando.getEm().createQuery(SQL).setMaxResults(3).getResultList() ;  
    }
 
    
    
    public static void main(String[] args) throws Exception {
     /*   OperacionesEventos op= new OperacionesEventos();
        List <Eventos> ListaEventos = op.listarTodos();
        
           DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        for (Eventos ListaEvento : ListaEventos) {
            System.out.println(ListaEvento.getEnd());
            System.out.println( formatoFecha.format(ListaEvento.getEnd()) );
                   
        }
        */
       OperacionesEventos opeEventos = new OperacionesEventos();
    
                    //Eventos EventoAEliminar =  opeEventos.Buscar(27);
                    //opeEventos.eliminar(EventoAEliminar);
                    
                    List<Eventos> ListaE = opeEventos.ListarTresPrimerosEventos(); 
                    
                    for(int i=0; i< ListaE.size() ; i++)
                    {
                        System.out.println( ListaE.get(i) );
                    }
                        
                       
     
    }
 
}
