package co.osorio.controlador;

import java.util.ArrayList;
import java.util.List;

class ObjetoAMostrar {

    private long Id;
    private String nombreCurso;
    private String nombreDocente;
    private List<String> ListaObjetos= new ArrayList();

    public ObjetoAMostrar(long Id, String nombreCurso, String nombreDocente) {
        this.Id = Id;
        this.nombreCurso = nombreCurso;
        this.nombreDocente = nombreDocente;
    }


    
    public ObjetoAMostrar()
    {
        
    }
    

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
    
    
   public void AgregarALista(String dato)
   {
       ListaObjetos.add(dato);
   }
    

}
