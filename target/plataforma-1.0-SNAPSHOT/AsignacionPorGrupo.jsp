<%@page import="java.util.List"%>
<%@page import="co.osorio.modelo.Asignatura"%>
<%@page import="co.osorio.modelo.Docente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.osorio.modelo.Curso"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page import="co.osorio.operaciones.OperacionesAsignatura"%>
<%@page import="co.osorio.operaciones.OperacionesCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width= 500 initial-scale =1"> 

        <link rel ="stylesheet" href = "https://fonts.googleapis.com/css2?family=Roboto" >
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap/select2.css">
        <link rel="stylesheet" href="css/SeccionAsignacionPorGrupo.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/alertify.css">



        <title>Asignación por Grupo | EduReg </title>
    </head>
    <body>

        <%
            // Creamos unos objetos de Operaciones Cursos, Operaciones Asignaturas y Operaciones Docentes;   
            OperacionesCurso operacionescursos = new OperacionesCurso();
            OperacionesAsignatura operacionesasignaturas = new OperacionesAsignatura();
            OperacionesDocente operacionesdocente = new OperacionesDocente();

            // Creamos unos ArrayList para obtener todos los objetos correspondientes, y los inicializamos.  
            // Asignamos objetos a las respectivas listas
            List<Curso> ListaCurso = operacionescursos.listarTodos();
            List<Docente> ListaDocente = operacionesdocente.ListarActivos();
            List<Asignatura> ListaAsignatura = operacionesasignaturas.listarTodos();


        %>



        <header id="main-header">

            <a id="logo-header" href="InterfaceAdministrador.jsp">
                <span class="site-name">EduReg</span>
            </a> 

            <a href="InterfaceAdministrador.jsp" >
                <img src= "imagenes/agenda.png" width="50px" height="50px"/>
            </a>


            <nav>
                <div class="container">

                    <img src="imagenes/usuario.png" width="35px" class="img-usuario">
                    <main class="container">

                        <div class="dropdown mb-3">
                            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuBoton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Jose Carlos Osorio Catalan
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuBoton">
                                <a href="#" class="dropdown-item">Configuración</a>
                                <a href="#" class="dropdown-item">Mensajeria</a>
                                <a href="#" class="dropdown-item">Salir</a>
                            </div>            
                        </div>


                    </main> 

                </div>
            </nav><!-- / nav -->



        </header>


        <section id="main-content">

            <article>

                <h1> Asignación Por Grupo   </h1>

                <br><br>
                <div class="container">

                    <table id="TablaDatos" class="table table-bordered table-responsive-lg ">

                        <thead>

                            <tr class="bg-primary" style="color: white"><td colspan="5" class="text-center"> <h5> <strong>Registro de Asignacion Académica por grupo</strong> </h5>  </td></tr>

                            <tr>
                                <th class="encabezado">Grupo</th>
                                <th class="encabezado">Docente</th>
                                <th class="encabezado">Asignatura</th> 
                                <th class="encabezado">Horas Semanales</th>
                                <th class="encabezado">Ponderación</th> 
                            </tr>

                        </thead>

                        <tbody>

                            <tr>
                                <td align="center" >
                                    <select id="curso" class="form-control">
                                        <option value="0">Seleccione un curso...</option> 
                                        <%                                              for (Curso curso : ListaCurso) {%>

                                        <option value="<%= curso.getIdCurso()%>"> <%= curso.getCurso()%> </option>
                                        <% }

                                        %>
                                    </select>
                                </td>

                                <td align="center">

                                    <select id="docente" class="form-control">
                                        <option value="0">Seleccione un docente ...</option> 
                                        <%                                            for (Docente docente : ListaDocente) {
                                        %>    
                                            <option value="<%= docente.getCodigoDocente() %>"> <%= docente.getPrimerNombre() + " "
                                                    + docente.getSegundoNombre() + " " + docente.getPrimerApellido() + " " + docente.getSegundoApellido()%></option>
                                            <%  }
                                            %> 
                                    </select>

                                </td>

                                <td align="center" >

                                    <select id="asignaturas" class='mi-selector' name='asignaturas[]' multiple='multiple' >

                                        <%
                                            for (Asignatura asignatura : ListaAsignatura) {%>
                                        <option value="<%= asignatura.getIdAsignatura()%>" > <%= asignatura.getNombreAsignatura()%>  </option>
                                        <% }

                                        %>


                                    </select> 


                                </td> 

                                 <td align="center">
                                    <span>  <input type="text" id="horas-semanales" class="form-control" name="horas-semanales" style="width: 50%" > <strong>#</strong></span> 
                                </td> 
                                
                                <td align="center">
                                    <span>  <input type="text" id="ponderacion" class="form-control" name="ponderacion" style="width: 50%" > <strong>%</strong></span> 
                                </td> 

                            </tr> 

                            <tr>
                                <td colspan="5"> 
                                    
                                    <strong class="text-left"> Acciones: </strong> <button id="agregar-info" class="btn btn-info">Agregar</button> 
                                     <button id="GuardarCambios" class="btn btn-info">Guardar Cambios</button> 
                                </td>
                            </tr>

                        </tbody>

                    </table> 


                    <br><br><br><br>

                    <table id="TablaRegistros" class="table table-bordered table-responsive-lg">

                        <thead>
                        <th class="encabezado">Asignatura</th>
                        <th class="encabezado">Docentes</th> 
                        <th class="encabezado">Ponderación</th>
                        <th class="encabezado">Horas Semanales</th>
                        <th class="encabezado">Eliminar</th>

                        </thead>

                        <tbody id="cuerpo-tabla">

                        <td colspan="5" id="alerta" > 
                            <div class="alert alert-danger text-center">
                                <p id="parrafo-mensaje" > ¡Para empezar con las asignaciones debe escoger un curso!   </p> 
                            </div>
                        </td>

                        </tbody>

                    </table>



                </div>

                 <div id="loading-screen" style="display:none">
                                            <img src="imagenes/spinning-circles.svg">
                                        </div>

                                        
                                        


            </article> <!-- /article -->

        </section> <!-- / #main-content -->



        <footer id="main-footer">
            <p>&copy; 2014 <a href="#">osorio.co</a></p>
        </footer> <!-- / #main-footer -->

        <!--Archivos de javascript -->
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrapJS/bootstrap.min.js"></script>
        <script src="js/jquery.min.js" ></script> 
        <script src="js/select2.min.js"></script> 
        <script src="js/AppAsignarPorGrupo.js"></script> 
        <script src="js/alertify.js"></script>
        <script>



            $(".mi-selector").select2({
                placeholder: "Selecciona Asignatura..."
            });
        </script>







    </body>
</html>
