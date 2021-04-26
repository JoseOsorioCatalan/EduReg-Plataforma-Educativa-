   

function validar()
{
    // Creamos las variables de los campos de texto
    
    
    let NumeroDeDocumento, FechaDeNacimiento, MunicipioDeNacimiento, PrimerApellido,
    SegundoApellido, PrimerNombre, SegundoNombre, Direccion, Telefono,MunicipioActual, 
    Barrio, Correo, Especialidad, Usuario, Contraseña;
    
    // Obtener todos los campos de texto 
     NumeroDeDocumento = document.getElementById("numdocumento").value;
     FechaDeNacimiento = document.getElementById("fecha_nac").value;
     MunicipioDeNacimiento = document.getElementById("mun_nacimiento").value;


    PrimerApellido = document.getElementById("PrimerApellido").value;
    SegundoApellido = document.getElementById("SegundoApellido").value;
    PrimerNombre = document.getElementById("PrimerNombre").value;
    SegundoNombre = document.getElementById("SegundoNombre").value;

     Direccion = document.getElementById("Direccion").value;
     Telefono = document.getElementById("Telefono").value;
     MunicipioActual = document.getElementById("municipio_actual").value;
     Barrio = document.getElementById("Barrio").value;
     Correo = document.getElementById("Correo").value;

     Especialidad = document.getElementById("Especialidad").value;
     Usuario = document.getElementById("Usuario").value;
     Contraseña = document.getElementById("Contra").value;
    
    
    // Creamos las variables de las listas desplegables
    
    let TipoDeDocumento, Genero,DepartamentoDeNacimiento, DepartamentoActual,
    SitioPoblacional, Sede,DocenteNuevo,AñoDeEntrada;
    
    // Obtenemos todas las listas desplegables 
    
    TipoDeDocumento= document.getElementById("TipoDeDocumento").value;
    Genero= document.getElementById("Genero").value;
    DepartamentoDeNacimiento= document.getElementById("DepDeNacimiento").value;
    DepartamentoActual= document.getElementById("DepActual").value;
    SitioPoblacional= document.getElementById("SitioPoblacional").value;
    Sede= document.getElementById("Sede").value;
    AñoDeEntrada= document.getElementById("AñoEntrada").value;
    
     

/*
 *  - Validamos que los campos de texto no estén vacios
 *  - Que el numero de documento y el telefono no contengan caracteres
 *  - Que algunos campos no sobrepasen los 30 caracteres 
 *  - Que las listas desplegables estén correctamente selccionadcas
 *  - Que el usuario y la contraseña no excedan los 20 caracateres 
 *  - Que la contraseña supere los 7 caracteres
 */
    
   
    if (NumeroDeDocumento === "" || FechaDeNacimiento === "" || MunicipioDeNacimiento === "" || PrimerApellido === ""
            || SegundoApellido === "" || PrimerNombre === "" || SegundoNombre === "" || Direccion === "" || Telefono === "" ||
            MunicipioActual === "" || Barrio === "" || Usuario === "" || Contraseña === "", Correo === "")
    {

        alertify.alert("¡Todos los campos son obligatorios!");

        return false;
    } else if (isNaN(NumeroDeDocumento) === true || isNaN(Telefono) === true)
    {
        alertify.alert("¡El número de documento y el telefono solo pueden contener Numeros!");
        return false;
    } else if (NumeroDeDocumento.length > 30 || PrimerApellido.length > 30 || SegundoApellido.length > 30
            || PrimerNombre.length > 30 || SegundoNombre.length > 30 || Telefono.length > 30 || Barrio.length > 30 )
    {
         alertify.alert("Hay campos en el formulario que no pueden superar los 30 caracteres! ");
        return false;
    }
    else if(TipoDeDocumento === "0" || Genero === "0" || DepartamentoDeNacimiento === "0" || 
            DepartamentoActual === "0" || SitioPoblacional === "0" || Sede === "0" || AñoDeEntrada === "0"
            )
    {
       alertify.alert("¡Hay listas desplegables que no han sido seleccionadas!");
        return false; 
    }
    else if( Usuario.length > 20  || Contraseña .length > 20 )
    {
        alertify.alert("¡El Usuario y la Contraseña no deben exceder los 20 caracteres!");
        return false; 
    }
    else if (Contraseña.length < 7  )
    {
        alertify.alert("¡La contraseña tiene que superar los 7 caracteres!");
        return false;
    } 
    else if( MunicipioDeNacimiento.length > 50 || MunicipioActual.length > 50   )
    {
        alertify.alert("¡ El municipio actual y el municipio de nacimiento no pueden superar los 50 caracteres! ")
        return false; 
    }
        
    
    
}

