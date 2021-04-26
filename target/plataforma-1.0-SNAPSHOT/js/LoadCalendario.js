
// Obtenemos el id de la tarjeta Calendario.
let TargetaCalendario = document.getElementById("Targeta-Calendario");
// Creamos una lista de eventos. 
let ListaDeEventos = ' <ul class="todo-list" data-widget="todo-list"';

// Creamos un arreglo donde estarán las decripciones de los eventos. 

let ArrayDescripciones = new Array(3); 


cargando(); 

$.ajax(
 {
    url: "ServletAgregarEventos?dato=4",
    type: 'POST',
    success: function (eventos)
    {
        
        alert(eventos);
        let i=0; 
        
        if(eventos!="Error")
        {
            TargetaCalendario.innerHTML = ""; 
        
        for (let evento of eventos)
        {
            
            
            ListaDeEventos = ListaDeEventos + '  <li>  <span class="text"> ' + evento.title + '</span> \n\
            <small class="badge badge-danger item-evento" onclick="mostrarEvento( ' + i  + ')"   ><i class="icon-eye"></i>' + evento.start +  ' </small> \n\
            <div class="tools"></div>  </li> '; 
     
             ArrayDescripciones[i] = evento.descripcion ;
             console.log(ArrayDescripciones[i]); 
              i++;
        }
        
        } 
        else
        {
            ListaDeEventos = '<li class="text-danger"> <span class="icon-database"></span> Error al leer los datos</li>' 
        }
        
       ListaDeEventos = ListaDeEventos + "</ul>" ; 
       TargetaCalendario.innerHTML= ListaDeEventos;  
    

    }
});


function cargando()
{
      $(document)

            .ajaxStart(function () {
                TargetaCalendario.innerHTML = '<div class="mx-auto d-block spinner-border text-primary" role="status">'
               + ' <span class="sr-only">Loading...</span></div>'; 
 
            }) ; 
            
}


function mostrarEvento( position )
{
    
      let modalDesc = ' <div class="modal-dialog modal-sm" role="document">'
              + ' <div class="modal-content">'
              +   '   <div class="modal-header">'
               +         '<h5 class="modal-title" id="TituloEvento"> Descripcion Evento </h5>'
                  +   '   <button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                   +        ' <span aria-hidden="true">&times;</span>'
                    +'    </button>'
                   + ' </div>'
                   +' <div class="modal-body">'
                    +  '  <div class="form-row">'
                     +     '  <p> <em>' + ' "'   +  ArrayDescripciones[position]   +  '" ' +  ' </em> </p> '
                     + '  </div><div class="modal-footer">      '                      
                      +    '  <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="icon-thumbs-up"></span></button>'
                     + '   </div></div></div>  </div>   '; 
    
    document.getElementById("modalDescripcion").innerHTML = modalDesc; 
    
    
    $('#modalDescripcion').modal('show'); 
    
    

    
}  
