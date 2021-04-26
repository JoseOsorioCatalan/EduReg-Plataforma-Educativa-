
<%@page import="co.osorio.modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="co.osorio.operaciones.OperacionesCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/SeccionRegistroEstudiante.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/bootstrap/bootstrap-datepicker.css">

        <!--    <link rel="stylesheet" href="css/bootstrap/bootstrap-datepicker.css"> -->

        <title>Edureg | Registro estudiante</title>

        <%!
            static String Departamentos[] = {
                "AMAZONAS",
                "ANTIOQUIA",
                "ARAUCA",
                "ATLÁNTICO", "BOLÍVAR", "BOYACÁ", "CALDAS", "CAQUETÁ",
                "CASANARE", "CAUCA", "CESAR", "CHOCÓ", "CÓRDOBA", "CUNDINAMARCA", "GUAINÍA",
                "GUAVIARE", "HUILA", "LA GUAJIRA", "MAGDALENA", "META", "NARIÑO", "NORTE DE SANTANDER", "PUTUMAYO",
                "QUINDÍO", "RISARALDA", "SAN ANDRÉS Y PROVIDENCIA", "SANTANDER", "SUCRE", "TOLIMA",
                "VALLE DEL CAUCA", "VAUPÉS", "VICHADA"
            };

            static String Años[] = {"2000", "2001", "2002", "2003",
                "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
                "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
                "2024", "2025", "2026", "2027", "2028", "2029", "2030"

            };

        %>

        <%

             List<Curso> ListaCursos = null;
             
            try {
                OperacionesCurso operaciones_curso = new OperacionesCurso();

               ListaCursos = operaciones_curso.listarTodos();

            } catch (Exception e) {
               out.print(e.getMessage());
            }


        %>



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

                <h1>Registro estudiante <span class="icon-user-circle"></span></h1>


                <div class="container">

                    <form role="form" action="<%=request.getContextPath()%>/ControladorEstudiante?id=registrar"  method="post" onsubmit="return ValidarForm()" >
                        <div class="well">

                            <div class="guia">Datos de identificacion</div>

                            <div class="row">

                                <div class="col-xs-6 col-sm-6 col-md-16">
                                    <div class="form-group">
                                        <label for="dni">Código:</label>
                                        <input type="number" name="dni" id="dni" class="form-control" placeholder="Número de D.N.I." tabindex="5" disabled>
                                    </div>
                                </div>


                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="tipoDocumento">Indique tipo de documento:</label>
                                        <select id="TipoDeDocumento" class="form-control" name="tipodocumento">
                                            <option value="0">--Tipo de documento--</option>
                                            <option>Cédula</option>
                                            <option>Targeta de identidad</option>
                                        </select>
                                    </div>
                                </div>





                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="numdocumento">Numero de documento:</label>
                                        <input type="number" name="numdocumento" id="numdocumento" class="form-control" tabindex="2" autocomplete="off" >
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">



                                        <label for="genero">Genero:</label>
                                        <select id="Genero" class="form-control" name="genero">
                                            <option value="0">--Indique el genero--</option>
                                            <option>Masculino</option>
                                            <option>Femenino</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div  class="form-group">
                                        <label for="fecha-nac">Fecha de nacimiento:</label>
                                        <input type="text" name="fecha-nac" id="fecha-nac" class="form-control jc-date" tabindex="2" autocomplete="off">


                                    </div>
                                </div>



                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="depnacimiento">Departamento de nacimiento:</label>
                                        <select id="DepDeNacimiento" name="depnacimiento"  class="form-control">
                                            <option value="0">--Departamento de nacimiento--</option>

                                            <% for (String Departamento : Departamentos) {%>

                                            <option><%= Departamento%></option>

                                            <% } %>



                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="mun-nacimiento">Municipio de nacimiento:</label>
                                        <input type="text" name="mun-nacimiento" id="mun-nacimiento" class="form-control" tabindex="2" autocomplete="off" >
                                    </div>
                                </div>


                            </div>



                            <div class="contenedor">
                                <label class="guia">Nombres y apellidos</label>
                                <div class="row">


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="PrimerApellido">Primer apellido:</label>
                                            <input type="text" name="PrimerApellido" id="PrimerApellido" class="form-control" tabindex="1" autocomplete="off" >
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="SegundoApellido">Segundo apellido:</label>
                                            <input type="text" name="SegundoApellido" id="SegundoApellido" class="form-control" tabindex="2" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="PrimerNombre">Primer nombre:</label>
                                            <input type="text" name="PrimerNombre" id="PrimerNombre" class="form-control" tabindex="2" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="SegundoNombre">Segundo nombre: </label>
                                            <input type="text" name="SegundoNombre" id="SegundoNombre" class="form-control" tabindex="2" autocomplete="off">
                                        </div>
                                    </div>

                                </div>
                            </div>



                            <div class="contenedor">

                                <label class="guia">Datos de contacto</label>
                                <div class="row">


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label>Acudiente:</label>
                                            <select id="Acudiente" class="form-control" name="acudiente">
                                                <option value="0">--Persona acudiente--</option>
                                                <option>Madre</option>
                                                <option>Padre</option>
                                                <option>Tio</option>
                                                <option>Abuelo</option>
                                                <option>Conocido</option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Direccion">Direccion:</label>
                                            <input type="Direccion" name="direccion" id="Direccion" class="form-control" tabindex="4" autocomplete="off">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Telefono">Telefono:</label>
                                            <input type="number" name="telefono" id="Telefono" class="form-control"  tabindex="1" autocomplete="off">

                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Departamento actual </label>
                                            <select id="DepActual" class="form-control" name="departamentoactual">
                                                <option value="0">--Elija departamento--</option>

                                                <% for (String Departamento : Departamentos) {%>

                                                <option><%= Departamento%></option>

                                                <% } %>



                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="municipio-actual">Municipio actual:</label>
                                            <input type="text" name="municipio-actual" id="municipio-actual" class="form-control"  tabindex="1" autocomplete="off">

                                        </div>
                                    </div>


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Barrio">Barrio:</label>
                                            <input type="text" name="Barrio" id="Barrio" class="form-control"  tabindex="1" autocomplete="off">

                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="sitioPoblacional">Sitio poblacional:</label>
                                            <select id="SitioPoblacional" class="form-control"name="sitioPoblacional">
                                                <option value="0">--Elija sitio--</option>
                                                <option>Urbano</option>
                                                <option>Rural</option>
                                            </select>
                                        </div>
                                    </div>



                                </div>

                            </div> 


                            <div class="contenedor">
                                <label class="guia">Datos de matricula </label>
                                <div class="row">


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Curso Estudiante: </label>
                                            <select id="Curso" class="form-control" name="Curso">
                                               
                                                   <option value="0">--Seleccione un Curso--</option>
                                                
                                                <% for(Curso curso : ListaCursos )
                                                { %>
                              <option value="<%= curso.getIdCurso() %>" > <%= curso.getCurso() %> </option>
                                               <% }
                                                %>
                                                
                                                
                                                
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Sede donde será matriculado:</label>
                                            <select id="Sede" class="form-control" name="sede">
                                                <option value="0">--Elija la sede--</option>
                                                <option>Principal</option>
                                                <option>Sede 2</option>
                                              
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label>Estudiante nuevo: </label>
                                            <select id="EstudianteNuevo" class="form-control" name="nuevo">

                                                <option>Sí</option>
                                                <option>No</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label > Año de Ingreso: </label>
                                            <select id="AñoIngreso" class="form-control" name="AñoIngreso">
                                                <option value="0">Seleccione el año de ingreso</option>
                                                <% for (String Año : Años) {%>

                                                <option><%= Año%></option>

                                                <% }%>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Especifique si debe pagar matricula:</label>
                                            <select id="PagarMatricula" class="form-control" name="PagarMatricula">

                                                <option>Sí</option>
                                                <option>No</option>


                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label>Estado:</label>
                                            <select id= "Estado" class="form-control" name="estado" disabled="true">

                                                <option>Activo</option>
                                            </select>
                                        </div>
                                    </div>


                                </div>
                            </div>



                            <div class="contenedor">
                                <div class="row">
                                    <div class="col-xs-6 col-md-6"><input type="submit" value="Guardar datos" class="btn btn-success btn-block btn-lg " tabindex="1"></div>

                                    <div style="height: 60px;"></div>



                                    <div class="col-xs-6 col-md-6">   
                                        <a  href="Estudiantes.jsp" class="btn btn-secondary btn-block btn-lg" tabindex="8">Cancelar</a>
                                    </div>
                                </div>
                            </div>  

                        </div>




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
        <script src="js/bootstrapJS/bootstrap-datepicker.js"></script>
        <script src="js/app.js"></script>
        <script src="js/ValidarFormEstudiante.js"></script>






        <!--Archivos de javascript-->
    </body>
</html>
