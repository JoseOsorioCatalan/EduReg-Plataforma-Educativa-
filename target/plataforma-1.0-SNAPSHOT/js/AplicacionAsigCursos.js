

var screen = $('#loading-screen');
let borrado = true;


let Editando = document.getElementById("btnGuardarInfo");

function RunLoader()
{
      $(document)

            .ajaxStart(function () {
                screen.fadeIn();
            })
            .ajaxStop(function () {
                screen.fadeOut();
            });
  
}


jQuery(document).ready(function ($) {
    
        $('.mi-selector').select2();
        $('.selector').select2();

        $(".mi-selector").select2({
            placeholder: "Selecciona un curso..."
        });

        $('.CheckQuitar').hide();
        $('#btnCancelar').hide();



   

    RunLoader();
    var Dato;

    Dato = {
        dato: "1"
    };

    $.ajax({
        url: "ServletPrueba",
        type: 'POST',
        data: Dato,
        success: function (data)
        {

            for (i = 0; i < data.length; i++)
            {

                $("#TablaAsignacion").append('<tr>' +
                        '<td align="center" style="dislay: none;">  ' + 'Reg-' + data[i].Id + '</td>' +
                        '<td align="center" style="dislay: none;">' + data[i].nombreDocente + '</td>' +
                        '<td align="center" style="dislay: none;" > ' + data[i].ListaObjetos + '</td>' +
                        '<td align="center" style="dislay: none;"> <a  href="javascript:void(0)" class="editar" onClick="BuscarRegistro(' + data[i].Id + ')" ><span class="icon-pencil"></span></a> \n\
             <a href="javascript:void(0)" class="borrar" onClick="EliminarDocente(' + data[i].Id + ',' + 1 + ')"><span class="icon-trash-empty"></span></a></td>' + '</tr>');

            }

        }
    });

});



$('#btnGuardarInfo').click(function () {
    Validar();
});

$('#btnCancelar').click(function ()
{
    var opcion = {
        dato: "4"
    };

    RunLoader();

    $.ajax({
        url: "ServletPrueba",
        method: 'post', //en este caso
        data: opcion,
        dataType: 'json',
        success: function (data)
        {
            Editando.value = 'Guardar';
            borrado= true;
            $('.editar').removeClass('apagado');
            $('.borrar').removeClass('apagado');
            if (data.length > 0)
            {
                 
                $('#ListaCursos').find('option').each(function () {

                    $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);

                    for (i = 0; i < data.length; i++)
                    {
                        if ($(this).val() == data[i])
                        {

                            // Con esta linea activamos un opction de un select. 
                            $("#ListaCursos option[value=" + data[i] + " ]").attr("disabled", false);

                        }

                    }
                });

            } else
            {
                $('#ListaCursos').find('option').each(function () {

                    $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);
                });

            }

            $('.CheckQuitar').hide();
            $('#btnCancelar').hide();
            $('#btnGuardarInfo').removeClass('btn-warning');
            document.getElementById('btnGuardarInfo').value = 'Guardar';
            $("#Docentes").attr('disabled', false);

            ReestablecerValores();
        }
    });

});


$(function () {
    $(document).on('click', '.editar', function (event) {
        event.preventDefault();
        $('.editar').addClass('apagado');
        $('.borrar').addClass('apagado');
        borrado = false;

    });
});

function Validar()
{
    var Curso = $('#ListaCursos').val();

    if (Curso === null || document.getElementById("Docentes").value === "")
    {
        alertify.error('¡Debe escoger un Docente y un Curso!');
    } else
    {

        GuardarRegistro();
    }

}

function BuscarRegistro(IdABuscar)
{
    RunLoader();
    if (Editando.value != 'Editar')
    {

        document.getElementById("btnGuardarInfo").value = "Editar";
        $('#btnGuardarInfo').addClass('btn-warning');
        $('#btnCancelar').show();

        var RegistroABuscar = {
            dato: "3",
            IdObjeto: IdABuscar,
            Indicador: "AggEnteros"

        };

        $.ajax({
            url: "ServletPrueba",
            method: 'post', //en este caso
            data: RegistroABuscar,
            dataType: 'json',
            success: function (data)
            {
                console.log(data);

                $('#Docentes').find('option').each(function () {

                    if ($(this).text() === data.nombreDocente)
                    {
                        $("#Docentes").val($(this).val()).trigger('change');
                    }

                });
// Con el método .trim() se eliminan los espacios en blanco al PRINCIPIO Y AL FINAL solamente
                let datos = new Array(data.ListaObjetos.length);

                $('#ListaCursos').find('option').each(function () {

                    for (c = 0; c < datos.length; c++)
                    {
                        //data.ListaObjetos[c] === $(this).text().trim()
                        if (data.ListaObjetos[c] === $(this).val())
                        {
                            datos.push(data.ListaObjetos[c]);
                            $("#ListaCursos option[value=" + data.ListaObjetos[c] + " ]").attr("disabled", false);
                        }
                    }
                    //  $("#ListaCursos option[value=1]").removeAttr("selected");
                });

                $("#ListaCursos").val(datos);
                $("#ListaCursos").trigger("change");

                $("#Docentes").attr('disabled', 'disabled');
                $('.CheckQuitar').show();

            }
        });
    }

}

