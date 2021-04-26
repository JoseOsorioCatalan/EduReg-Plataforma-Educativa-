
<%@page import="co.osorio.modelo.DocenteDirectorGrupo"%>
<%@page import="co.osorio.operaciones.OperacionesTablaDocentes_Curso"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page import="co.osorio.modelo.Docente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="utf-8">

        <title>Edureg | Docentes</title>
        <%
            try {

                OperacionesDocente operacion = new OperacionesDocente();
                List<Docente> listaDocentes = operacion.ListarActivos();
                OperacionesTablaDocentes_Curso operacionesTablaIntermedia = new OperacionesTablaDocentes_Curso();
                List<DocenteDirectorGrupo> listaTablaIntermedia = operacionesTablaIntermedia.listarTodos();

        %>



        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel = "stylesheet" href = "https://fonts.googleapis.com/css2?family=Roboto">
        <link rel="stylesheet" href="css/secciondocente.css">
        <link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="css/datatables.min.css">
        <link rel="stylesheet" href="css/fontello.css">
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

                <h1>Docentes <span class="icon-black-tie"></span></h1>

                <%
                %>




                <div class="container">

                    <a href="RegistroDocente.jsp" class="btn btn-primary btn-lg ">Agregar docente  <i class="icon-user-add"></i> </a>   

                    <div style="height: 100px"></div> 
                    <div class="table-responsive">



                        <table class="table display AllDataTables table-bordered">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Documento</th>
                                    <th>Apellidos</th>
                                    <th>Nombres</th>
                                    <th>Especialidad</th>
                                    <th>Asignado</th>
                                    <th>Accciones</th>

                                </tr>
                            </thead>
                            <tbody>





                                <%                                    for (Docente doc : listaDocentes) {

                                %>
                                <tr>
                                    <td><%= doc.getCodigoDocente()%></td>
                                    <td><%= doc.getIdDocente()%></td> 
                                    <td><%= doc.getPrimerApellido() + " " + doc.getSegundoApellido()%></td>
                                    <td><%= doc.getPrimerNombre() + " " + doc.getSegundoNombre()%></td>
                                    <td><%= doc.getEspecialidad()%></td>
                                    <td>
                                        <%
                                            for (DocenteDirectorGrupo objetoTablaIntermedia : listaTablaIntermedia) {
                                                if (objetoTablaIntermedia.getDocente().getCodigoDocente() == doc.getCodigoDocente()) {
                                        %>
                                        <%= objetoTablaIntermedia.getCurso().getCurso()%>
                                        <%
                                                }
                                            }
                                        %>

                                    </td>
                                    <td><a href="EditarDocente.jsp?codigo=<%=doc.getCodigoDocente()%>" class="btn btn-outline-dark"><span class="icon-pencil" ></span></a>
                                        <a href="javascript:void(0)" onclick="borrar('<%=request.getContextPath()%>/ControladorDocentes?id=eliminar&codigo=<%=doc.getCodigoDocente()%>')" class="btn btn-outline-danger"><span class="icon-trash"></span></a> 

                                </tr>

                                <%

                                        }

                                    } catch (Exception e) {

//response.sendRedirect(request.getContextPath() + "/PageError.jsp");
                                        out.print("Exepcion en: " + e.getMessage());
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

        <!--Archivos de javascript -->


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


        <!--Archivos de javascript-->

    </body>
</html>
