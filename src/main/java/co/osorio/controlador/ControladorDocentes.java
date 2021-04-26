package co.osorio.controlador;

import co.osorio.operaciones.OperacionesDocente;
import co.osorio.modelo.Curso;
import co.osorio.modelo.Docente;
import co.osorio.operaciones.OperacionesCurso;
import co.osorio.operaciones.OperacionesTablaDocentes_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorDocentes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String opcion = request.getParameter("id");

        OperacionesDocente operaciones = new OperacionesDocente();
        OperacionesTablaDocentes_Curso operacionesTablaDocenteCurso = new OperacionesTablaDocentes_Curso();
        OperacionesCurso operacionesCurso = new OperacionesCurso();
    
        

        switch (opcion) {
            case "registrar":

                try {

                    Docente docente = new Docente();
                    docente.setIdDocente(Integer.parseInt(request.getParameter("numdocumento")));
                    docente.setTipoDocumento(request.getParameter("tipo_documento"));
                    docente.setGenero(request.getParameter("genero"));
                    docente.setFechaNacimiento(request.getParameter("fecha_nac"));
                    docente.setDepartamentoNacimiento(request.getParameter("departamento_nac"));
                    docente.setMunicipioNacimiento(request.getParameter("mun_nacimiento"));
                    docente.setPrimerApellido(request.getParameter("PrimerApellido"));
                    docente.setSegundoApellido(request.getParameter("SegundoApellido"));
                    docente.setPrimerNombre(request.getParameter("PrimerNombre"));
                    docente.setSegundoNombre(request.getParameter("SegundoNombre"));
                    docente.setDireccion(request.getParameter("Direccion"));
                    docente.setTelefono(request.getParameter("Telefono"));
                    docente.setDepartamentoActual(request.getParameter("dep_actual"));
                    docente.setMunicipioActual(request.getParameter("municipio_actual"));
                    docente.setBarrio(request.getParameter("Barrio"));
                    docente.setSitioPoblacional(request.getParameter("sitio_pob"));
                    docente.setSede(request.getParameter("sede"));
                    docente.setNuevo(request.getParameter("doc_nuevo"));
                    docente.setAnoVigente(request.getParameter("año"));
                    docente.setEmail("Correo");
                    docente.setEspecialidad(request.getParameter("Especialidad"));
                    docente.setContrasena(request.getParameter("Contra"));
                    docente.setUsuario(request.getParameter("Usuario"));
                    docente.setEstado(true);
                    docente.setRol("Docente");
                    operaciones.registrar(docente);

                    response.sendRedirect(request.getContextPath() + "/Docentes.jsp");

                } catch (Exception e) {
                    out.print(e.getMessage());
                }

                break;

            case "editar":

                Docente docente2 = operaciones.Buscar(Integer.parseInt(request.getParameter("codigo")));

                docente2.setIdDocente(Integer.parseInt(request.getParameter("numdocumento")));
                docente2.setTipoDocumento(request.getParameter("tipo_documento"));
                docente2.setGenero(request.getParameter("genero"));
                docente2.setFechaNacimiento(request.getParameter("fecha_nac"));
                docente2.setDepartamentoNacimiento(request.getParameter("departamento_nac"));
                docente2.setMunicipioNacimiento(request.getParameter("mun_nacimiento"));
                docente2.setPrimerApellido(request.getParameter("PrimerApellido"));
                docente2.setSegundoApellido(request.getParameter("SegundoApellido"));
                docente2.setPrimerNombre(request.getParameter("PrimerNombre"));
                docente2.setSegundoNombre(request.getParameter("SegundoNombre"));
                docente2.setDireccion(request.getParameter("Direccion"));
                docente2.setTelefono(request.getParameter("Telefono"));
                docente2.setDepartamentoActual(request.getParameter("dep_actual"));
                docente2.setMunicipioActual(request.getParameter("municipio_actual"));
                docente2.setBarrio(request.getParameter("Barrio"));
                docente2.setSitioPoblacional(request.getParameter("sitio_pob"));
                docente2.setSede(request.getParameter("sede"));
                docente2.setNuevo(request.getParameter("doc_nuevo"));
                docente2.setAnoVigente(request.getParameter("año"));
                docente2.setEspecialidad(request.getParameter("Especialidad"));
                docente2.setContrasena(request.getParameter("Contra"));
                // docente2.setEmail("Correo");
                docente2.setUsuario(request.getParameter("Usuario"));
                docente2.setEstado(true);

                operaciones.modificar(docente2);
                response.sendRedirect(request.getContextPath() + "/listarDocentes");

                break;

            case "eliminar": {
                try {
                    Docente docente3 = operaciones.Buscar(Integer.parseInt(request.getParameter("codigo")));
                    docente3.setEstado(false);
                    operaciones.eliminar(docente3);
                    operaciones.QuitarCursosAlDocente(docente3.getCodigoDocente());
                    response.sendRedirect(request.getContextPath() + "/listarDocentes");
                } catch (Exception e) {
                    out.print("Error");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladorDocentes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladorDocentes.class.getName()).log(Level.SEVERE, null, ex);
        }
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

/*
 
       
 */
 /*
          OperacionesDocente docente=new OperacionesDocente();
         Docentes docentenuevo=new Docentes();
         
         
             
        docentenuevo.setIdDocente(Integer.parseInt(request.getParameter("numdocumento")));
        docentenuevo.setTipoDocumento(request.getParameter("tipo_documento"));
        docentenuevo.setGenero(request.getParameter("genero"));
        docentenuevo.setFechaNacimiento(new Date());
        docentenuevo.setDepartamentoNacimiento(request.getParameter("departamento_nac"));
        docentenuevo.setMunicipioNacimiento(request.getParameter("mun_nacimiento")); 
        docentenuevo.setPrimerApellido(request.getParameter("PrimerApellido"));
        docentenuevo.setSegundoApellido(request.getParameter("SegundoApellido"));
        docentenuevo.setPrimerNombre(request.getParameter("PrimerNombre"));
        docentenuevo.setSegundoNombre(request.getParameter("SegundoNombre"));
        docentenuevo.setDireccion(request.getParameter("Direccion"));
        docentenuevo.setTelefono(request.getParameter("Telefono"));
        docentenuevo.setDepartamenoActual(request.getParameter("dep_actual"));
        docentenuevo.setMunicipioActual(request.getParameter("municipio_actual"));
        docentenuevo.setBarrio(request.getParameter("Barrio"));
        docentenuevo.setSitioPoblacional(request.getParameter("sitio_pob"));
        docentenuevo.setSede(request.getParameter("sede"));
        docentenuevo.setNuevo(request.);
        docentenuevo.setAño(new Date());
            Cursos curso = new Cursos();

        
            curso.setIdCurso(1);
            docentenuevo.setIdCursoAsignado(curso);
            

        docentenuevo.setEspecialidad("hd");
        docentenuevo.setContraseña("j");
        docentenuevo.setUsuario("d");
        docentenuevo.setEstado("kl");
        try {
            docente.registrar(docentenuevo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
 */
