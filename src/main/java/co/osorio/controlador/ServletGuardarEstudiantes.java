package co.osorio.controlador;

import co.osorio.modelo.Curso;
import  co.osorio.modelo.Docente;
import  co.osorio.modelo.Estudiante;
import  co.osorio.operaciones.OperacionesCurso;
import co.osorio.operaciones.OperacionesEstudiante;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletGuardarEstudiantes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        Gson json = new Gson();

        String dato = request.getParameter("Dato");

        if (dato.equals("Leer")) {
            try {

                OperacionesCurso Ope_Cursos = new OperacionesCurso();
                List<Curso> ListaCursos = Ope_Cursos.listarTodos();

                Map<Integer, String> Cursos = new HashMap();

                for (Curso Elemento : ListaCursos) {
                    Cursos.put(Elemento.getIdCurso(), Elemento.getCurso());
                }

                out.write(json.toJson(Cursos));

            } catch (Exception e) {
                out.write(json.toJson("Error"));
            }

        } else {
            OperacionesEstudiante operacionesEstudiante = new OperacionesEstudiante();
      

            Estudiante estudiante;

            String ArregloIdentificacion[] = request.getParameterValues("identificacion[]");
            String ArregloPrimerApellido[] = request.getParameterValues("primerApellido[]");
            String ArregloSegundoApellido[] = request.getParameterValues("segundoApellido[]");
            String ArregloPrimerNombre[] = request.getParameterValues("primerNombre[]");
            String ArregloSegundoNombre[] = request.getParameterValues("segundoNombre[]");
            String ArregloCursos[] = request.getParameterValues("Curso[]");

            OperacionesCurso opCurso = new OperacionesCurso();

            Curso curso = null;

            for (int i = 0; i < ArregloIdentificacion.length; i++) {

                try {
                    curso = opCurso.Buscar(Integer.parseInt(ArregloCursos[i]));
                } catch (Exception e) {
                    out.write(json.toJson("Error"));
                }

                estudiante = new Estudiante();

                estudiante.setIdEstudiante(Long.parseLong(ArregloIdentificacion[i]));
                estudiante.setPrimerApellido(ArregloPrimerApellido[i]);
                estudiante.setPrimerNombre(ArregloPrimerNombre[i]);
                estudiante.setSegundoApellido(ArregloSegundoApellido[i]);
                estudiante.setSegundoNombre(ArregloSegundoNombre[i]);
                estudiante.setCursoAsignado(curso);
                estudiante.setEstado(true);
            

                
                // Los campos menos importantes se establecen como vacios
                
                estudiante.setFechaDeNacimiento("vacio");
                estudiante.setDepartamentoActual("vacio");
                estudiante.setAcudiente("vacio");
                estudiante.setAnoVigente("vacio");
                estudiante.setGenero("vacio");
                estudiante.setBarrio("vacio");
                estudiante.setSede("vacio");
                estudiante.setTipoDocumento("vacio");
                estudiante.setTelefono("vacio");
                estudiante.setSitioPoblacional("vacio");
                estudiante.setMunicipioNacimiento("vacio");
                estudiante.setMunicipioActual("vacio");
                estudiante.setDepartamentoNacimiento("vacio");
                estudiante.setDireccion("vacio");
                estudiante.setNuevo("vacio");
                estudiante.setPagarMatricula("vacio");

                try {
                    // Empezamos a guardar a los estudiantes 
                    operacionesEstudiante.registrar(estudiante);

                } catch (Exception e) {
                    out.write(json.toJson("Error"));
                    return;
                }

            }

            out.write(json.toJson("Todo fue guardado exitosamente"));
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
