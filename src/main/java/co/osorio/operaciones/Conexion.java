package co.osorio.operaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private EntityManagerFactory emf=null;
    private EntityManager em=null;

    public Conexion() {
        emf = Persistence.createEntityManagerFactory("prueba");
        em = emf.createEntityManager();
        System.out.println("conectado!, bien. ");
    }
 
    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    
    public static void main(String args[])
    {
        Conexion conexion = new Conexion(); 
        
        
    }

}
