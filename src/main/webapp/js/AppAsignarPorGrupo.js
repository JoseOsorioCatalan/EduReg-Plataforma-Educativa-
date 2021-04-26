
// Leemos el documento y seleccionamos los indices por defecto. 
jQuery(document).ready(function ($) {
    document.getElementById("curso").selectedIndex = 0;
});

//Obtenemos el select de los cursos por el id.
const cursos = document.getElementById("curso");

//Obtenemos el select de docentes 
const selectDocentes = document.getElementById("docente");

//Obtenemos el boton de agregar información 
const btnEnviarInfo = document.getElementById("agregar-info");

// Obtenemos un cuadro de texto con las horas semanales 
const txtHorasSemanales = document.getElementById("horas-semanales");

// Obtenemos un cuadro de texto de la ponderacion 
const txtPonderacion = document.getElementById("ponderacion");

// Obtenemos el select múltiple de las asignaturas
const asignaturas = document.getElementById("asignaturas");

// Obtenemos el boton guradar cambios mediante el id 
const btnGuardarCambios = document.getElementById("GuardarCambios"); 

// Disparamos un evento al seleccionar un item del select cursos. 

// obtenemos el id del loader 
let screen = $('#loading-screen');

cursos.addEventListener('change', (event) => {


    if (event.target.value != 0)
    {
        let informacion =
                {
                    value: 0,
                    dato: event.target.value
                };

        $('#TablaRegistros > tbody').empty();
        $.ajax({
            url: "AsignacionPorGrupos",
            method: "post",
            data: informacion,
            dataType: "json",
            beforeSend: function (xhr) {
                screen.fadeIn();

            },
            success: function (datos)
            {

                screen.fadeOut();
                if (datos.length > 0)
                {

                    // se está probando..


                    for (i = 0; i < datos.length; i++)
                    {

                        let cadena = '<select id="combo-doc' + i + '" class="opciones form-control">';


                        for (k = 1; k < selectDocentes.length; k++)
                        {
                            cadena = cadena + '<option value="' + selectDocentes.options[k].value + '"> ' + selectDocentes.options[k].text + '</option> ';
                        }

                        cadena = cadena + '</select>';


                        $("#cuerpo-tabla").append('<tr><td class="celdas"> ' + datos[i].asignatura + '</td> <td class="celdas">' + cadena + '</td>'
                                + '<td class="celdas"> <input type="text" value=" ' + datos[i].ponderacion + ' " > </td> <td class="celdas"> <input type="text" value=" ' + datos[i].HorasSemanales + ' ">  </td> <td class="celdas">'
                                + '<input class="check-eliminar" type="checkbox" onClick="Seleccionar(this,' + i + ')"></td>');

                        //     console.log("El docente es: " + datos[i].id); 
                        $("#combo-doc" + i).val(datos[i].codigodocente).trigger('change');

                    }


                }

            }

        });

    }
});

// Método para seleccionar una fila de la tabla de regsitros. 
function Seleccionar(check, index)
{
    console.log(index);
    if (check.checked)
    {
        document.getElementById("TablaRegistros").rows[index + 1].classList.add("tachado");
    } else
    {
        document.getElementById("TablaRegistros").rows[index + 1].classList.remove("tachado");
    }

}


btnEnviarInfo.addEventListener('click', (event) =>
{

    console.log("cursos: " + cursos.value + " docentes: " + selectDocentes.value + " horas semanales: " + txtHorasSemanales.value + "ponderacion: " + txtPonderacion.value + " asignaturas: " + asignaturas.value ); 
    if (cursos.value === "0" || selectDocentes.value === "0" || txtHorasSemanales.value === "" || txtPonderacion.value === "" || asignaturas.value === "")
    {
        alert("¡Hay listas desplegables que no han sido seleccionadas y campos de texto vacios! ");
    } else if ((isNaN(txtPonderacion.value) === true) || (isNaN(txtHorasSemanales.value) === true))
    {
        alert("Los campos horas semanales y ponderación solo pueden contener números");
    } else if (txtHorasSemanales.value.includes('.') === true || txtPonderacion.value.includes('.') === true)
    {
        alert("Los números que se  en los campos de texto no pueden tener decimales");
    } else
    {
        let Asignacion =
                {
                    value: 1,
                    curso: cursos.value,
                    docente: selectDocentes.value,
                    asignaturas: $('#asignaturas').val(),
                    horasSem: txtHorasSemanales.value,
                    ponderacion: txtPonderacion.value
                };
// console.log(Asignacion);
        $.ajax({
            url: "AsignacionPorGrupos",
            method: "post",
            data: Asignacion,
            dataType: "json",
            beforeSend: function (xhr) {
                screen.fadeIn();

            },
            success: function (datos)
            {
                screen.fadeOut();
                
                if(datos !== "Error")
                {
                  alertify.success("¡Datos guardados exitosamente!");
                  console.log(datos);
                  ReestablecerValores();
                } 
                else
                {
                    alertify.success("Ocurrio un error en el servidor"); 
                }
            }
        });



    }

}); 


btnGuardarCambios.addEventListener('click',(event)=> {
   console.log("evento disparado"); 
   
   // Se valida que hayan datos en la tabla 
   
   if(document.getElementById("TablaRegistros").rows > 0 )
   {
       console.log("la tabla tiene datos"); 
   }
   
});









function ReestablecerValores()
{
    // Reestablecemos el select cursos
    cursos.selectedIndex=0; 
    
    // Reestablecemos el select docentes
    selectDocentes.selectedIndex=0; 
    
    
    // Reestablecemos el valor del select mutliple de asignaturas
        $('#asignaturas').val('0').trigger('change');
        
    // Limpiamos el cuadro de texto ponderacion 
    txtPonderacion.value=""; 
    
    // Limpiamos el cuadro de texto Horas semanales 
    txtHorasSemanales.value=""; 
    
}