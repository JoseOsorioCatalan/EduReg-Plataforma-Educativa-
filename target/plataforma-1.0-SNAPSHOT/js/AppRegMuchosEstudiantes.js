

document.getElementById("BotonInsertarFilas").addEventListener("click",AggFilas);
var screen = $('#loading-screen');

function EliminarFila(id){
  // cell element
  var cell = id.parentNode;
  // row element
  var row = cell.parentNode;

  document.getElementById("TablaDinamica").deleteRow(row.rowIndex);
}

function AggFilas()
{
     RunLoader(); 
  let TxtCantidadFilas = document.getElementById("CantidadFilas").value ;   

  let options = ' <select class="Curso" name="Curso">  \n\
 <option value="0">--Indique el curso--</option> ';



   
  let LongitudTabla =  document.getElementById("TablaDinamica").rows.length;
  let TotalFilas= Number(TxtCantidadFilas) +  Number(LongitudTabla - 2 )  ;
    
  if((TxtCantidadFilas <= 20 ) && ( TxtCantidadFilas > 0 ) && ( TotalFilas <= 20 ) )
  {
      let informacion = {
        Dato : "Leer"  
      };
      
      $.ajax({
         url: "ServletGuardarEstudiantes",
         data: informacion,
         dataType: "json", 
         method: "post",
         success: function ( Coleccion )
         {
  
            if(Coleccion!="Error")
            {
                    
    for (let clave in Coleccion) {
            // clave , valor
         
     options = options + ' <option value="' +  clave +'"> ' + Coleccion[clave] +  ' </option>';    
    
        }  
         
  options = options + '</select>';
            

      let Fila= ' <tr>  <td><input type="number" class="Documento" style="width: 150px;"></td>   ' +
          '<td><input type="text" class="PrimerApellido"  style="width: 150px;"></td> ' +
          '<td><input type="text" class="SegundoApellido" style="width: 150px;"></td>' +
          '  <td><input type="text" class="PrimerNombre"  style="width: 150px;"></td>' +
          '  <td><input type="text" class="SegundoNombre" style="width: 150px;"></td>  ' +
          ' <td>' + options + '   </td>  <td> <a id="QuitarFila" onclick="EliminarFila(this)" \n\
            class="btn-danger"><span class="icon-minus-circle"></span> </a> </td> </tr>'  ;
      
        
      
       var AggFila;
      for(i=0; i< TxtCantidadFilas; i++ )
      {
          AggFila = document.createElement("TR");
               
       AggFila.innerHTML =  Fila;
       document.getElementById("CuerpoTabla").appendChild(AggFila);
       
      }
      
     document.getElementById("CantidadFilas").value = "" ;
         
     } 
     else
     {
         alert("Ocurrio un error en el servidor. Compruebe su conexion o íntente realizar la operación más tarde");
     }

             
         }
      });
  
      
  } 
  else
  {
    
      alert("Puede que el dato que está proporcionando no sea valido.\n\
 recuerde que la tabla no puede exceder las 20 filas");
  }
    
}

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

function ValidarData()
{
 
 if(document.getElementById("TablaDinamica").rows.length > 2)
 {
     
   const Documento = document.querySelectorAll(".Documento");  
   const PrimerApellido = document.querySelectorAll(".PrimerApellido");; 
   const SegundoApellido = document.querySelectorAll(".SegundoApellido");
   const PrimerNombre = document.querySelectorAll(".PrimerNombre");
   const SegundoNombre = document.querySelectorAll(".SegundoNombre");
   const Curso = document.querySelectorAll(".Curso");
  


// Declaramos los Arreglos de los componentes que vamos a leer 
var VectorDocumento = [];
var VectorPrimerApellido = [];
var VectorSegundoApellido= [];
var VectorPrimerNombre = [];
var VectorSegundoNombre = [];
var VectorCurso = [];
        
let CamposCorrectos = true; 




for (var x = 0; x < Documento.length; x++) {
   
   if(Documento[x].value === "" || PrimerApellido[x].value === "" || SegundoApellido[x].value === "" || 
           PrimerNombre[x].value === "" || SegundoNombre[x].value === "" || Curso[x].value === "0"   )
   {
         alert("Pueden haber campos vacios, Listas deplegables sin seleccionar o números de documento con caracteres o letras"); 
         CamposCorrectos= false; 
         break; 
         
   } else if( PrimerApellido[x].value.length > 20 || SegundoApellido[x].value.length > 20 || 
           PrimerNombre[x].value.length > 20 || SegundoNombre[x].value.length > 20  ) 
   { 
       alert("Los campos de texto no pueden superar los 20 caracteres"); 
       CamposCorrectos = false; 
       break; 
   } 
   else if( Documento[x].value.length > 18 )
   {
        alert("El número de documento no puede superar los 18 números");
       CamposCorrectos = false; 
       break; 

   } 
   else if(Documento[x].value.includes('.') === true)
   {
       alert("El número de documento no puede contener puntos"); 
       CamposCorrectos = false; 
       break; 
   } 
   
   else if(Documento[x].value <= 0)
   {
       alert("Ningún número de cédula debe ser menor o igual a 0");
       CamposCorrectos = false; 
       break; 
   }
   else
   {
       VectorDocumento.push( Documento[x].value );
       VectorPrimerApellido.push(PrimerApellido[x].value); 
       VectorSegundoApellido.push(SegundoApellido[x].value);
       VectorPrimerNombre.push(PrimerNombre[x].value); 
       VectorSegundoNombre.push(SegundoNombre[x].value); 
       VectorCurso.push(Curso[x].value);
   }
     
}




if(CamposCorrectos)
{   
      /*
   * Siempre se coloca los atributos: 
   * La URL de dirección: 
   * el atributo method: post o get , 
   * el atributo data: lo que mando
   * dataType: jemplo: json , 
   * por ultimo el success()
   * 
   *
   */    
  
  let InformacionGuardarEstudiantes=
  {
     Dato: "Guardar", 
     identificacion: VectorDocumento,
     primerApellido: VectorPrimerApellido,
     segundoApellido: VectorSegundoApellido,
     primerNombre: VectorPrimerNombre, 
     segundoNombre: VectorSegundoNombre,
     Curso: VectorCurso
  }  ; 
  
  

RunLoader();
$.ajax({
    
  url: "ServletGuardarEstudiantes",
  method: "post",
  data: InformacionGuardarEstudiantes,
  dataType: "json",
  success: function(data)
  {

    if(data!="Error")
    {
        
      $('#TablaDinamica > tbody').empty();
      alert(data);  
    } 
    else
    {
        alert("Ocurrio un error en el servidor. Compruebe su conexion o íntente realizar la operación más tarde"); 
    }
    
  }
        
});
}
   

 } else
 {
     alert("No hay filas en la tabla");
 }
   
}

$('#GuardarDatos').click(function ()
{
    ValidarData();
});