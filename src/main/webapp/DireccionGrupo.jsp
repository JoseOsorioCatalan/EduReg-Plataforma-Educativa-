<%@page import="co.osorio.modelo.Docente"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page import="co.osorio.modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="co.osorio.operaciones.OperacionesCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Direccion Grupo</title>

    <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="css/SeccionAsignacionDeCurso.css" >
    <link rel="stylesheet" href="css/fontello.css"> 
    <link rel="stylesheet" href="css/bootstrap/select2.css"> 
    <link rel="stylesheet" href="css/alertify.css">
    <link rel="stylesheet" href="css/default.css" >



</head>
<body>

    <%

        OperacionesCurso InstaciaOPC = new OperacionesCurso();
        OperacionesDocente InstanciaOPD = new OperacionesDocente();
   
        List<Curso> ListaCursos = InstaciaOPC.listarTodos();
        List<Curso> ListaCursosNoAgregados = InstaciaOPC.ListarCursosNoElegidosAteriormente();
        List<Docente> ListaDocentes = InstanciaOPD.ListarActivos(); 

    %>

    <%            /*
            
            
        public int buscarCliente(String r){
int index = -1;
int bound = clienteCelular.size();
for (int userInd = 0; userInd < bound; userInd++) {
    if (clienteCelular.get(userInd).nombre.equals(r)) {
        index = userInd;
        break;
    }
}
return index;
}
         */

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
                            <a href="#" class="dropdown-item"><span class="icon-cog"></span>Configuración</a>
                            <a href="#" class="dropdown-item"><span class="icon-mail-alt"></span>Mensajeria</a>
                            <a href="#" class="dropdown-item"><span class="icon-logout"></span>Salir</a>
                        </div>            
                    </div>


                </main> 

            </div>
        </nav><!-- / nav -->



    </header>


    <section id="main-content">

        <article>
            <h1> Direccion de grupo <span class=" icon-ok"></span></h1>

            <div style="height: 80px"></div>
            <div class="container">


                <div class="col-md-10">

                    <div class="card">

                        <div  class="card-header bg-primary progress-bar-striped">

                            <div class="card-title">
                                <h4> Asignar Curso  </h4>
                            </div> 



                        </div>





                        <div class="card-body">

                            <div class="row">


                                <div class="col-xs-2 col-sm-2 col-md-2">

                                    <label> <strong>Docente:</strong> </label>
                                </div>


                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <select id="Docentes" class='selector' > 
                                            <option value="">Selecciona un docente...</option>
                                            <%  for (Docente docente : ListaDocentes) {
                                            %>

                                            <option value="<%= docente.getCodigoDocente()%>"><%= docente.getPrimerNombre() + " " + docente.getPrimerApellido()%></option>  
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>


                                <div class="custom-control custom-switch CheckQuitar">
                                    <input type="checkbox" class="custom-control-input switch1" id="switch1">
                                    <label class="custom-control-label" for="switch1">Quitar Docente</label>
                                </div>



                            </div>


                            <div class="row">
                                <div class="col-xs-2 col-sm-2 col-md-2">
                                    <label> <strong>Curso: </strong> </label>
                                </div>


                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <select id="ListaCursos" class='mi-selector' name='cursos[]' multiple='multiple' >

                                            <% for (Curso curso : ListaCursos) {
                                            %>

                                            <!-- Aquí tengo que evaluar los cursos-->

                                            <%
                                                if (ListaCursosNoAgregados.contains(curso)) {
                                            %>
                                            <option value="<%= curso.getIdCurso()%>"><%= curso.getCurso()%> </option> 

                                            <%
                                            } else {
                                            %>
                                            <option value="<%= curso.getIdCurso()%>" disabled><%= curso.getCurso()%> </option> 
                                            <%
                                                }
                                            %>

 



                                            <%
                                                }
                                            %>



                                        </select> 
                                    </div>

                                </div>
                            </div>             

                            <input type="button" id="btnGuardarInfo" class="btn btn-primary" value="Guardar" >
                            <input type="button" id="btnCancelar" class="btn btn-danger" value="Cancelar" >

                        </div>


                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>Nota:</strong> Tenga en cuenta que un curso sólo puede tener un Director de grupo
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>


                    </div>


                </div>








                <div class="row pt-4">

                    <div class="col-md-12">

                        <div class="card">

                            <div  class="card-header bg-primary progress-bar-striped">

                                <div class="card-title">
                                    <h4> Docentes Directores  </h4>
                                </div> 
                            </div>

                            <div class="card-body">


                                <div class="container">

                                    <div class="panel panel-default">
                                        <div class="panel-body ">
                                            <table id="TablaAsignacion" class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr>
                                                        <th class="Encabezado">Código</th>
                                                        <th class="Encabezado">Docente</th>
                                                        <th class="Encabezado">Cursos</th>
                                                        <th class="Encabezado"> Acciones </th>
                                                    </tr>
                                                </thead>
                                                <tbody id="cuerpo">
                                                    
                                                 
                                             
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>

                                <br><br><br>

                            </div>
                        </div>
                    </div>



                </div>

            </div>

            <div id="loading-screen" style="display:none">
                <img src="imagenes/spinning-circles.svg">
            </div>



        </article>
    </section>



    <footer id="main-footer">
        <p>&copy; 2014 <a href="#">osorio.co</a></p>
    </footer> <!-- / #main-footer -->



    <!--Archivos de javascript -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrapJS/bootstrap.min.js"></script>
    <script src="js/jquery.min.js" ></script>
    <script src="js/select2.min.js"></script>
    <script src="js/alertify.js"></script> 
    <script src="js/AplicacionAsigCursos.js"></script>




</body>
</html>