function ReestablecerValores()
{

    console.log('se realizo el metodo reestablecer valorees ');
    $('#ListaCursos').val('0').trigger('change');
    $('#Docentes').val('0').trigger('change');

}

function GuardarRegistro()
{
    RunLoader();
    let BotonAcciones = document.getElementById("btnGuardarInfo");
    if (BotonAcciones.value == 'Guardar')
    {

        var InformacionAEnviar;

        InformacionAEnviar = {
            dato: "2",
            indicador: "Guardar",
            Cursos: $('#ListaCursos').val(),
            Docente: $('#Docentes').val()
        };



        $.ajax({
            url: "ServletPrueba",
            method: 'post', //en este caso
            data: InformacionAEnviar,
            dataType: 'json',
            success: function (data)
            {

                let CursosGuardados = $("#ListaCursos").val();

                for (i = 0; i < CursosGuardados.length; i++)
                {
                    $("#ListaCursos option[value=" + CursosGuardados[i] + " ]").attr("disabled", true);

                }


                ReestablecerValores();

                if (data === 'Error')
                {

                    alertify.error('¡Ha ocurrido un error en el servidor!');
                } else if (data.length === 1)
                {
                    console.log(data.length);

                    let AgregarFilaNueva = true;

                    $("#TablaAsignacion td:nth-child(1)").each(function (index) {
                        let columna = $(this).html();
                        let IdentificacionDocente = 'Reg-';
                        IdentificacionDocente = IdentificacionDocente + data[0].Id;



                        index = index + 1;

                        if (columna.trim() === IdentificacionDocente.trim())
                        {
                            AgregarFilaNueva = false;
                            let TextoColumna = document.getElementById("TablaAsignacion").rows[index].cells[2].innerHTML;
                            document.getElementById("TablaAsignacion").rows[index].cells[2].innerHTML = TextoColumna + ", " + data[0].ListaObjetos;

                        }


                    });// 

                    if (AgregarFilaNueva)
                    {
                        // Acá manda una lista (por eso el data[0].atributo )
                        var fila = '<tr>' +
                                '<td align="center" style="dislay: none;">  ' + 'Reg-' + data[0].Id + '</td>' +
                                '<td align="center" style="dislay: none;">' + data[0].nombreDocente + '</td>' +
                                '<td align="center" style="dislay: none;" > ' + data[0].ListaObjetos + '</td>' +
                                '<td align="center" style="dislay: none;">  <a href="javascript:void(0)" class="editar" onclick="BuscarRegistro(' + data[0].Id + ')" >\n\
                                  <span class="icon-pencil"></span></a> \n\
                                <a href="javascript:void(0)" class="borrar" onClick="EliminarDocente(' + data[0].Id + ',' + 1 + ')"><span class="icon-trash-empty"></span>\n\
                                    </a></td>' + '</tr>'
                        var AggFila = document.createElement("TR");
                        AggFila.innerHTML = fila;
                        document.getElementById("cuerpo").appendChild(AggFila);


                    }

                    alertify.success('¡Guardado exitosamente!');

                }

            }
        });


    } else
    {
        EditarRegistro();
        Editando.value = 'Guardar';
        $('.editar').removeClass('apagado');
    }



}

function EditarRegistro()
{
    RunLoader();
    
    var InformacionAEditar;

    InformacionAEditar = {
        dato: "2",
        indicador: "Editar",
        Cursos: $('#ListaCursos').val(),
        Docente: $('#Docentes').val()
    };


    let NombresCursos = $('#ListaCursos :selected').text();
    $.ajax({
        url: "ServletPrueba",
        method: 'post', //en este caso
        data: InformacionAEditar,
        dataType: 'json',
        success: function (data)
        {
            if (data === 'Error')
            {
                alertify.error('Ocurrio un error en el Servidor...');
            } else
            {
                borrado=true;
                $('.borrar').removeClass('apagado');
                

                if (data.length > 0)
                {

                    $('#ListaCursos').find('option').each(function () {

                        $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);

                        for (i = 0; i < data.length; i++)
                        {
                            if ($(this).val() == data[i])
                            {

                                // Con esta linea activamos un opction de un select. 
                                $("#ListaCursos option[value=" + data[i] + " ]").attr("disabled", false);

                            }
                        }
                    });

                } else
                {
                    $('#ListaCursos').find('option').each(function () {

                        $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);
                    });

                }


            }


            $('.CheckQuitar').hide();
            $("#Docentes").attr('disabled', false);
            $('#btnCancelar').hide();
            $('#btnGuardarInfo').removeClass('btn-warning');
            alertify.warning("¡Registro editado Exitosamente!");

        }
    });

    $("#TablaAsignacion td:nth-child(1)").each(function (index) {
        let columna = $(this).html();
        let IdentificacionDocente = 'Reg-';
        IdentificacionDocente = IdentificacionDocente + InformacionAEditar.Docente;

        index = index + 1;

        if (columna.trim() === IdentificacionDocente.trim())
        {
            document.getElementById("TablaAsignacion").rows[index].cells[2].innerHTML = NombresCursos;
        }


    });

    ReestablecerValores();
}

