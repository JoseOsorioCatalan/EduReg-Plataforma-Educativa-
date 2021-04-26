package co.osorio.controlador;

import co.osorio.modelo.Curso;
import co.osorio.modelo.Estudiante;
import co.osorio.operaciones.OperacionesCurso;
import co.osorio.operaciones.OperacionesEstudiante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEstudiante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String opcion = request.getParameter("id");

        OperacionesEstudiante operacionesEstudiante = new OperacionesEstudiante();
        OperacionesCurso operacionesCurso = new OperacionesCurso();
    

        switch (opcion) {
            case "registrar":

                try {

                    Estudiante estudiante = new Estudiante();
                    estudiante.setIdEstudiante(Integer.parseInt(request.getParameter("numdocumento")));
                    estudiante.setPrimerNombre(request.getParameter("PrimerNombre"));
                    estudiante.setSegundoNombre(request.getParameter("SegundoNombre"));
                    estudiante.setPrimerApellido(request.getParameter("PrimerApellido"));
                    estudiante.setSegundoApellido(request.getParameter("SegundoApellido"));
                    estudiante.setFechaDeNacimiento(request.getParameter("fecha-nac"));
                    estudiante.setDepartamentoActual(request.getParameter("departamentoactual"));
                    estudiante.setAcudiente(request.getParameter("acudiente"));
                    estudiante.setAnoVigente(request.getParameter("AñoIngreso"));
                    estudiante.setGenero(request.getParameter("genero"));
                    estudiante.setBarrio(request.getParameter("Barrio"));
                    estudiante.setSede(request.getParameter("sede"));
                    estudiante.setTipoDocumento(request.getParameter("tipodocumento"));
                    estudiante.setTelefono(request.getParameter("telefono"));
                    estudiante.setSitioPoblacional(request.getParameter("sitioPoblacional"));
                    estudiante.setMunicipioNacimiento(request.getParameter("mun-nacimiento"));
                    estudiante.setMunicipioActual(request.getParameter("municipio-actual"));
                    estudiante.setDepartamentoNacimiento(request.getParameter("depnacimiento"));
                    estudiante.setDireccion(request.getParameter("direccion"));
                    estudiante.setNuevo(request.getParameter("nuevo"));
                    estudiante.setPagarMatricula(request.getParameter("PagarMatricula"));
                    estudiante.setEstado(true);

                    String CursoString = request.getParameter("Curso").trim();

                    Curso curso = operacionesCurso.Buscar(Integer.parseInt(CursoString));
                    estudiante.setCursoAsignado(curso);
                    
                  
              
                    operacionesEstudiante.registrar(estudiante);

                    //  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    response.sendRedirect(request.getContextPath() + "/Estudiantes.jsp");

                } catch (Exception e) {
                   response.sendRedirect(request.getContextPath() + "/PageError.jsp");
                }

                break;

            case "editar":

                try {

                    Estudiante EstudianteAEditar = operacionesEstudiante.Buscar(Integer.parseInt(request.getParameter("codigo")));
                    EstudianteAEditar.setIdEstudiante(Integer.parseInt(request.getParameter("numdocumento")));
                    EstudianteAEditar.setPrimerNombre(request.getParameter("PrimerNombre"));
                    EstudianteAEditar.setSegundoNombre(request.getParameter("SegundoNombre"));
                    EstudianteAEditar.setPrimerApellido(request.getParameter("PrimerApellido"));
                    EstudianteAEditar.setSegundoApellido(request.getParameter("SegundoApellido"));
                    EstudianteAEditar.setFechaDeNacimiento(request.getParameter("fecha-nac"));
                    EstudianteAEditar.setDepartamentoActual(request.getParameter("departamentoactual"));
                    EstudianteAEditar.setAcudiente(request.getParameter("acudiente"));
                    EstudianteAEditar.setAnoVigente(request.getParameter("AñoIngreso"));
                    EstudianteAEditar.setGenero(request.getParameter("genero"));
                    EstudianteAEditar.setBarrio(request.getParameter("Barrio"));
                    EstudianteAEditar.setSede(request.getParameter("Sede"));
                    EstudianteAEditar.setTipoDocumento(request.getParameter("tipodocumento"));
                    EstudianteAEditar.setTelefono(request.getParameter("Telefono"));
                    EstudianteAEditar.setSitioPoblacional(request.getParameter("SitioPoblacional"));
                    EstudianteAEditar.setMunicipioNacimiento(request.getParameter("mun-nacimiento"));
                    EstudianteAEditar.setMunicipioActual(request.getParameter("municipio-actual"));
                    EstudianteAEditar.setDepartamentoNacimiento(request.getParameter("depnacimiento"));
                    EstudianteAEditar.setDireccion(request.getParameter("Direccion"));
                    EstudianteAEditar.setNuevo(request.getParameter("EstudianteNuevo"));
                    EstudianteAEditar.setPagarMatricula(request.getParameter("PagarMatricula"));
                    EstudianteAEditar.setEstado(true);

                    String CursoString = request.getParameter("Curso").trim();

                    Curso curso = operacionesCurso.Buscar(Integer.parseInt(CursoString));
                    EstudianteAEditar.setCursoAsignado(curso);
                    operacionesEstudiante.modificar(EstudianteAEditar);

         
                    response.sendRedirect(request.getContextPath() + "/Estudiantes.jsp");
                }
                catch(Exception e)
                {
                 out.print(e);
                }

                    break;

                
        
        case "eliminar":
            {
                
                 try {
                    Estudiante EstudianteAEliminar = operacionesEstudiante.Buscar(
                    Integer.parseInt(request.getParameter("codigo")));
                  
                   EstudianteAEliminar.setEstado(false);
                    operacionesEstudiante.eliminar(EstudianteAEliminar);
                    response.sendRedirect(request.getContextPath() + "/Estudiantes.jsp");
                } catch (Exception e) {
                  out.print(e.getMessage());
                }
               
            }
                
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
