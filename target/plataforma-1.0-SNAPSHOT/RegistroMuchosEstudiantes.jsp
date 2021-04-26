<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">

        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="css/SeccionRegistroMuchosEstudiantes.css">
         
        <title> Registro muchos estudiantes</title>

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

                <h1>Matricular muchos estudiantes </h1>


                <div class="container">


                    <div class="alert alert-warning alert-dismissible fade show" role="alert">

                        <strong>Atencion: </strong> Esto es un método rápido que permite matricular muchos estudiantes, el sistema solicita muchos datos, los cuales más adelante pueden ser actualizados.
                    </div>

            

                        <table id="TablaDinamica" align="center" class="table table-hover table-responsive table-bordered ">
                            <thead>
                                <tr>
                                    <td colspan="9"> <strong> Cantidad de estudiantes:  </strong>
                                        <input type="number" id="CantidadFilas" name="CantidadFilas" >
                                        <button type="button"id="BotonInsertarFilas" class="btn-primary"> Agregar </button>
                                    </td>
                                </tr>
                            
                            <tr>
                                <th> <center>Documento</center></th>
                            <th> <center>Primer Apellido</center></th>
                            <th> <center>Segundo apellido</center></th>
                            <th> <center>Primer nombre</center></th>
                            <th> <center>Segundo nombre</center></th>
                            <th> <center>Curso</center></th>  
                           
                            </tr>



                            </thead>
                            <tbody id="CuerpoTabla">

                         


                            </tbody>
                        </table>

                    <button id="GuardarDatos" type="button" value="" class="btn btn-success"> Guardar  </button> 
  

                </div>
            </article>
        </section>


   <div id="loading-screen" style="display:none">
                <img src="imagenes/spinning-circles.svg">
            </div>


        <footer id="main-footer">
            <p>&copy; 2014 <a href="#">osorio.co</a></p>
        </footer> <!-- / #main-footer -->

        <!--Archivos de javascript -->
        <script src="js/jquery-3.3.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrapJS/bootstrap.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/collapse.js"></script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/AppRegMuchosEstudiantes.js"></script>

    </body>
</html>