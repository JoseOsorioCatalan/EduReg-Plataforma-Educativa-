
package co.osorio.controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;


class MiObjeto {
      private  String nombre;
      private   String origen;
      private  String miCadena;
      private  Collection miColeccion = new ArrayList();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getMiCadena() {
        return miCadena;
    }

    public void setMiCadena(String miCadena) {
        this.miCadena = miCadena;
    }

    public Collection getMiColeccion() {
        return miColeccion;
    }

    public void setMiColeccion(Collection miColeccion) {
        this.miColeccion = miColeccion;
    }
   
      
     public void GuardarDatosEnLista(String dato)
     {
         miColeccion.add(dato);
     }
        
        
    }
