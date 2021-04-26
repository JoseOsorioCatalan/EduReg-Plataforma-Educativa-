package co.osorio.servlets;
import co.osorio.modelo.Docente ;
import java.io.Serializable;


public class CalendarDTO implements Serializable {
    
    private int id;
    private String title;
    private String descripcion;
    private String color;
    private String textcolor;
    private String start;
    private String fin;
    private Docente admin; 


  
    public Docente getAdmin() {
        return admin;
    }

    public void setAdmin(Docente admin) {
        this.admin = admin;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textcolor;
    }

    public void setTextColor(String textcolor) {
        this.textcolor = textcolor;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String end) {
        this.fin = end;
    }


    


    
}
