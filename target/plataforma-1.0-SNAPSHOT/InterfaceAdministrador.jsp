<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=500, initial-scale=1">

        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="css/fullcalendar.min.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/estilos.css">


        <title>Edureg | Plataforma educativa </title> 


    </head>

    <body>

        <header id="main-header">

            <a id="logo-header" href="#">
                <span class="site-name">EduReg</span>
            </a> 

            <a href="#" >
                <img style="max-width: 90%;height: auto; padding: 24px 3px 10px 0;" src= "imagenes/agenda.png" width="50px" height="50px"/>
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
            <h1>Interface Administrador</h1>

            <hr style=" margin-left: 10px; height: 5px;
                width: 63%;
                background-color: yellow">


            <p class="ml-3"> <strong>Sitio de trabajo</strong></p>
            <article>


                <div class="container">

                    <div class="row">
                        <div class="col-lg-8">

                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img class="d-block w-100"  src="imagenes/pol3.jpg" alt="First slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="imagenes/la.jpg" alt="Second slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="imagenes/la.jpg" alt="Third slide">
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>

                        </div>

                        <div class="col-lg-4">



                            <div class="mt-4 card" style="max-width: 18rem; border-top-color: yellow; border-top-width: 3px ">

                                <div class="card-header text-center"> <span class="icon-calendar"></span> <strong>Próximos Eventos</strong> </div>
                                <div id="Targeta-Calendario" class="card-body">

                                  


                                </div>
                            </div>



                        </div>

                    </div> 
                </div>


                <div class=" ml-0 mt-4 container">
                    <div class="row">
                        <hr style=" margin-left: 10px; height: 5px;
                            width: 100%;
                            background-color: yellow">
                        <h4 class="mt-2 ml-1 subtitulo"><strong> <span class="icon-th"></span> Opciones Generales</strong></h4>
                    </div>

                </div>



                <div class="container">

                    <div class="row">
                        <div class="col-md-4">

                            <div class="card shadow-sm mt-3"  >

                                <a href="Docentes.jsp" class="mx-auto d-block" style=" width: 180px;"> <img style="width: 180px;  height: 120px; " src="imagenes/undraw_teacher_35j2.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body">
                                    <h4 class="card-title text-center"><strong>Docentes</strong></h4>                       
                                    <a href="Docentes.jsp" class="d-block btn btn-primary btn-sm " style="color: white;">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>
                            </div>

                        </div>  

                        <div class="col-md-4" >

                            <div class="card shadow-sm mt-3" >

                                <a href="Estudiantes.jsp" class="mx-auto d-block" style=" width: 180px;" > <img style="width:180px;  height: 120px;" src="imagenes/estudiante.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body">
                                    <h4 class="card-title text-center"><strong>Estudiantes</strong></h4>                       
                                    <a href="Estudiantes.jsp" class="d-block btn btn-primary btn-sm " style="color: white ">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>

                            </div>
                        </div>  

                        <div class="col-md-4">

                            <div class="card shadow-sm mt-3" >

                                <a href="ImprimirBoletines.jsp" class="mx-auto d-block" style=" width: 180px;"> <img style="width:180px ; height: 120px; " src="imagenes/boletines.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body">
                                    <h4 class="card-title text-center"><strong> Imprimir Boletines </strong></h4>                       
                                    <a href="ImprimirBoletines.jsp" class="d-block btn btn-primary btn-sm ml-4" style="color: white ">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>
                            </div>

                        </div>


                    </div>

                    <div class="row mt-4">

                        <div class="col-md-4">

                            <div class="card shadow-sm mt-3"  >

                                <a href="Eventos.jsp" class="mx-auto d-block" style=" width: 180px;"> <img style="width:180px  ; height: 120px;" src="imagenes/undraw_calendar_dutt.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body" >
                                    <h4 class="card-title text-center"><strong>Calendario de Eventos</strong></h4>                       
                                    <a href="Eventos.jsp" class="d-block btn btn-primary btn-sm" style="color: white ">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>
                            </div>

                        </div>  

                        <div class="col-md-4" >

                            <div class="card shadow-sm mt-3" >

                                <a href="DireccionGrupo.jsp" class="mx-auto d-block" style=" width: 180px;"> <img style="width:180px; height: 120px;" src="imagenes/directores.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body">
                                    <h4 class="card-title text-center"><strong>Directores de grupo </strong></h4>                       
                                    <a href="DireccionGrupo.jsp" class=" d-block btn btn-primary btn-sm ml-4" style="color: white ">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>

                            </div>
                        </div> 

                        <div class="col-md-4">

                            <div class="card shadow-sm mt-3" >

                                <a href="Perfil.jsp" class="mx-auto d-block" style=" width: 180px;"> <img style="width:180px ; height:120px ;" src="imagenes/personal.svg" class="card-img-top ml-5 mx-auto d-block" alt="..." ></a> 
                                <div class="card-body">
                                    <h4 class="card-title text-center"><strong> Mi perfil  </strong></h4>                       
                                    <a href="Perfil.jsp" class="d-block btn btn-primary btn-sm ml-4" style="color: white ">Ir a esta opcion <i class=" icon-angle-circled-right"></i></a>
                                </div>
                            </div>

                        </div>  

                    </div>

            </article> <!-- /article -->

        </section> <!-- / #main-content -->



        <footer id="main-footer">
            <p>&copy; 2014 <a href="#">osorio.co</a>
                <a href="https://www.facebook.com/" class="icon-facebook-official"></a>
                <a href="https://twitter.com/" class="icon-twitter-squared"></a>
            </p>
           
        </footer> <!-- / #main-footer -->

        <!--Archivos de javascript -->

      
        <!-- Modal (agregar,borrar,editar) -->
        <div id="modalDescripcion" class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
           
        </div>
        
        
        
        
        
        
         
        <script src="js/popper.min.js"></script>
        <script src="js/jquery.js"></script>    
        <script src="js/moment.min.js"></script>   
      
        <script src="js/jquery-3.2.1.min.js"></script>
          <script src="js/bootstrapJS/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script>
 
            $(function () {
                $.scrollUp({ scrollImg: true });
            });



        </script>

        <script src="js/LoadCalendario.js"></script>


    </body>
</html>