$('#switch1').change(function () {
    if ($(this).prop('checked') == true) {

        alertify.confirm("¿Desea Quitar al Docente como director de grupo?",
                function () {
                    borrado = true;
                    EliminarDocente($('#Docentes').val(), 2);
                    $('.CheckQuitar').hide();
                    $('#switch1').prop('checked', false);
                },
                function () {
                    $('#switch1').prop('checked', false);
                });
    }


});

function EliminarDocente(codigo, indicador)
{
    if (borrado)
    {
        RunLoader();

        let InformacionAEliminar;

        InformacionAEliminar =
                {
                    dato: "5",
                    IdDocenteAEliminar: codigo
                };

        if (indicador == 1)
        {


            let CodigoIgual = $('#Docentes').val();

            alertify.confirm("¿Desea Eliminar este registro ?",
                    function ()

                    {

                        $.ajax({
                            url: "ServletPrueba",
                            method: 'post', //en este caso
                            data: InformacionAEliminar,
                            dataType: 'json',
                            success: function (data)
                            {

                                if (data.length > 0)
                                {

                                    $('#ListaCursos').find('option').each(function () {

                                        $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);

                                        for (i = 0; i < data.length; i++)
                                        {
                                            if ($(this).val() == data[i])
                                            {

                                                // Con esta linea activamos un opction de un select. 
                                                $("#ListaCursos option[value=" + data[i] + " ]").attr("disabled", false);

                                            }
                                        }
                                    });

                                } else
                                {
                                    $('#ListaCursos').find('option').each(function () {

                                        $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);
                                    });

                                }








                                if (data != 'Error')
                                {
                                    $("#TablaAsignacion td:nth-child(1)").each(function (index) {
                                        let columna = $(this).html();
                                        let IdentificacionDocente = 'Reg-';
                                        IdentificacionDocente = IdentificacionDocente + codigo;



                                        index = index + 1;

                                        if (columna.trim() === IdentificacionDocente.trim())
                                        {

                                            $(this).closest('tr').remove();

                                        }


                                    });// 
                                    alertify.success("!Registro eliminado correctamente!");

                                } else
                                {
                                    alertify.error("¡Registro no eliminado!");
                                }



                            }

                        });

                    });


        } else
        {


            $.ajax({
                url: "ServletPrueba",
                method: 'post', //en este caso
                data: InformacionAEliminar,
                dataType: 'json',
                success: function (data)
                {
                    if (data.length > 0)
                    {

                        $('#ListaCursos').find('option').each(function () {

                            $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);

                            for (i = 0; i < data.length; i++)
                            {
                                if ($(this).val() == data[i])
                                {

                                    // Con esta linea activamos un opction de un select. 
                                    $("#ListaCursos option[value=" + data[i] + " ]").attr("disabled", false);

                                }
                            }
                        });

                    } else
                    {
                        $('#ListaCursos').find('option').each(function () {

                            $("#ListaCursos option[value=" + $(this).val() + " ]").attr("disabled", true);
                        });

                    }

                    Editando.value = 'Guardar';
                    $('#btnCancelar').hide();
                    $('#btnGuardarInfo').removeClass('btn-warning');
                    $('.editar').removeClass('apagado');
                    $('.borrar').removeClass('apagado');
                    $('#Docentes').val('0').trigger('change');
                    $("#Docentes").attr('disabled', false);



                    if (data != 'Error')
                    {
                        $("#TablaAsignacion td:nth-child(1)").each(function (index) {
                            let columna = $(this).html();
                            let IdentificacionDocente = 'Reg-';
                            IdentificacionDocente = IdentificacionDocente + codigo;



                            index = index + 1;

                            if (columna.trim() === IdentificacionDocente.trim())
                            {

                                $(this).closest('tr').remove();

                            }


                        });
                        alertify.success("¡Registro eliminado correctamente!");

                    } else
                    {
                        alertify.error("¡Registro no eliminado!");
                    }



                }

            });

        }

    }
}

