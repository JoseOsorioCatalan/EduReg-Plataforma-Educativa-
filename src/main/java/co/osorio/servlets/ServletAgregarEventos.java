package co.osorio.servlets; 

import co.osorio.modelo.Docente ;
import co.osorio.modelo.Eventos;
import co.osorio.operaciones.OperacionesDocente;
import co.osorio.operaciones.OperacionesEventos;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAgregarEventos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
           PrintWriter out = response.getWriter();
           try {
               
     
        CalendarDTO calendario = new CalendarDTO();
        OperacionesEventos opeEventos = new OperacionesEventos();
        response.setCharacterEncoding("UTF-8");
        

     

            switch (Integer.parseInt(request.getParameter("dato"))) {
                
                case 0: 
                  try {

          // Hacemos una Lectura de los eventos que estén en bases de datos 
            List progs = new ArrayList();
            OperacionesEventos operacioneseventos = new OperacionesEventos();
            DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            List<Eventos> ListaEventos = operacioneseventos.listarTodos();

            for (Eventos evento : ListaEventos) {
                
                CalendarDTO ob = new CalendarDTO();
                ob.setId( evento.getId()  );
                ob.setTitle( evento.getTitle() );
                ob.setDescripcion( evento.getDescripcion()  );
                ob.setColor( evento.getColor() );
                ob.setTextColor( evento.getTextColor() );
              
                
                ob.setStart( String.valueOf( formatoFecha.format(evento.getStart())) );
      
            ob.setFin( String.valueOf(formatoFecha.format(evento.getEnd())) );

                progs.add(ob);

            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
           
            out.write(new Gson().toJson(progs));

        } catch (Exception e) {
            out.write("Error");
        }
                
                break;
                
                
                case 1:

                    // Agregar eventos 
                    calendario.setTitle(request.getParameter("title"));
                    calendario.setDescripcion(request.getParameter("descripcion"));
                    calendario.setColor(request.getParameter("color"));
                    calendario.setTextColor(request.getParameter("textColor"));
                    calendario.setStart(request.getParameter("start"));
                    calendario.setFin(request.getParameter("end"));
                    OperacionesDocente  OperacionesAdmin = new OperacionesDocente();
                    Docente docente = OperacionesAdmin.Buscar(1); 

                    Eventos EventoAGuardar = new Eventos();
                   
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy/HH:mm");

                    // Empezamos a llenar el evento 
                    
                    
                    EventoAGuardar.setTitle(calendario.getTitle());
                    EventoAGuardar.setStart(formatoFecha.parse( calendario.getStart()  ));
                    EventoAGuardar.setEnd(formatoFecha.parse( calendario.getFin() ));
                    EventoAGuardar.setDescripcion(calendario.getDescripcion());
                    EventoAGuardar.setColor(calendario.getColor());
                    EventoAGuardar.setTextColor(calendario.getTextColor());
                    
                    EventoAGuardar.setDocenteAdministradorResponsable(docente);
                    
                    

                    opeEventos.registrar(EventoAGuardar);
                    out.write("evento guardado" + request.getParameter("end"));

                    break;
                case 2:

                    // Eliminar Eventos
                    calendario.setId(Integer.parseInt(request.getParameter("id")));
                    Eventos EventoAEliminar =  opeEventos.Buscar(calendario.getId());
                    opeEventos.eliminar(EventoAEliminar);
                    out.write("¡evento borrado exitosamente!");
                    

                    break;
                case 3:

                    // Actualizar Eventos. 
                    
               calendario.setId(Integer.parseInt(request.getParameter("id")));
               calendario.setTitle(request.getParameter("title"));
               DateFormat formatoFechaActualizar = new SimpleDateFormat("dd/MM/yyyy/HH:mm");
               calendario.setStart(request.getParameter("start"));
               calendario.setFin(request.getParameter("end"));
               calendario.setColor(request.getParameter("color"));
               calendario.setTextColor(request.getParameter("textColor"));
               calendario.setDescripcion(request.getParameter("descripcion"));
               
               
               
              // Agregamos los adtos recolectados 
              Eventos EventoAActualizar = opeEventos.Buscar(calendario.getId());
              
              EventoAActualizar.setTitle(calendario.getTitle());
              EventoAActualizar.setStart(formatoFechaActualizar.parse(calendario.getStart()));
              EventoAActualizar.setEnd(formatoFechaActualizar.parse(calendario.getFin()));
              EventoAActualizar.setColor(calendario.getColor());
              EventoAActualizar.setTextColor(calendario.getColor());
              EventoAActualizar.setDescripcion(calendario.getDescripcion());
              
              opeEventos.modificar(EventoAActualizar);
               

               out.write( "" + EventoAActualizar.getStart());

                    break;
                    
                    
                case 4: 
                    
                    // Hacemos una Lectura de los eventos que estén en bases de datos 
            List progs = new ArrayList();
            OperacionesEventos operacioneseventos = new OperacionesEventos();
            DateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            List<Eventos> ListaEventos = operacioneseventos.ListarTresPrimerosEventos(); 

            for (Eventos evento : ListaEventos) {
                
                CalendarDTO ob = new CalendarDTO();
                ob.setTitle( evento.getTitle() );       
                ob.setDescripcion( evento.getDescripcion() );
                ob.setStart( String.valueOf( formato.format(evento.getStart())) );
      
                
                progs.add(ob);

            }

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
           
            out.write(new Gson().toJson(progs));
                    
                    
                    
                    break; 
                    
                    
             default:
                 out.write("Error");
                 break;
            }

        } catch (Exception e) {
            out.write("Error");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
