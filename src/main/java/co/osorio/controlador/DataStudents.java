
package co.osorio.controlador;

public class DataStudents {
    

    private int CodigoEstudiante;
    private String PrimerNombre; 
    private String SegundoNombre;
    private String PrimerApellido; 
    private String SegundoApellido; 
    private int idNota; 
    private String Nota; 

    public DataStudents() {
    }

    public DataStudents(int Codigo, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String Nota, int idNota) {
        this.CodigoEstudiante = Codigo;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Nota = Nota; 
        this.idNota = idNota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getCodigoEstudiante() {
        return CodigoEstudiante;
    }

    public void setCodigoEstudiante(int Codigo) {
        this.CodigoEstudiante = Codigo;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }
    
    public void setNota(String Nota)
    {
        this.Nota = Nota;
    }        
    
    public String getNota()
    {
        return Nota; 
    }
            
    
    
    
    
    
    
}
