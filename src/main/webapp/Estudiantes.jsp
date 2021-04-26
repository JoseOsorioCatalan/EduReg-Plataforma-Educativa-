

<%@page import="co.osorio.modelo.DocenteDirectorGrupo"%>
<%@page import="co.osorio.modelo.Docente"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page import="co.osorio.modelo.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="co.osorio.operaciones.OperacionesEstudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">

        <title>Edureg | Estudiantes</title>

  
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href = "https://fonts.googleapis.com/css2?family=Roboto" >
        <link rel="stylesheet" href="css/seccionestudiante.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="css/datatables.min.css">
        <link rel="stylesheet" href="FontAwesome/all.min.css">

    </head>

    <body>

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

                <h1>Estudiantes</h1>


                <div class="container">




                    <a href="RegistroEstudiante.jsp"> <button type="button"  class="btn btn-success op1" >Matricular un estudiante <span class="input-group-addon"><i class="icon-user-add"></i></span> </button></a>

                    <a href="RegistroMuchosEstudiantes.jsp">     <button type="button"  class="btn btn-success" >Matricular muchos estudiantes <span class="input-group-addon"><i class="icon-users"></i></span> </button></a>  

                    <%

                        OperacionesEstudiante operacion = new OperacionesEstudiante();
                        List<Estudiante> lista = operacion.ListarActivos();
                     

                    %>

                    <div style="height: 100px"></div> 
                    <div class="table-responsive">



                        <table class="table display AllDataTables table-bordered">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Documento</th>
                                    <th>Apellidos</th>
                                    <th>Nombres</th>
                                    <th>Curso</th>
                                    <th>Director</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <% for (Estudiante est : lista) {

                                %>
                                <tr>
                                    <td><%= est.getCodigoEstudiante()%></td>
                                    <td><%= est.getIdEstudiante()%></td> 
                                    <td><%= est.getPrimerApellido() + " " + est.getSegundoApellido()%></td>
                                    <td><%= est.getPrimerNombre() + " " + est.getSegundoNombre()%></td>
                                    <td> <%= est.getCursoAsignado().getCurso()%>   </td>
                                    <td>  <%
                                        for (DocenteDirectorGrupo DocCur : est.getCursoAsignado().getDocenteDirectorGrupoList()) {%>
                                        <%=    DocCur.getDocente().getPrimerNombre() + " " + DocCur.getDocente().getPrimerApellido()%>
                                        <%  }
                                        %> </td>


                                    <td><a href="EditarEstudiante.jsp?codigo=<%=est.getCodigoEstudiante()%>" class="btn btn-outline-dark"><span class="icon-pencil" ></span></a>
                                        <a href="javascript:void(0)" onclick="borrar('<%=request.getContextPath()%>/ControladorEstudiante?id=eliminar&codigo=<%=est.getCodigoEstudiante()%>')" class="btn btn-outline-danger"><span class="icon-trash"></span></a> 

                                </tr>

                                <%

                                    }
                                %>


                            </tbody>
                        </table>

                    </div>



                </div>







            </article> <!-- /article -->

        </section> <!-- / #main-content -->



        <footer id="main-footer">
            <p>&copy; 2014 <a href="#">osorio.co</a></p>
        </footer> <!-- / #main-footer -->



        <!-- Modal (agregar,borrar,editar) -->
        <div class="modal fade" id="modalDate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloEvento">Eliminar</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">



                        <div class="form-row">

                            <h5> ¿Desea eliminar a esta persona?</h5> 



                        </div>    


                        <div class="modal-footer">
                            <button  onclick="Enviarinfo()" id="btnEliminar" type="submit" class="btn btn-danger" >Eliminar</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>

                        </div>
                    </div>
                </div>
            </div>   
        </div>

        <script>
            var link;
            function borrar(data)
            {
                $("#modalDate").modal();
                link = data;

            }

            function Enviarinfo()
            {
                window.location = link;
            }



        </script>





        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/jquery.min.js"></script>    
        <script src="js/moment.min.js"></script>   
        <script src="js/jquery.js"></script>
        <script src="js/bootstrapJS/bootstrap.min.js"></script>
        <script type="text/javascript" src="archivos/datatables.min.js"></script>    
        <script type="text/javascript" src="archivos/main.js"></script> 
        <script src="archivos/jszip.min.js"></script>    
        <script src="archivos/pdfmake.min.js"></script>    
        <script src="archivos/vfs_fonts.js"></script>
        <script src="archivos/buttons.html5.min.js"></script>
        <script src="archivos/buttons.html5.min.js"></script>


        <!--Archivos de javascript-->
    </body>
</html>
