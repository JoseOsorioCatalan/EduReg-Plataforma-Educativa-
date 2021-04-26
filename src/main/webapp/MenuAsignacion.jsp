<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=500 initial-scale=1" >
        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link rel ="stylesheet" href = "https://fonts.googleapis.com/css2?family=Roboto" >
        <link rel="stylesheet" href="css/EstilosMenuAsignacion.css">
        <link rel="stylesheet" href="css/fontello.css" >

        <title>JSP Page</title> 
    </head>



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

            <h1> Menú de Asignación Académica</h1>

            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">

                            <div class="row">
                                <div class="col-md-4">
                                    <i> <span class="icon-users"></span> </i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">Asignación por Grupo Escolar </h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                        <a href="AsignacionPorGrupo.jsp" class="btn btn-primary">Ir a esta opcion </a>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            
                            
                            
                            <div class="row">
                                <div class="col-md-4">
                                      <i> <span class="icon-user"></span> </i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">Asignacion por Docente </h5>
                                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                        <a href="AsignacionPorDocente.jsp" class="btn btn-primary">Ir a esta opcion </a>
                                    </div>
                                </div>
                            
                        </div>
                    </div>
                </div> 
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




</body>





</html>
