<%@page import="co.osorio.modelo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="co.osorio.operaciones.OperacionesCurso"%>
<%@page import="co.osorio.modelo.Docente"%>
<%@page import="co.osorio.operaciones.OperacionesDocente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        
        <link rel="stylesheet" href = "https://fonts.googleapis.com/css2?family=Roboto">
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="css/SeccionRegistroDocente.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/bootstrap/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/alertify.css">

        <title>Edureg | Editar Docente</title>



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

                <h1>Editar docente <span class="icon-edit"></span> </h1>

                <%

                    OperacionesDocente operaciones = new OperacionesDocente();
                    Docente docente = new Docente();
                    docente = operaciones.Buscar(Integer.parseInt(request.getParameter("codigo")));

                %> 

                <%!
                    static String Departamentos[] = {"DEPARTAMENTO",
                        "AMAZONAS",
                        "ANTIOQUIA",
                        "ARAUCA",
                        "ATLÁNTICO", "BOLÍVAR", "BOYACÁ", "CALDAS", "CAQUETÁ",
                        "CASANARE", "CAUCA", "CESAR", "CHOCÓ", "CÓRDOBA", "CUNDINAMARCA", "GUAINÍA",
                        "GUAVIARE", "HUILA", "LA GUAJIRA", "MAGDALENA", "META", "NARIÑO", "NORTE DE SANTANDER", "PUTUMAYO",
                        "QUINDÍO", "RISARALDA", "SAN ANDRÉS Y PROVIDENCIA", "SANTANDER", "SUCRE", "TOLIMA",
                        "VALLE DEL CAUCA", "VAUPÉS", "VICHADA"
                    };

                    static String Años[] = {"1980", "1981", "1982", "1983", "1984", "1985",
                        "1986", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993",
                        "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003",
                        "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
                        "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
                        "2024", "2025", "2026", "2027", "2028", "2029", "2030"

                    };


                %>             


                <div class="container">

                    <form role="form" action="<%=request.getContextPath()%>/ControladorDocentes?id=editar&codigo=<%=docente.getCodigoDocente()%>" method="post" onsubmit="return validar()" >
                        <div class="well">

                            <div class="guia2">Datos de identificacion</div>

                            <div class="row">

                                <div class="col-xs-6 col-sm-6 col-md-12">
                                    <div class="form-group">
                                        <label for="dni">Código:</label>
                                        <input type="number" name="dni" id="dni" class="form-control" tabindex="5" disabled value="00<%= docente.getCodigoDocente()%>">
                                    </div>
                                </div>


                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="tipoDocumento">Indique tipo de documento:</label>
                                        <select id="TipoDeDocumento" class="form-control" name="tipo_documento" required="true">  


                                            <%
                                                if (docente.getTipoDocumento().equals("Cédula")) {
                                            %>
                                            <option selected>Cédula</option>       

                                            <option>Targeta de identidad</option>
                                            <%
                                            } else {
                                            %>
                                            <option >Cédula</option>       

                                            <option selected>Targeta de identidad</option>

                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>





                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="numdocumento">Numero de documento:</label>
                                        <input type="text" name="numdocumento" id="numdocumento" class="form-control" tabindex="2"  required="true" value="<%= docente.getIdDocente()%>">
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">



                                        <label for="genero">Genero:</label>
                                        <select id="Genero" class="form-control" name="genero"  required="true">
                                            <option value="0">--Indique el genero--</option>

                                            <%
                                                if (docente.getGenero().equals("Masculino")) {
                                            %>
                                            <option selected>Masculino</option>
                                            <option>Femenino</option>
                                            <%
                                            } else {
                                            %>
                                            <option>Masculino</option>
                                            <option  selected>Femenino</option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="fecha_nac">Fecha de nacimiento:</label>
                                        <input type="text" name="fecha_nac" id="fecha_nac" class="form-control jc-date" tabindex="2"  required="true" value="<%= docente.getFechaNacimiento()%>">


                                    </div>
                                </div>



                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="depnacimiento">Departamento de nacimiento:</label>
                                        <select id="DepDeNacimiento" class="form-control" name="departamento_nac"  required="true">
                                            <option value="0">--Departamento de nacimiento--</option>

                                            <% for (String Departamento : Departamentos) {

                                                    if (Departamento.equals(docente.getDepartamentoNacimiento())) {
                                            %>
                                            <option selected> <%= Departamento%> </option> 
                                            <%
                                            } else {
                                            %>
                                            <option><%= Departamento%> </option>
                                            <%
                                                    }
                                                }
                                            %>



                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="mun_nacimiento">Municipio de nacimiento:</label>
                                        <input type="text" name="mun_nacimiento" id="mun_nacimiento" class="form-control" tabindex="2"  required="true" value="<%= docente.getMunicipioNacimiento()%>">
                                    </div>
                                </div>


                            </div>



                            <div class="contenedor">
                                <label class="guia2">Nombres y apellidos</label>
                                <div class="row">


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="PrimerApellido">Primer apellido:</label>
                                            <input type="text" name="PrimerApellido" id="PrimerApellido" class="form-control" tabindex="1"  required="true" value="<%= docente.getPrimerApellido()%>">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="SegundoApellido">Segundo apellido:</label>
                                            <input type="text" name="SegundoApellido" id="SegundoApellido" class="form-control" tabindex="2"  required="true" value="<%= docente.getSegundoApellido()%>">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="PrimerNombre">Primer nombre:</label>
                                            <input type="text" name="PrimerNombre" id="PrimerNombre" class="form-control" tabindex="2"  required="true" value="<%= docente.getPrimerNombre()%>">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="SegundoNombre">Segundo nombre: </label>
                                            <input type="text" name="SegundoNombre" id="SegundoNombre" class="form-control" tabindex="2"  required="true" value="<%= docente.getSegundoNombre()%>">
                                        </div>
                                    </div>

                                </div>
                            </div>



                            <div class="contenedor">

                                <label class="guia2">Datos de contacto</label>
                                <div class="row">




                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Direccion">Direccion:</label>
                                            <input type="Direccion" name="Direccion" id="Direccion" class="form-control" tabindex="4"  required="true" value="<%= docente.getDireccion()%>">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Telefono">Telefono:</label>
                                            <input type="text" name="Telefono" id="Telefono" class="form-control"  tabindex="1"  required="true" value="<%= docente.getTelefono()%>" >

                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Departamento actual </label>
                                            <select id="DepActual" class="form-control" name="dep_actual"  required="true">
                                                <option value="0">--Elija departamento--</option>

                                                <% for (String Departamento : Departamentos) {

                                                        if (Departamento.equals(docente.getDepartamentoNacimiento())) {
                                                %>
                                                <option selected> <%= Departamento%> </option> 
                                                <%
                                                } else {
                                                %>
                                                <option><%= Departamento%> </option>
                                                <%
                                                        }
                                                    }
                                                %>




                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6" >
                                        <div class="form-group">
                                            <label for="municipio_actual">Municipio actual:</label>
                                            <input type="text" name="municipio_actual" id="municipio_actual" class="form-control"  tabindex="1"  required="true" value="<%= docente.getMunicipioActual()%>">

                                        </div>
                                    </div>


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Barrio">Barrio:</label>
                                            <input type="text" name="Barrio" id="Barrio" class="form-control"  tabindex="1"  required="true" value="<%= docente.getBarrio()%>">

                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="sitiopob">Sitio poblacional:</label>
                                            <select id="SitioPoblacional" class="form-control" name="sitio_pob"  required="true">
                                                <option value="0">--Elija sitio--</option>


                                                <%
                                                    if (docente.getSitioPoblacional().equals("Urbano")) {
                                                %>
                                                <option selected>Urbano</option>
                                                <option>Rural</option>
                                                <%
                                                } else {
                                                %>
                                                <option>Urbano</option>
                                                <option selected>Rural</option>

                                                <%
                                                    }
                                                %>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Correo">Correo Electrónico</label>
                                            <input type="Email" name="Correo" id="Correo" class="form-control"  tabindex="1"  autocomplete="off">

                                        </div>
                                    </div>

                                </div>

                            </div>   


                            <div class="contenedor">
                                <label class="guia2">Docencia</label>
                                <div class="row">



                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Sede donde dará clases:</label>
                                            <select id="Sede" class="form-control" name="sede">
                                                <option value="0">--Elija la sede--</option>
                                             
                                                <% if (docente.getSede().equals("Principal")) { %>
                                                <option selected>Principal</option>
                                                <option>Sede 2</option>

                                                <% } else { %>
                                                <option>Principal</option>
                                                <option selected>Sede 2</option>
                                                <% }%>


                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label>Docente nuevo: </label>
                                            <select class="form-control" name="doc_nuevo">



                                                <%
                                                    if (docente.getNuevo().equals("Sí")) {
                                                %>
                                                <option selected>Sí</option>
                                                <option>No</option>
                                                <%
                                                } else {
                                                %>
                                                <option>Sí</option>
                                                <option selected>No</option>

                                                <%
                                                    }
                                                %>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label >Año de entrada: </label>
                                            <select id="AñoEntrada" class="form-control" name="año">
                                                <option value="0">--Elija año--</option>

                                                <%  for (String año : Años) {
                                                        if (!(docente.getAnoVigente().equals(año))) {%>
                                                <option> <%= año%> </option>
                                                <% } else {%>
                                                <option selected> <%= año%> </option>
                                                <% }
                                                    }
                                                %>

                                            </select>
                                        </div>
                                    </div>


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Especialidad">Especialidad:</label>
                                            <input type="text" name="Especialidad" id="Especialidad" class="form-control"  tabindex="1"  required="true" value="<%= docente.getEspecialidad()%>">

                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Usuario">Usuario:</label>
                                            <input type="Usuario" name="Usuario" id="Usuario" class="form-control" tabindex="4"  required="true" value="<%= docente.getUsuario()%>">
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="Contra">Contraseña:</label>
                                            <input type="password" name="Contra" id="Contra" class="form-control"  tabindex="1"  required="true" value="<%= docente.getContrasena()%>">

                                        </div>
                                    </div>


                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label>Estado:</label>
                                            <select class="form-control" name="estado" >


                                                <%
                                                    if (docente.getEstado().equals(true)) {
                                                %>
                                                <option selected>Activo</option>
                                                <option>Inactivo</option>

                                                <%
                                                } else {
                                                %>
                                                <option>Activo</option>
                                                <option selected>Inactivo</option>

                                                <%
                                                    }
                                                %>





                                            </select>
                                        </div>
                                    </div>


                                </div>
                            </div>

 

                            <div class="contenedor">
                                <div class="row">
                                    <div class="col-xs-6 col-md-6"><input type="submit" value="Guardar cambios" class="btn btn-success btn-block btn-lg " tabindex="1"></div>

                                    <div style="height: 60px;"></div>
                                        
                                    <div class="col-xs-6 col-md-6">   
                                        <a  href="Docentes.jsp" class="btn btn-secondary btn-block btn-lg" tabindex="8">Cancelar</a>
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
        <script src="js/alertify.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/validar.js"></script>




        <!--Archivos de javascript-->
    </body>
</html>
