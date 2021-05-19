
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">



        <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css"> 
        <link href = "https://fonts.googleapis.com/css2?family=Roboto" rel = "stylesheet">
        <link rel="stylesheet" href="css/SeccionDefinirCalendario.css">
        <link rel="stylesheet" href="css/fullcalendar.min.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/bootstrap/bootstrap-clockpicker.css">
        <link rel="stylesheet" href="css/bootstrap/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/alertify.css" >
        

        <style>

            .fc th
            {
                padding: 10px 0px;
                vertical-align: middle;
                background: #f2f2f2;
            }
            


        </style>

        <title>Definir Calendario</title>

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
                <h1>Definir Calendario <span class=" icon-calendar-1"></span></h1>

                <div style="height: 80px"></div>
                <div class="container">

                    <div class="row">

                        <div class="col"></div>

                        <div class="col-9"><div id="calendarioWeb"></div></div>

                        <div class="col"></div>


                    </div>


                </div>

              




            </article>
        </section>



        <footer id="main-footer">
            <p>&copy; 2014 <a href="#">osorio.co</a></p>
        </footer> <!-- / #main-footer -->



        <script src="js/popper.min.js"></script>
        <script src="js/jquery.js"></script>    
        <script src="js/moment.min.js"></script> 
        <!--Archivos de javascript -->
        <script src="js/bootstrapJS/bootstrap.min.js"></script>
        <!-- Full calendar-->

        <script src="js/fullcalendar.min.js"></script>     
        <script src="js/es.js"></script>
        <script src="js/bootstrapJS/bootstrap-clockpicker.js"></script>
        <script src="js/bootstrapJS/bootstrap-datepicker.js"></script>
        <script src="js/moment.min.js"></script> 
        <script src="js/alertify.js"></script>

        <script>
            $(document).ready(function ()
            {
                $('#Mensaje').hide();
                $('#calendarioWeb').fullCalendar({

                    header:
                            {
                                left: 'today,prev,next',
                                center: 'title',
                                right: 'month,basicWeek,basicDay, agendaWeek,agendaDay'
                            },

                    dayClick: function (date, jsEvent, view)
                    {
                        LimpiarElementos();
                        QuitarClases();
                        $('#btnAgregar').prop("disabled", false);
                        $('#btnModificar').prop("disabled", true);
                        $('#btnEliminar').prop("disabled", true);
                        $('#TituloEvento').html('Agregar Evento');
                        $("#ModalEventos").modal();

                        $("#ModalEventos").modal();
                    },

                    events: "http://localhost:8080/plataforma/ServletAgregarEventos?dato=0",
                    

                    eventClick: function (calEvent, jsEvent, view)
                    {

                        $('#btnAgregar').prop("disabled", true);
                        $('#btnModificar').prop("disabled", false);
                        $('#btnEliminar').prop("disabled", false);

                        $('#TituloEvento').html('"' + calEvent.title + '"');

                        $('#txtDescripcion').val(calEvent.descripcion);
                        $('#txtId').val(calEvent.id);
                        $('#txtTitulo').val(calEvent.title);
                        $('#txtColor').val(calEvent.color);


                        FechaHoraInicio = calEvent.start._i.split(" ");
                        FechaHoraFin = calEvent.fin.split(" ");
                        let fechaInicial = FechaHoraInicio[0].split('/');
                        let fechaFinal = FechaHoraFin[0].split('/');



                        $("#txtFechaInicio").datepicker(
                                {
                                    dateFormat: 'dd/mm/yyyy',
                                    firstDay: 1
                                }).datepicker("setDate", fechaInicial[2] + "/" + fechaInicial[1] + "/" + fechaInicial[0]);

                        $('#txtHoraInicio').val(FechaHoraInicio[1]);


                        $("#txtFechaFin").datepicker(
                                {
                                    dateFormat: 'dd/mm/yyyy',
                                    firstDay: 1
                                }).datepicker("setDate", fechaFinal[2] + "/" + fechaFinal[1] + "/" + fechaFinal[0]);


                        $('#txtHoraFin').val(FechaHoraFin[1]);

                        $("#ModalEventos").modal();
                    }


                });

            });

        </script>





        <!-- Modal (agregar,borrar,editar) -->
        <div class="modal fade" id="ModalEventos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h5 class="modal-title" id="TituloEvento"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">

                        <div id="descripcionEvento">
                            <form action="  " method="POST"  id="frm_nuevo">

                                <input type="hidden" id="txtId" name="txtId"/>

                                <div class="input-group mb-2 mr-sm-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><span class="icon-pencil"></span></div>
                                    </div>
                                    <input type="text" class="form-control" id="txtTitulo" placeholder="Ingrese título del evento" required>

                                    <div id="InvalidtxtTitulo" class="invalid-feedback">
                                        Necesita agregar título. Debe ser de 4 a 45 caracteres. 
                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-sm-6 mt-3">
                                        <div class="form-group">


                                            <div class="input-group date">

                                                <div class="input-group-append">
                                                    <div class="input-group-text"><i class="icon-calendar-plus-o"></i></div>
                                                </div>
                                                <input type="text" class="form-control jc-date" id="txtFechaInicio" placeholder="Fecha de Inicio" required>
                                                <div id="InvalidtxtFechaInicio" class="invalid-feedback">
                                                    Necesita agregar la fecha de inicio
                                                </div>
                                            </div>
                                        </div> 

                                    </div>

                                    <div class="col-sm-6 mt-3">
                                        <div class="form-group">

                                            <div class="input-group clockpicker" data-autoclose="true" >
                                                <div class="input-group-append">
                                                    <div class="input-group-text"><i class="icon-hourglass"></i></div>
                                                </div>

                                                <input type="text" class="form-control" id="txtHoraInicio" placeholder = "Hora de Inicio" required>

                                                <div id="InvalidtxtHoraInicio" class="invalid-feedback">
                                                    Necesita agregar la hora de inicio 
                                                </div>

                                            </div>

                                        </div>
                                    </div>

                                </div>     



                                <div class="row">
                                    <div class="col-sm-6 mt-3">
                                        <div class="form-group">


                                            <div class="input-group date">

                                                <div class="input-group-append">
                                                    <div class="input-group-text"><i class="icon-calendar-plus-o"></i></div>
                                                </div>
                                                <input type="text" class="form-control jc-date" id="txtFechaFin" placeholder="Fecha de fin " required>

                                                <div id="InvalidtxtFechaFin" class="invalid-feedback">
                                                    Fecha final invalida. 
                                                </div>
                                            </div>
                                        </div> 

                                    </div>

                                    <div class="col-sm-6 mt-3">
                                        <div class="form-group">

                                            <div class="input-group clockpicker" data-autoclose="true" >
                                                <div class="input-group-append">
                                                    <div class="input-group-text"><i class="icon-hourglass"></i></div>
                                                </div>

                                                <input type="text" class="form-control" id="txtHoraFin" placeholder = "Hora de fin" required>

                                                <div id="InvalidtxtHoraFin" class="invalid-feedback">
                                                    Hora final invalida
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </div>  

                                <p id="Mensaje" style=" font-size: 14px; color: red;   " > La fecha y la hora final debe ser mayor que la fecha y hora de inicio. </p>         

                                <div class="form-group">
                                    <label>Descripcion:</label>
                                    <textarea id="txtDescripcion" rows="3" name="txtDescripcion" class="form-control" placeholder="Este evento tiene el propósito..." required ></textarea>

                                    <div id="InvalidtxtDescripcion" class="invalid-feedback">
                                        Debe agregar una descripcion del evento. La descripción debe ser de 10 a 100 caracteres. 
                                    </div>

                                </div>

                                <div class="form-group">
                                    <label>Escoja color: </label>      
                                    <input type="color" value="#ff0000" id="txtColor" name="txtColor" class="form-control" style="height: 36px;"><br/>
                                </div>





                            </form>



                        </div>    

                    </div>

                    <div class="modal-footer">
                        <div class="container">
                            <button id="btnAgregar" type="submit" class="btn btn-success mb-2" >Agregar</button>
                            <button id="btnModificar" type="button" class="btn btn-success mb-2" >Modificar</button>
                            <button id="btnEliminar" type="button" class="btn btn-danger mb-2" >Borrar</button>
                            <button type="button" class="btn btn-secondary mb-2" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <script>

            var NuevoEvento;
            $('#btnAgregar').click(function () {

                if (validarData())
                {
                    NuevoEvento = {
                        dato: "1",
                        title: $('#txtTitulo').val(),
                        start: $('#txtFechaInicio').val() + "/" + $('#txtHoraInicio').val(),
                        color: $('#txtColor').val(),
                        descripcion: $('#txtDescripcion').val(),
                        textColor: "#FFFFFF",
                        end: $('#txtFechaFin').val() + "/" + $('#txtHoraFin').val()
                    };


                    $.ajax({
                        url: "${pageContext.request.contextPath}/ServletAgregarEventos",
                        type: 'POST',
                        data: NuevoEvento,
                        success: function (data)
                        {
                            if (data != "Error")
                            {
                                alertify.success("¡Evento Guardado exitosamente!");
                            } else
                            {
                                alertify.error("Ocurrio un error al guardar el evento.");
                            }

                            $('#calendarioWeb').fullCalendar('refetchEvents');
                            $('#ModalEventos').modal('toggle');
                            QuitarClases();
                            LimpiarElementos();
                        }
                    });

                }




            });



            $('#btnEliminar').click(function () {

                NuevoEvento = {
                    dato: "2",
                    id: $('#txtId').val()
                };

                $.ajax({
                    url: "${pageContext.request.contextPath}/ServletAgregarEventos",
                    type: 'POST',
                    data: NuevoEvento,
                    success: function (data)
                    {
                        if (data != "Error")
                        {
                            alertify.success(data);
                        } else
                        {
                            alertify.success(data);
                        }
                        $('#calendarioWeb').fullCalendar('refetchEvents');
                        $('#ModalEventos').modal('toggle');
                    }
                });





            });

            $('#btnModificar').click(function () {

                if (validarData())
                {

                    NuevoEvento = {
                        dato: "3",
                        id: $('#txtId').val(),
                        title: $('#txtTitulo').val(),
                        start: $('#txtFechaInicio').val() + "/" + $('#txtHoraInicio').val(),
                        color: $('#txtColor').val(),
                        descripcion: $('#txtDescripcion').val(),
                        textColor: "#FFFFFF",
                        end: $('#txtFechaFin').val() + "/" + $('#txtHoraFin').val()
                    };

                    $.ajax({
                        url: "${pageContext.request.contextPath}/ServletAgregarEventos",
                        type: 'POST',
                        data: NuevoEvento,
                        success: function (data)
                        {
                            console.log("***" +  data + "***")
                            alert( NuevoEvento.start + " --- " + NuevoEvento.end ); 

                            if (data != "Error")
                            {
                                alertify.success("¡Evento modificado satisfactoriamente!");
                            } else
                            {
                                alertify.error("Ocurrio un error en el servidor");
                            }

                            $('#calendarioWeb').fullCalendar('refetchEvents');
                            $('#ModalEventos').modal('toggle');
                            QuitarClases();
                            LimpiarElementos();
                        }
                    });

                }

            });


            function RecolectarDatosGUI()
            {
                NuevoEvento = {
                    id: $('#txtId').val(),
                    title: $('#txtTitulo').val(),
                    start: $('#txtFechaInicio').val() + " " + $('#txtHoraInicio').val(),
                    color: $('#txtColor').val(),
                    descripcion: $('#txtDescripcion').val(),
                    textColor: "#FFFFFF",
                    end: $('#txtFechaFin').val() + " " + $('#txtHoraFin').val()
                };
            }



            function LimpiarElementos()
            {
                $('#TituloEvento').html('');
                $('#txtFechaInicio').val('');
                $('#txtHoraInicio').val('');
                $('#txtFechaFin').val('');
                $('#txtHoraFin').val('');
                $('#txtDescripcion').val('');
                $('#txtTitulo').val('');
                $('#txtColor').val('');

            }


            $("#btnmodal").on("click", function ()
            {
                $("#modalDate").modal();
            });



            $('.clockpicker').clockpicker();
            $(' .jc-date').datepicker({format: "dd/mm/yyyy"});


            function validarData()
            {
                VistoBuenoForm = true;

                /*
                 * Guardar los campos en variables.
                 */

                let TituloEvento = document.getElementById("txtTitulo");
                let FechaInicio = document.getElementById("txtFechaInicio");
                let HoraInicio = document.getElementById("txtHoraInicio");
                let FechaFinal = document.getElementById("txtFechaFin");
                let HoraFin = document.getElementById("txtHoraFin");
                let Descripcion = document.getElementById("txtDescripcion");

                let fechaInicioFormato = FechaInicio.value.split('/');


                // *Simplificar este codigo mas adelante* 


                // Validamos el título 
                if (TituloEvento.value === "" || TituloEvento.value.length > 45 || TituloEvento.value.length < 5)
                {
                    TituloEvento.classList.add('is-invalid');
                    VistoBuenoForm = false;
                } else
                {
                    TituloEvento.classList.remove('is-invalid');
                    TituloEvento.classList.add('is-valid');
                }



                // Validamos la fecha de inicio 
                if (FechaInicio.value === "")
                {
                    FechaInicio.classList.add('is-invalid');
                    VistoBuenoForm = false;
                } else
                {
                    FechaInicio.classList.remove('is-invalid');
                    FechaInicio.classList.add('is-valid');
                }


                // Validamos la hora de inicio 

                if (HoraInicio.value === "")
                {
                    HoraInicio.classList.add('is-invalid');
                    VistoBuenoForm = false;
                } else
                {
                    HoraInicio.classList.remove('is-invalid');
                    HoraInicio.classList.add('is-valid');
                }



                // Obtenemos la fechas de inicio y final respectivamente. 
                var fecha1 = moment(FechaInicio.value + " " + HoraInicio.value + ":00", 'DD/MM/YYYY HH:mm:ss');
                var fecha2 = moment(FechaFinal.value + " " + HoraFin.value + ":00", 'DD/MM/YYYY HH:mm:ss');


                // Validamos la Hora final 
                if (HoraFin.value === "")
                {
                    HoraFin.classList.add('is-invalid');
                    VistoBuenoForm = false;
                } else
                {
                    HoraFin.classList.remove('is-invalid');
                    HoraFin.classList.add('is-valid');
                }


                // Validamos la fecha final 

                if (FechaFinal.value === "")
                {
                    FechaFinal.classList.add('is-invalid');
                    VistoBuenoForm = false;

                } else if (moment(fecha1).isAfter(fecha2))
                {
                    HoraFin.classList.add('is-invalid');
                    FechaFinal.classList.add('is-invalid');
                    $('#Mensaje').show();
                    VistoBuenoForm = false;
                } else
                {
                    FechaFinal.classList.remove('is-invalid');
                    FechaFinal.classList.add('is-valid');
                    $('#Mensaje').hide();
                }





                // Validamos la descripcion. 
                if (Descripcion.value === "" || Descripcion.value.length < 10 || Descripcion.value.length > 100)
                {
                    Descripcion.classList.add('is-invalid');
                    VistoBuenoForm = false;
                } else
                {
                    Descripcion.classList.remove('is-invalid');
                    Descripcion.classList.add('is-valid');
                }





                return VistoBuenoForm;

            }

            function QuitarClases()
            {
                // Clases invalidas 
                document.getElementById("txtTitulo").classList.remove('is-invalid');
                document.getElementById("txtFechaInicio").classList.remove('is-invalid');
                document.getElementById("txtHoraInicio").classList.remove('is-invalid');
                document.getElementById("txtFechaFin").classList.remove('is-invalid');
                document.getElementById("txtHoraFin").classList.remove('is-invalid');
                document.getElementById("txtDescripcion").classList.remove('is-invalid');

                // Clases validas 
                document.getElementById("txtTitulo").classList.remove('is-valid');
                document.getElementById("txtFechaInicio").classList.remove('is-valid');
                document.getElementById("txtHoraInicio").classList.remove('is-valid');
                document.getElementById("txtFechaFin").classList.remove('is-valid');
                document.getElementById("txtHoraFin").classList.remove('is-valid');
                document.getElementById("txtDescripcion").classList.remove('is-valid');

                document.getElementById("Mensaje").style.display = "none";

            }





        </script>
    </body>
</html>















