   /* 
 * En este file .Js vamos a validar el form de Registro del estudiante 
 * Para esto creamos una funcion encargada de validar. 
 * Retorna un valor booleano. 
 */
 

function ValidarForm()
{
    
    
/*
 * Definiremos las variables JS , 
 * pero en este caso vamos a obtener todos los valores de los campos de texto. 
 */    
    
    let NumeroDeDocumento, FechaDeNacimiento, MunicipioDeNacimiento, PrimerApellido,
    SegundoApellido, PrimerNombre, SegundoNombre, Direccion, Telefono,MunicipioActual, 
    Barrio; 
    
            
    /*
     * En esta parte obtenemos los valores de los campos de texto del formulario 
     */
    
     
    
    
    NumeroDeDocumento = document.getElementById("numdocumento").value;
    FechaDeNacimiento= document.getElementById("fecha-nac").value;
    MunicipioDeNacimiento= document.getElementById("mun-nacimiento").value;
    PrimerApellido= document.getElementById("PrimerApellido").value;
    SegundoApellido= document.getElementById("SegundoApellido").value;
    PrimerNombre = document.getElementById("PrimerNombre").value;
    SegundoNombre=  document.getElementById("SegundoNombre").value;
    Direccion= document.getElementById("Direccion").value;
    Telefono = document.getElementById("Telefono").value; 
    MunicipioActual= document.getElementById("municipio-actual").value;
    Barrio= document.getElementById("Barrio").value;
    
   
    
    /* 
     * En esta parte de abajo definiremos las variables JS de las listas desplegables
     * 
     */
    
    let TipoDeDocumento, Genero, DepartamentoDeNacimiento,DepartamentoActual, Acudiente, 
    SitioPoblacional, Curso, Sede,EstudianteNuevo, AñoIngreso, PagarMatricula; 
    
    
    /* 
     * Luego obtenermos los valores de las listas desplegables del formulario 
     */
    
 
    
    TipoDeDocumento=  document.getElementById("TipoDeDocumento").value;
    Genero =  document.getElementById("Genero").value;
    DepartamentoDeNacimiento =  document.getElementById("DepDeNacimiento").value;
    DepartamentoActual =  document.getElementById("DepActual").value;
    Acudiente =  document.getElementById("Acudiente").value; 
    SitioPoblacional =  document.getElementById("SitioPoblacional").value;
    Curso =  document.getElementById("Curso").value;
    Sede =  document.getElementById("Sede").value; 
    AñoIngreso =  document.getElementById("AñoIngreso").value; 
 
    
    
    
    
    /*
     * En esta parte vamos a evaluar los campos del formulario
     * 1. En el primer If se evalua si los campos de texto están vacios  
     * 2. Listas desplegables que se encuentran vacias  
     * 3. Seguido de esto, en el otro if evaluamos mediante la funcion IsNaN 
     * si en los campos del Numero de identificación y el telefono hay caracteres
     * 4.Evaluamos si hay campos que sobrepasan los 30 caracteres .
     * 5. Evaluamos si el municipio de nacimiento y el municipio actual superan los 
     * 50  caracteres.
     *         
     */ 
    
    
    if(NumeroDeDocumento === "" || FechaDeNacimiento ===  "" || MunicipioDeNacimiento === "" || PrimerApellido === "" || SegundoApellido === ""
       || PrimerNombre === "" ||   SegundoNombre === ""  || Direccion === "" || Telefono === "" || MunicipioActual === ""  || Barrio === "" )
   {
       alert("¡Todos los campos son obligatorios!"); 
       return false; 
   } 
   else if( TipoDeDocumento === "0" || Genero === "0" || DepartamentoDeNacimiento === "0"  || DepartamentoActual === "0"
           || Acudiente === "0" || SitioPoblacional === "0" || Curso === "0" || Sede === "0"  || AñoIngreso === "0" )
   {
       alert("¡ Hay listas desplegables que no han sido seleccionadas!"); 
       return false; 
   }   
   
   else if( isNaN(NumeroDeDocumento) === true || isNaN(Telefono) ===  true )
   {
       alert("¡El número de documento y el telefono solo pueden contener Numeros!"); 
       return false; 
   } 
    else if ( NumeroDeDocumento.length > 30 || PrimerApellido.length > 30 || SegundoApellido.length > 30
            || PrimerNombre.length > 30 || SegundoNombre.length > 30 || Telefono.length > 30 || Barrio.length > 30 )
   {
       alert("Hay campos en el formulario que no pueden superar los 30 caracteres!"); 
       return false; 
   }
   else if( MunicipioDeNacimiento.length > 50 || MunicipioActual.length  > 50 )
   {
       alert("¡ El municipio actual y el municipio de nacimiento no pueden superar los 50 caracteres! "); 
       return false; 
   }
    
    
    
    
 
    
    
    
    
}

