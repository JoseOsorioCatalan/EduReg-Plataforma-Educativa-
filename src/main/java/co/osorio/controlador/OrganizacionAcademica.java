package co.osorio.controlador;

import co.osorio.operaciones.OperacionesAsignacionesAsignaturas;
import co.osorio.operaciones.OperacionesEstudiante;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrganizacionAcademica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
      PrintWriter out = response.getWriter();
        try {

      
            Gson json = new Gson();

            // Obtengo el id del curso
            String curso = request.getParameter("idCurso");
            String Asignatura = request.getParameter("idAsignatura");
            int docente = 1;
            OperacionesEstudiante  op = new OperacionesEstudiante();
            List<DataStudents> lista = op.BuscarPorCursoYAsignatura(Integer.parseInt(Asignatura), Integer.parseInt(curso), 1,1);

            out.write(new Gson().toJson(lista));

        } catch (Exception e) {
            
                out.write(new Gson().toJson("ERROR"));
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
