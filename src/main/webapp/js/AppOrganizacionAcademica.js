const cursosElements = document.getElementById("cursos");
const asignaturasElements = document.getElementById("asignaturas");
const periodoElements = document.getElementById("periodo");
const nota_masiva = document.getElementById("nota-masiva");
const tabla = document.getElementById("notas");





cursosElements.addEventListener('change', (event) => {

    obtenerData();
});

asignaturasElements.addEventListener('change', (event) => {

    obtenerData();
});


periodoElements.addEventListener('change', (event) => {
    obtenerData();
});

nota_masiva.addEventListener('click', insertGrades);


function insertGrades()
{
    let valueSelect = document.getElementById("select-principal").value;
    let cantidad_filas = tabla.rows.length - 3; 



    for (let  i = 0; i < cantidad_filas; i++)
    {
        //Se utiliza Query Selector para seleccionar todas las listas que tienen la clase calificaciones
        const selects = document.querySelectorAll(".Select");
        selects[i].value = valueSelect ;
    }


}
function obtenerData()
{
    if (cursosElements.value != 0 && asignaturasElements.value != 0 && periodoElements.value != 0)
    {
        let objeto = {idAsignatura: asignaturasElements.value, idCurso: cursosElements.value, periodo: periodoElements.value};

        // console.log(objeto);

        $.ajax({
            url: "OrganizacionAcademica",
            data: objeto,
            type: "post",
            dataType: "json",
            success: function (response)
            {

                if (response.length !== 0)
                {
                    $('#notas > tbody').empty();
                    for (let dato of response)
                    {
                        console.log(response);
                        $('#notas').append('<tr colspan="1" align="center" ><td>  <input type="hidden" id="custId" name="custId" value="' + dato.idNota + '"> ' + dato.CodigoEstudiante +
                                '</td><td colspan="3">' + dato.PrimerNombre + " " + dato.SegundoNombre + " " + dato.PrimerApellido + " " + dato.SegundoApellido + '</td><td colspan="12">' +
                                '<select class="Select"> <option value="0">Escoja una calificacion</option> <option value="1" >SUPERIOR</option>  <option value="2">ALTO</option><option value="3">BASICO</option><option value="4">BAJO</option></select> </td><td colspan="2">' + dato.CodigoEstudiante + '</td>' +
                                '<td colspan="2">' + dato.CodigoEstudiante + '</td><td colspan="2">' + dato.CodigoEstudiante + '</td></tr>');
                    }
                } else
                {
                    alert("El docente no da la asignatura!");
                }
            }
        });
    }


}