<%@page import="co.osorio.operaciones.OperacionesAsignatura"%>
<%@page import="co.osorio.modelo.Asignacionesasignaturas"%>
<%@page import="co.osorio.modelo.Curso"%>
<%@page import="co.osorio.modelo.Asignatura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.osorio.modelo.Grado"%>
<%@page import="java.util.List"%>
<%@page import="co.osorio.modelo.Docente"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <title>Edureg | Asignacion Académica</title>
        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/SeccionAsignacionAcademica.css">
        <link rel="stylesheet" href="css/fontello.css">
    </head>

    <body>

        <header id="main-header">

            <a id="logo-header" href="InterfaceDocente.jsp">
                <span class="site-name">EduReg</span>
            </a> 

            <a href="InterfaceDocente.jsp" >
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

                <h1>Asignación Académica <span class="icon-address-book"></span></h1>

                <%
                    OperacionesDocente operaciones = new OperacionesDocente();
                    OperacionesAsignatura opAsignaturas = new OperacionesAsignatura();

                    Docente docente = operaciones.Buscar(1);
                    List<Curso> cursos = new ArrayList<>();
                    List<Asignatura> asignaturas = opAsignaturas.listarTodos();

                    for (Asignacionesasignaturas AsignacionesDoc : docente.getAsignacionesasignaturasList()) {
                        cursos.add(AsignacionesDoc.getCurso());
                    }

                %>

                <br>
                <br>
                <br>

                <div class="container">
                    <div class="well">
                        <div class="contenedor">
                            <div class="row">


                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <label >Cursos: </label>
                                    <select class="form-control" id="cursos">
                                        <option value="0">Seleccione un curso</option>

                                        <%for (Curso curso : cursos) {
                                        %>
                                        <option value="<%= curso.getIdCurso()%>" > <%= curso.getCurso()%></option> 
                                        <%  }
                                        %>

                                    </select>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">

                                    <label >Asignaturas </label>
                                    <select class="form-control" id="asignaturas">
                                        <option value="0">Seleccione una asignatura</option>
                                        <% for (Asignatura asignatura : asignaturas) {%>
                                        <option value="<%= asignatura.getIdAsignatura()%>" > <%= asignatura.getNombreAsignatura()%> </option> 
                                        <% }%>

                                    </select>

                                </div>




                            </div>

                            <div class="row">
                                     <div class="col-xs-6 col-sm-6 col-md-6">

                                    <label>Periodo</label>
                                    <select class="form-control" id="periodo">
                                        <option value="0">Seleccione un periodo</option>
                                        <option value="1"> 1 </option>
                                        <option value="2"> 2 </option>
                                        <option value="3"> 3 </option>
                                        <option value="4"> 4  </option>
                                    </select>

                                </div>
                                       
                            </div>
                        </div>
                    </div>
                </div>

                <br>
                <br>
                <br>

                <div class="container">

                    <form  action="" method="">


                        <table align="center" id="notas" class="table table-hover table-responsive table-bordered ">
                            <thead>

                            <tr>

                            <td colspan="4"  style="width: 300px;" >
                            <center>			  
                                <b>DATOS ESTUDIANTE </b>
                            </center>			
                            </td>	
                            <td colspan="12" style="width: 500px;" >
                            <center>
                                <b>CALIFICACIONES Y CONCEPTOS</b>
                            </center>
                                        </td>
                            <td rowspan="3" align="center">        
                                <b>FALLAS hrs</b>
                            </td>        			
                            <td colspan="3" rowspan="3"  align="center">				  
                                <b>DEF PER</b>		  
                            </td>	
                            <td colspan="3" rowspan="3"  align="center">				  
                                <b>DESEMPEÑO</b>	      
                            </td>	

                            </tr> 


                            <tr>

                                <td  colspan="1"  align="center"><b>CODIGO</b></td>
                                <td  colspan="3"  align="center"><b>APELLIDOS Y NOMBRES </b></td>	
                         
                                <td  align="center" colspan="12"><b>NOTA ABSOLUTA </b></td>
                                

                            </tr>


                            <tr>
                                <td colspan="1" ></td>
                                <td colspan="3" align="center" ><span class="icon-user-circle"></span></td>
                                
                                <td align="center" colspan="1">
                                    <b> CALIFICACIÓN GENERAL </b> 
                                    <br/>
                                    <select id="select-principal">
                                        <option value="0">Escoja una calificacion</option>
                                        <option value="1" >SUPERIOR</option>
                                        <option value="2" >ALTO</option>
                                        <option value="3" >BASICO</option>
                                        <option value="4">BAJO</option>
                                    </select>
                                    <a id="nota-masiva"><i  class="icon-cw-circled" ></i></a>
                                    <a href="" class="btn btn-info">Guardar<span class="icon-ok" ></span></a>
                                </td>
                              

                             </tr>




                            </thead>
                            <tbody id="cuerpo-tabla-calificaciones">
                
                            <td colspan ="21"><img style="width: 320px;  height: 523px; " src="imagenes/busqueda.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." > <b>No ha seleccionado nada...  </b> </td>

                            </tbody>
                        </table>

                    </form>    

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
        
        <script src="js/AppOrganizacionAcademica.js"></script>
        <!--Archivos de javascript--> 
    </body>
</html>
