

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">

        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/SeccionObservaciones.css">
        <link rel="stylesheet" href="css/fontello.css">


        <title>Edureg | Asignacion Académica</title>

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

                <h1>Observaciones</h1>
                <div class="container">
                     <div class="well">
                         <div class="contenedor">
                    <div class="row">


                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <label >Grado: </label>
                            <select class="form-control">
                                <option value="0">Seleccione un grado</option>
                                <option>1</option>
                                <option>2</option>  
                                <option>3</option>
                                <option>4</option>
                                <option>5</option> 
                            </select>
                        </div>

                        <div class="col-xs-6 col-sm-6 col-md-6">

                            <label >Asignatura</label>
                            <select class="form-control">
                                <option value="0">Seleccione una asignatura</option>
                                <option>Matemática</option>
                                <option>Castellano</option>
                                <option>Inglés</option>
                                <option>Informática</option>
                                <option>Naturales</option> 
                                <option>Religion</option> 
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

                    <form  action="#" method="post">


                        <table align="center" class="table table-bordered">
                            <thead>

                            <th>Estudiante</th>
                            <th>Observaciones</th>

                            </thead>
                            <tbody>
                                <tr>
                                    <td>Jose Carlos Osorio Catalan </td>
                                    <td><a href="javascript:void(0)" onclick="borrar()" class="btn btn-success">Generar observaciones <span class=" icon-pencil-1"></span></a> </td>  
                                </tr>     

                                <tr>
                                    <td>Jose Carlos Osorio Catalan </td>
                                    <td><a href="javascript:void(0)" onclick="borrar()" class="btn btn-success">Generar observaciones <span class=" icon-pencil-1"></span></a> </td>  
                                </tr>   

                                <tr>
                                    <td>Jose Carlos Osorio Catalan </td>
                                    <td><a href="javascript:void(0)" onclick="borrar()" class="btn btn-success">Generar observaciones <span class=" icon-pencil-1"></span></a> </td>  
                                </tr>                             		
                                <tr>
                                    <td>Jose Carlos Osorio Catalan </td>
                                    <td><a href="javascript:void(0)" onclick="borrar()" class="btn btn-success">Generar observaciones <span class=" icon-pencil-1"></span></a> </td>  
                                </tr>                             		




                            </tbody>
                        </table>

                        <button type="submit" class="btn btn-success"> Guardar datos <span class="icon-ok-1"></span> </button>
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
        <!--Archivos de javascript-->

        <script>

                function borrar(url)
                {
                    $("#modalDate").modal();
                }

        </script>



        <div class="modal fade" id="modalDate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloEvento">Ingrese descripción</h5>
                        <button  type="button" class="close" data-dismiss="modal" aria-label="Close" >
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>Descripcion:</label>
                            <textarea id="txtDescripcion" rows="5" name="txtDescripcion" class="form-control" style="width: 450px"></textarea>

                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" >Guardar</button>
                        <button type="button" class="btn btn-success" >Modificar</button>
                        <button type="button" class="btn btn-danger" >Borrar</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
