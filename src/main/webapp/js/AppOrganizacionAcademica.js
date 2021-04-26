const cursosElements = document.getElementById("cursos");
const asignaturasElements = document.getElementById("asignaturas");
const periodoElements = document.getElementById("periodo");

cursosElements.addEventListener('change', (event) => {

    obtenerData();
});

asignaturasElements.addEventListener('change', (event) => {

    obtenerData();
});


periodoElements.addEventListener('change', (event) => {
    obtenerData();
});

function obtenerData()
{
    if (cursosElements.value != 0 && asignaturasElements.value != 0 && periodoElements.value != 0)
    {
        let objeto = { idAsignatura: asignaturasElements.value, idCurso : cursosElements.value, periodo : periodoElements.value};

        console.log(objeto);

        $.ajax({
            url: "OrganizacionAcademica",
            data: objeto,
            type:"post", 
            dataType: "json",
            success: function(response)
            {
                alert(response);
            }
        });
    }


}
