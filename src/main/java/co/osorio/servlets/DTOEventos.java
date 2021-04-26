
package co.osorio.servlets;

public class DTOEventos {
    
    
    private String titulo;
    private String descripcion;
    private String start; 

    public DTOEventos(String titulo, String descripcion, String start) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.start = start;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    
    
    
    
}
