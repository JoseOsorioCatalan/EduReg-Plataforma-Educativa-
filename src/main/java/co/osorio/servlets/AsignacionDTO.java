package co.osorio.servlets;

import java.io.Serializable;

public class AsignacionDTO implements Serializable{
    
    private int id; 
    private String asignatura; 
    private int  docente; 
    private double ponderacion; 
    private int HorasSemanales; 
    private int codigodocente; 

    public AsignacionDTO() {
    }

    public AsignacionDTO(int id, String asignatura, int docente, double ponderacion, int HorasSemanales, int codigodocente ) {
        this.id = id;
        this.asignatura = asignatura;
        this.docente = docente;
        this.ponderacion = ponderacion;
        this.HorasSemanales = HorasSemanales;
        this.codigodocente = codigodocente; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int  docente) {
        this.docente = docente;
    }

    public double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(double ponderacion) {
        this.ponderacion = ponderacion;
    }

    public int getHorasSemanales() {
        return HorasSemanales;
    }

    public void setHorasSemanales(int HorasSemanales) {
        this.HorasSemanales = HorasSemanales;
    }

    public int getCodigodocente() {
        return codigodocente;
    }

    public void setCodigodocente(int codigodocente) {
        this.codigodocente = codigodocente;
    }
    
    
    
    
    
    
    
    
}
