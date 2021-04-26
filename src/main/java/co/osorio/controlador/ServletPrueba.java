package co.osorio.controlador;

import co.osorio.modelo.*;
import co.osorio.modelo.DocenteDirectorGrupo;
import co.osorio.operaciones.OperacionesCurso;
import co.osorio.operaciones.OperacionesDocente;
import co.osorio.operaciones.OperacionesTablaDocentes_Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPrueba extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        OperacionesTablaDocentes_Curso op = new OperacionesTablaDocentes_Curso();
        OperacionesDocente operacionesDocente = new OperacionesDocente();
        List<ObjetoAMostrar> lista = new ArrayList<>();

        try {

            int prueba = Integer.parseInt(request.getParameter("dato"));

            switch (prueba) {
                case 1:
                    // En este case se lee toda la data de la BD 
                    // Devuelve un json a la vista y lo muestra en la tabla. 
                    List<Docente> lista2 = operacionesDocente.ListarDocentesConCursos();

                    for (Docente docente : lista2) {

                        ObjetoAMostrar objetoAMostrar = new ObjetoAMostrar();
                        objetoAMostrar.setId((int) docente.getCodigoDocente());
                        objetoAMostrar.setNombreDocente(docente.getPrimerNombre() + " " + docente.getPrimerApellido());

                        for (DocenteDirectorGrupo docentecurso : docente.getDocenteDirectorGrupoList()  ) {
                            objetoAMostrar.AgregarALista(docentecurso.getCurso().getCurso());
                        }

                        lista.add(objetoAMostrar);

                    }

                    response.setCharacterEncoding("UTF-8");

                    out.write(new Gson().toJson(lista));

                    break;
                case 2:

                    try {
                        // En este case podemos guardar un registro o Editar un registro.
                        
                        // Este caso es Guardar 

                        String[] arreglo = new String[request.getParameterValues("Cursos[]").length];
                        arreglo = request.getParameterValues("Cursos[]");

                        OperacionesDocente OpDoc = new OperacionesDocente();
                        Docente docente = OpDoc.Buscar(Integer.parseInt(request.getParameter("Docente")));

                        OperacionesCurso OpCur = new OperacionesCurso();

                        String indicador = request.getParameter("indicador");

                        if (indicador.equals("Guardar")) {
                            ObjetoAMostrar ObAMostrar = new ObjetoAMostrar();

                            for (int i = 0; i < arreglo.length; i++) {
                                Curso curso = new Curso();

                                curso = OpCur.Buscar(Integer.parseInt(arreglo[i]));

                                DocenteDirectorGrupo DocTieneCur = new DocenteDirectorGrupo();
                                DocTieneCur.setDocente(docente);
                                DocTieneCur.setCurso(curso);
                                DocTieneCur.setEstado(true);

                                op.registrar(DocTieneCur);

                                ObAMostrar.AgregarALista(curso.getCurso());

                            }
                            ObAMostrar.setId(docente.getCodigoDocente());
                            ObAMostrar.setNombreDocente( docente.getPrimerNombre() + " " + docente.getPrimerApellido()  );
                            lista.add(ObAMostrar);

                            out.write(new Gson().toJson(lista));
                        } else {

                            // En este Caso se va a Editar 
                            
                            /* Creamos un objeto OPERACIONES de la tabla intermedia Docente-Curso 
                               este objeto nos servirá para agregar Cursos Nuevos a un determinado docente. 
                            */
                            OperacionesTablaDocentes_Curso OpeDocCur = new OperacionesTablaDocentes_Curso();
                            
                            
                            /* Esta es una lista de Enteros, donde voy a cargar los Ids de los cursos 
                             que nos manden desde la vista */
                            List<Integer> ListaDeIds = new ArrayList<>();

                            // En este for cargo la lista ya antes creada con el arreglo de IDs. 
                            for (int i = 0; i < arreglo.length; i++) {
                                ListaDeIds.add(Integer.parseInt(arreglo[i]));
                            }

                            /*
                            Con este for leo todos los cursos que tiene el docente Asignado, 
                            si la lista de IDs ya antes creada No contiene un Id de un curso que tenga asignado ese docente 
                            Lo borra innmediatamente, colocandolo en estado inactivo (FALSE) 
                            Sino se cumple la primera condición, se procede entoneces a Buscar el curso en la lista de Ids 
                            y si lo encuentra (si están repetidos) lo borra de la lista, esto se hace mediante un Lamda. 
                            */
                            for (DocenteDirectorGrupo docenteCur : docente.getDocenteDirectorGrupoList()) {
                                if (!(ListaDeIds.contains(docenteCur.getCurso().getIdCurso()))) {
                                    docenteCur.setEstado(false);
                                } else {
                                    ListaDeIds.removeIf(p -> p.equals(docenteCur.getCurso().getIdCurso()));
                                }

                            }

                            for (Integer dato : ListaDeIds) {
                                Curso curso = OpCur.Buscar(dato);
                                DocenteDirectorGrupo DocCurso = new DocenteDirectorGrupo();

                                DocCurso.setDocente(docente);
                                DocCurso.setCurso(curso); 
                               // DocCurso.setFecha(new Date());
                                 DocCurso.setEstado(true);
                                 OpeDocCur.registrar(DocCurso);

                            }

                            operacionesDocente.modificar(docente);

                          
                            OperacionesCurso operacionescursos = new OperacionesCurso();

                            List<Curso> cursos = operacionescursos.ListarCursosNoElegidosAteriormente();

                            List<Integer> ListaIDs = new ArrayList<>();

                            for (Curso curso : cursos) {

                                ListaIDs.add(curso.getIdCurso());

                            }

                            out.write(new Gson().toJson(ListaIDs));

                        }

                    } catch (Exception ex) {
                        out.write(new Gson().toJson("Error"));
                    }
                    break;
                case 3:

                    /*                    
                    En este case podemos buscar un Registro en la BD,
                    devuelve un json del registro encontrado
                    Y los cursos, los cuales le pertenecen al docente. 
                    */
                   
                 
                    int IdObjeto = Integer.parseInt(request.getParameter("IdObjeto"));

                    Docente docente = operacionesDocente.Buscar(IdObjeto);

                    ObjetoAMostrar obAMostrar = new ObjetoAMostrar();
                    obAMostrar.setNombreDocente(docente.getPrimerNombre() + " " + docente.getPrimerApellido());

                    for (DocenteDirectorGrupo  docenteCurso : docente.getDocenteDirectorGrupoList()) {

                        obAMostrar.AgregarALista(String.valueOf(docenteCurso.getCurso().getIdCurso()));

                    }

                    out.write(new Gson().toJson(obAMostrar));

                    break;

                case 4:

                    // Con este arreglo rellenamos una lista cursos
                    OperacionesCurso operacionescursos = new OperacionesCurso();

                    List<Curso> cursos = operacionescursos.ListarCursosNoElegidosAteriormente();

                    List<Integer> ListaIDs = new ArrayList<>();

                    for (Curso curso : cursos) {

                        ListaIDs.add(curso.getIdCurso());

                    }

                    out.write(new Gson().toJson(ListaIDs));

                    break;

                case 5:

                    /*
                      Con este case desactivamos todos los cursos que tenga el 
                      docente con un determinado Id que le pasamos mediante el Json que manda la vista, 
                   
                    */
                    
                 
                    int IdDocenteAEliminar = Integer.parseInt(request.getParameter("IdDocenteAEliminar"));

                    boolean Borrado = operacionesDocente.QuitarCursosAlDocente(IdDocenteAEliminar);

                    
                    /* Aquí se empiezan a leer de nuevo esos cursos que no han sido elegidos, 
                       Luego los cargamos  en una lista, Y posteriormente la mandamos mediante un Json 
                     a la vista. 
                    */
                    OperacionesCurso operacionescursos1 = new OperacionesCurso();

                    List<Curso> cursos1 = operacionescursos1.ListarCursosNoElegidosAteriormente();

                    List<Integer> ListaIDs1 = new ArrayList<>();

                    for (Curso curso : cursos1) {

                        ListaIDs1.add(curso.getIdCurso());

                    }

                    out.write(new Gson().toJson(ListaIDs1));
                    
                    break;

            }

        } catch (Exception ex) {
            out.write(new Gson().toJson("Error"));
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
