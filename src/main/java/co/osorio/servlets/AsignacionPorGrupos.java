package co.osorio.servlets; 

import co.osorio.modelo.Asignacionesasignaturas;
import co.osorio.modelo.Asignatura;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import co.osorio.operaciones.OperacionesAsignacionesAsignaturas;
import co.osorio.operaciones.OperacionesAsignatura;
import co.osorio.operaciones.OperacionesCurso;
import co.osorio.operaciones.OperacionesDocente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsignacionPorGrupos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        Gson json = new Gson();
        String codigo = request.getParameter("codigo");

        // Obtenemos todos las asignaciones que tiene dicho grupo 
        // Obtenemos todos las asignaciones que tiene dicho grupo 
        // Creamos un objeto de tipo operaciones cursos 
        OperacionesCurso operacionescursos = new OperacionesCurso();
        // Obtenemos el docente a guardar
        OperacionesDocente operacionesdocente = new OperacionesDocente();

        // Creamos un objeto de operaciones asignaturas 
        OperacionesAsignatura operacionesasignatura = new OperacionesAsignatura();

        // Creamos un objeto de operaciones AsignacionesAsignaturas
        OperacionesAsignacionesAsignaturas operacionesasignaciones = new OperacionesAsignacionesAsignaturas();

        Asignacionesasignaturas Asignaciones = null;

        try {

            int value = Integer.parseInt(request.getParameter("value"));

            switch (value) {
                case 0:
                    String dato = request.getParameter("dato");

                    Curso curso = operacionescursos.Buscar(Integer.parseInt(dato));
                    List<AsignacionDTO> ListaDTO = new ArrayList<>();

                    for (Asignacionesasignaturas Asigna : curso.getAsignacionesasignaturasList()) {
                        AsignacionDTO asignaDTO = new AsignacionDTO();
                        asignaDTO.setId(Asigna.getIdRegistro());
                        asignaDTO.setAsignatura(Asigna.getAsignatura().getNombreAsignatura());
                        asignaDTO.setDocente(Asigna.getDocente().getCodigoDocente());
                        asignaDTO.setPonderacion(Asigna.getPonderacion());
                        asignaDTO.setHorasSemanales(Asigna.getHorasSemanales());
                        asignaDTO.setCodigodocente(Asigna.getDocente().getCodigoDocente());
                        ListaDTO.add(asignaDTO);
                    }

                    out.print(json.toJson(ListaDTO));

                    break;
                case 1:
                    // Obtenemos el curso que nos mandan 
                    Curso cursoAGuardar = operacionescursos.Buscar(Integer.parseInt(request.getParameter("curso")));
                    // Obtenemos el docente que nos mandan 
                    Docente docenteAGuardar = operacionesdocente.Buscar( Integer.parseInt(request.getParameter("docente")) );
                                     
                    String asignaturas [] = request.getParameterValues("asignaturas[]");
                    
                    for(String materia : asignaturas)
                    {
                     
                    Asignacionesasignaturas asig = new Asignacionesasignaturas();

                    Asignatura asi = operacionesasignatura.Buscar(Integer.parseInt(materia));
                    asig.setAsignatura(asi);
                    asig.setCurso(cursoAGuardar);
                    asig.setDocente(docenteAGuardar);
                    asig.setFecha(new Date());
                    asig.setEstado(true);
                    asig.setHorasSemanales(Integer.parseInt(request.getParameter("horasSem")));
                    asig.setPonderacion(Integer.parseInt(request.getParameter("ponderacion")));
                    operacionesasignaciones.registrar(asig);
                    
                    }
                    
                    out.print(json.toJson("¡Guardado exitosamente!"));
                    break;
                case 2:
                    
                    break;
            }

        } catch (Exception e) {
            out.print(json.toJson("Error"));
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
