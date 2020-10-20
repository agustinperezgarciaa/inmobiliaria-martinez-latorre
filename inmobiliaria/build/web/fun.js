//Funciones varias

function getIdInm(idInmueble){
    form=document.getElementById("formIdInmueble");
    input=document.getElementById("idInmueble");
    input.value=idInmueble;
    form.submit();
}

function formClientePosible(){
    form=document.getElementById("formIDClientePosible");
    form.submit();
};

function altaClientePosible(){
    form=document.getElementById("formIDAltaProp");
    form.submit();
};

function altaSolicitud(idSolicitud){
    form=document.getElementById("FormAltSol");
    input=document.getElementById("agregSol");
    input.value=idSolicitud;
    form.submit();
};

function elimAdministrador(idAdmin){
    if (confirm('¿Esta seguro que desea eliminar este Administrador?')){
             form= document.getElementById("FormAdminElim");
             input=document.getElementById("elimAdmin");
             input.value=idAdmin;
             form.submit();
    };
};

function editAdministrador(idAdmin){
     if (confirm('¿Esta seguro que desea editar este Administrador?')){
             form= document.getElementById("FormAdminEdit");
             input=document.getElementById("editAdmin");
             input.value=idAdmin;
             form.submit();
         };
};      

function elimGarante(idGar){
    if (confirm('¿Esta seguro que desea eliminar este Garante?')){
        form = document.getElementById("FormGarElim");
        input = document.getElementById("elimGar");
        input.value=idGar;
        form.submit();
    };
};

function editGarante(idGar){
     if (confirm('¿Esta seguro que desea editar este Garante?')){
             form= document.getElementById("FormGarEdit");
             input=document.getElementById("editGar");
             input.value=idGar;
             form.submit();
         };
};

function elimCliente(idClie){
    if (confirm('¿Esta seguro que desea eliminar este Cliente?')){
             form= document.getElementById("FormClieElim");
             input=document.getElementById("elimCLie");
             input.value=idClie;
             form.submit();
    };
};

function editCliente(idClie){
     if (confirm('¿Esta seguro que desea editar este Cliente?')){
             form= document.getElementById("FormClieEdit");
             input=document.getElementById("editClie");
             input.value=idClie;
             form.submit();
         };
};

function elimInmueble(idInm){
    if (confirm('¿Esta seguro que desea eliminar este Inmueble?')){
             form= document.getElementById("FormInmElim");
             input=document.getElementById("elimInm");
             input.value=idInm;
             form.submit();
    };
};

function editInmueble(idInm){
     if (confirm('¿Esta seguro que desea editar este Inmueble?')){
             form= document.getElementById("FormInmEdit");
             input=document.getElementById("editInm");
             input.value=idInm;
             form.submit();
         };
};

function elimPropietario(idProp){
    if (confirm('¿Esta seguro que desea eliminar este Propietario?')){
             form= document.getElementById("FormPropElim");
             input=document.getElementById("elimProp");
             input.value=idProp;
             form.submit();
    };
};

function editPropietario(idProp){
     if (confirm('¿Esta seguro que desea editar este Propietario?')){
             form= document.getElementById("FormPropEdit");
             input=document.getElementById("editProp");
             input.value=idProp;
             form.submit();
         };
};

function elimVenta(idVen){
    if (confirm('¿Esta seguro que desea eliminar esta Venta?')){
             form= document.getElementById("FormVenElim");
             input=document.getElementById("elimVen");
             input.value=idVen;
             form.submit();
    };
};

function editVenta(idVen){
     if (confirm('¿Esta seguro que desea editar esta Venta?')){
             form= document.getElementById("FormVenEdit");
             input=document.getElementById("editVen");
             input.value=idVen;
             form.submit();
         };
};

function elimAlquiler(idAlq){
    if (confirm('¿Esta seguro que desea eliminar este Alquiler?')){
             form= document.getElementById("FormAlqElim");
             input=document.getElementById("elimAlq");
             input.value=idAlq;
             form.submit();
    };
};

function editAlquiler(idAlq){
     if (confirm('¿Esta seguro que desea editar este Alquiler?')){
             form= document.getElementById("FormAlqEdit");
             input=document.getElementById("editAlq");
             input.value=idAlq;
             form.submit();
         };
};

function elimSolicitud(idSol){
    if (confirm('¿Esta seguro que desea eliminar esta Solicitud?')){
             form= document.getElementById("FormSolElim");
             input=document.getElementById("elimSol");
             input.value=idSol;
             form.submit();
    };
};

//retorna opcion del select de GenerarHTMLNuevaPropiedad.java-Linea 76
function selecPropietarioo(){
  selec=document.getElementById("selecPropietario");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarPropietario.jsp?selecPropietario=AP&verdadero=verdadero";
        //window.open("GestionarPropietario.jsp?selecPropietario=AP&verdadero=verdadero","terceraPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("GestionarPropietario.jsp?selecPropietario=LP&verdadero=verdadero","terceraPagina", "height=800,width=975" );
    }
}

function selecInmuebleeDeAlq(){
  selec=document.getElementById("selecInmueble");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarAltaInmueble.jsp?opt=alq";
        //window.open("GestionarAltaInmueble.jsp?verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("Admin.jsp?flagg=verdadero","segundaPagina", "height=800,width=975" );
    }
}

function selecInmuebleeDeVen(){
  selec=document.getElementById("selecInmueble");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarAltaInmueble.jsp?opt=ven";
        //window.open("GestionarAltaInmueble.jsp?verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("Admin.jsp?flagg=verdadero","segundaPagina", "height=800,width=975" );
    }
}

function selecClienteeDeAlq(){
  selec=document.getElementById("selecCliente");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarCliente.jsp?selecCliente=AC&opt=alq";
        //window.open("GestionarCliente.jsp?selecCliente=AC&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("GestionarCliente.jsp?selecCliente=LC&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }
}

function selecClienteeDeVen(){
  selec=document.getElementById("selecCliente");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarCliente.jsp?selecCliente=AC&opt=ven";
        //window.open("GestionarCliente.jsp?selecCliente=AC&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("GestionarCliente.jsp?selecCliente=LC&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }
}

function selecGarantee(){
  selec=document.getElementById("selecGarante");
  seleccion=selec.options[selec.selectedIndex].value;
  if (seleccion=="nuevo"){
        location.href="GestionarGarante.jsp?selecGarante=AG&opt=alq";
        //window.open("GestionarGarante.jsp?selecGarante=AG&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }else if(seleccion=="lista"){
        window.open("GestionarGarante.jsp?selecGarante=LG&verdadero=verdadero","segundaPagina", "height=800,width=975" );
    }
}

function solicitudess(){
   form=document.getElementById("solicitudes");
   input=document.getElementById("flag");
   input.value="Solicitudes: ";
   form.submit();
}

function formularioAdmin(f) { 
    
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('la direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }    

    if (f.paginaWeb.value  == '') { 
        alert ('La pagina web esta vacía'); 
        f.paginaWeb.focus(); 
        return false; 
    }
    if (f.usuario.value  == '') { 
        alert ('El usuario esta vacío'); 
        f.usuario.focus(); 
        return false; 
    }
    if (f.mail.value  == '') { 
        alert ('El mail esta vacío'); 
        f.mail.focus(); 
        return false; 
    }
    
    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    
    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }
    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
    if (f.passUno.value  == '') { 
        alert ('La contraseña esta vacía'); 
        f.passUno.focus(); 
        return false; 
    }
    if (f.passDos.value  == '') { 
        alert ('La reiteracion del password esta vacía'); 
        f.passDos.focus(); 
        return false; 
    }
    if (f.passUno.value  != f.passDos.value) { 
        alert ('Los passwords no coinciden'); 
        f.passDos.focus(); 
        return false; 
    }

    if (!((f.passUno.value.length >= 6) && (f.passUno.value.length <= 15))){
	alert ('La clave debe tener entre 6 y 15 caracteres');
        f.passUno.focus(); 
        return false;
    }
    if (!((f.passDos.value.length >= 6) && (f.passDos.value.length <= 15))){
	alert ('La clave debe tener entre 6 y 15 caracteres');
        f.passDos.focus(); 
        return false;
    }
    return confirm('¿Confirma que desea crear este administrador?'); 


}


function formularioEditAdmin(f) { 
    
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('la direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }    
    if (f.paginaWeb.value  == '') { 
        alert ('La pagina web esta vacía'); 
        f.paginaWeb.focus(); 
        return false; 
    }
    if (f.usuario.value  == '') { 
        alert ('El usuario esta vacío'); 
        f.usuario.focus(); 
        return false; 
    }
    if (f.mail.value  == '') { 
        alert ('El mail esta vacío'); 
        f.mail.focus(); 
        return false; 
    }
    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
    confirm('¿Modificar administrador? (debera reingresar en el sistema para ver los cambios)');
    
    
} 

function formularioCambiaContra(f){
    if (f.passUno.value  == '') { 
        alert ('La contraseña esta vacía'); 
        f.passUno.focus(); 
        return false; 
    }
    if (f.passDos.value  == '') { 
        alert ('La reiteracion del password esta vacía'); 
        f.passDos.focus(); 
        return false; 
    }
    if (f.passUno.value  != f.passDos.value) { 
        alert ('Los passwords no coinciden'); 
        f.passDos.focus(); 
        return false; 
    }
    if (!((f.passUno.value.length >= 6) && (f.passUno.value.length <= 15))){
	alert ('La clave debe tener entre 6 y 15 caracteres');
        f.passUno.focus(); 
        return false;
    }
    if (!((f.passDos.value.length >= 6) && (f.passDos.value.length <= 15))){
	alert ('La clave debe tener entre 6 y 15 caracteres');
        f.passDos.focus(); 
        return false;
    }
    confirm('¿Modificar contraseña? (debera reingresar en el sistema para ver los cambios)');
}

function formularioClie(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }

    return confirm('¿Confirma que desea crear este cliente?'); 
}

function formularioEditClie(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }

    return confirm('¿Confirma que desea modificar este cliente?'); 
}


function formularioCliePos(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }

    return alert('Datos enviados satisfactoriamente, en brevedad nos comunicaremos con usted.'); 
}

function formularioProp(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
    return confirm('¿Confirma que desea crear este propietario?'); 
}

function formularioEditProp(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
    return confirm('¿Confirma que desea modificar este propietario?'); 
}

function formularioGara(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
        if (f.lugarTrabajo.value  == '') { 
        alert ('El lugar de trabajo esta vacío'); 
        f.lugarTrabajo.focus(); 
        return false; 
    }
        if (f.profesion.value  == '') { 
        alert ('La profesion esta vacía'); 
        f.profesion.focus(); 
        return false; 
    }
        if (f.nacionalidad.value  == '') { 
        alert ('La nacionalidad esta vacía'); 
        f.nacionalidad.focus(); 
        return false; 
    }

    return confirm('¿Confirma que desea crear este garante?'); 
}

function formularioEditGara(f) { 
  
    if (f.nombre.value   == '') { 
        alert ('El nombre esta vacío');  
        f.nombre.focus(); 
        return false; 
    } 
    if (f.apellido.value  == '') { 
        alert ('El apellido esta vacío'); 
        f.apellido.focus(); 
        return false; 
    }
    if (f.dni.value  == '') { 
        alert ('El dni esta vacío'); 
        f.dni.focus(); 
        return false; 
    }

    if (f.direccion.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccion.focus(); 
        return false; 
    }
    if (f.mail.value   == '') { 
        alert ('El mail esta vacío');  
        f.mail.focus(); 
        return false; 
    } 

    var pos = f.mail.value.indexOf("@");
    if (pos == -1) {
        alert('Mail invalido, debe contener un "@"'); 
        f.mail.focus();
        return false;
    }
    if ((pos == 0) || (pos == f.mail.value.length-1)) {
        alert('Mail invalido, debe al menos un caracter antes y después del "@"'); 
        f.mail.focus();
        return false;
    }
    var pos2 = f.mail.value.lastIndexOf(".");
    if ((pos2 < pos+1) || pos2 == f.mail.value.length-1) {
        alert('Mail invalido, debe tener un punto después del "@" y alguna letra antes y despues del punto'); 
        f.mail.focus();
        return false;
    }
    for (i=0; i<f.mail.value.length; i++){
        if (f.mail.value.charAt(i) == " ") {
            alert('Mail invalido, no debe tener espacios en blanco por el medio'); 
            f.mail.focus();
            return false;
        }
    }

    if (f.telMovil.value  == '') { 
        alert ('El telefono movil esta vacío'); 
        f.telMovil.focus(); 
        return false; 
    }

    if (f.fechaNac.value  == '') { 
        alert ('La fecha de nacimiento esta vacía'); 
        f.fechaNac.focus(); 
        return false; 
    }   
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fechaNac.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fechaNac.focus(); 
        return false; 
    }
    if (f.localidad.value  == '') { 
        alert ('La localidad esta vacía'); 
        f.localidad.focus(); 
        return false; 
    }
        if (f.lugarTrabajo.value  == '') { 
        alert ('El lugar de trabajo esta vacío'); 
        f.lugarTrabajo.focus(); 
        return false; 
    }
        if (f.profesion.value  == '') { 
        alert ('La profesion esta vacía'); 
        f.profesion.focus(); 
        return false; 
    }
        if (f.nacionalidad.value  == '') { 
        alert ('La nacionalidad esta vacía'); 
        f.nacionalidad.focus(); 
        return false; 
    }

    return confirm('¿Confirma que desea modificar este garante?'); 
}


function formularioAlq (f){
    if (f.fecha.value  == '') { 
        alert ('La fecha esta vacía'); 
        f.fecha.focus(); 
        return false; 
    }      
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fecha.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fecha.focus(); 
        return false; 
    }
    if (f.monto.value  == '') { 
        alert ('El monto esta vacío'); 
        f.monto.focus(); 
        return false; 
    }
    if (isNaN(f.monto.value)){
        alert ('El monto debe contener unicamente numeros'); 
        f.monto.focus(); 
        return false; 
    }
    if (f.ClienteAlquiler.options[f.ClienteAlquiler.selectedIndex].value == "vacio") { 
        alert ('Debe seleccionar un cliente'); 
        f.ClienteAlquiler.focus(); 
        return false; 
    }
    if (f.InmuebleAlquiler.options[f.InmuebleAlquiler.selectedIndex].value == "vacio") { 
        alert ('Debe seleccionar un inmueble'); 
        f.InmuebleAlquiler.focus(); 
        return false; 
    }
    if (f.GaranteAlquiler.options[f.GaranteAlquiler.selectedIndex].value == "vacio") { 
        alert ('Debe seleccionar un garante'); 
        f.GaranteAlquiler.focus(); 
        return false; 
    }
    return confirm ('¿Confirma que desea crear este alquiler?'); 
}

function formularioEditAlq (f){
    if (f.fecha.value  == '') { 
        alert ('La fecha esta vacía'); 
        f.fecha.focus(); 
        return false; 
    }    
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fecha.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fecha.focus(); 
        return false; 
    }
    if (f.monto.value  == '') { 
        alert ('El monto esta vacío'); 
        f.monto.focus(); 
        return false; 
    }
    if (isNaN(f.monto.value)){
        alert ('El monto debe contener unicamente numeros'); 
        f.monto.focus(); 
        return false; 
    }
    return confirm ('¿Confirma que desea modificar este alquiler?'); 
}


function formularioVen (f){
    if (f.fecha.value  == '') { 
        alert ('La fecha esta vacía'); 
        f.fecha.focus(); 
        return false; 
    }        
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fecha.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fecha.focus(); 
        return false; 
    }
    if (f.monto.value  == '') { 
        alert ('El monto esta vacío'); 
        f.monto.focus(); 
        return false; 
    }
    if (isNaN(f.monto.value)){
        alert ('El monto debe contener unicamente numeros'); 
        f.monto.focus(); 
        return false; 
    }
    if (f.idInm_Venta.value  == '') { 
        alert ('El id del inmueble esta vacío'); 
        f.idInm_Venta.focus(); 
        return false; 
    }

    if (f.idClie_Venta.value  == '') { 
        alert ('El id del cliente esta vacío'); 
        f.idClie_Venta.focus(); 
        return false; 
    
    }
    return confirm ('¿Confirma que desea crear esta venta?'); 
}

function formularioEditVen (f){
    if (f.fecha.value  == '') { 
        alert ('La fecha esta vacía'); 
        f.fecha.focus(); 
        return false; 
    }       
    var ExpRegDate = /^(0?[1-9]|[12][0-9]|3[01])[\/](0?[1-9]|1[012])[/\\/](19|20)\d{2}$/;
    if (!ExpRegDate.test(f.fecha.value) ){
        alert ('El formato de la fecha de nacimiento es incorrecto, debe ser dd/mm/aaaa'); 
        f.fecha.focus(); 
        return false; 
    }
    if (f.monto.value  == '') { 
        alert ('El monto esta vacío'); 
        f.monto.focus(); 
        return false; 
    }
    if (isNaN(f.monto.value)){
        alert ('El monto debe contener unicamente numeros'); 
        f.monto.focus(); 
        return false; 
    }

    return confirm ('¿Confirma que desea modificar esta venta?'); 
}

function formularioInm (f){
    
    if (f.direccionInmueble.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccionInmueble.focus(); 
        return false; 
    }        
    if (f.precioInmueble.value  == '') { 
        alert ('El precio esta vacío'); 
        f.precioInmueble.focus(); 
        return false; 
    }
    if (isNaN(f.precioInmueble.value)){
        alert ('El precio debe contener unicamente numeros'); 
        f.precioInmueble.focus(); 
        return false; 
    }
    if (f.barrio.options[f.barrio.selectedIndex].value == "vacio") { 
        alert ('El barrio esta vacío'); 
        f.barrio.focus(); 
        return false; 
    }

    if (f.tipoInmueble.options[f.tipoInmueble.selectedIndex].value == "vacio") { 
        alert ('El tipo del inmueble esta vacío'); 
        f.tipoInmueble.focus(); 
        return false; 
    }
    if (f.operacionInmueble.options[f.operacionInmueble.selectedIndex].value == "vacio") { 
        alert ('La operacion del inmueble esta vacía'); 
        f.operacionInmueble.focus(); 
        return false; 
    }
    if (f.disponibilidadInmueble.options[f.disponibilidadInmueble.selectedIndex].value == "vacio") { 
        alert ('No se ha establecido si el inmueble esta disponible o no'); 
        f.disponibilidadInmueble.focus(); 
        return false; 
    }
    if (f.imgAdministracion.value  == '') { 
        alert ('La imagen de administracion esta vacía'); 
        f.imgAdministracion.focus(); 
        return false; 
    }
    if (f.imgBuscador.value  == '') { 
        alert ('La imagen del buscador esta vacía'); 
        f.imgBuscador.focus(); 
        return false; 
    }
    if (f.imgDetalleGrande.value  == '') { 
        alert ('La imagen de detalle grande esta vacía'); 
        f.imgDetalleGrande.focus(); 
        return false; 
    }
    if (f.imgDetalle1.value  == '') { 
        alert ('La imagenen de detalle 1 esta vacía'); 
        f.imgDetalle1.focus(); 
        return false; 
    }
    if (f.imgDetalle2.value  == '') { 
        alert ('La imagenen de detalle 2 esta vacía'); 
        f.imgDetalle2.focus(); 
        return false; 
    }
    if (f.imgDetalle3.value  == '') { 
        alert ('La imagenen de detalle 3 esta vacía'); 
        f.imgDetalle3.focus(); 
        return false; 
    }
    if (f.imgDetalle4.value  == '') { 
        alert ('La imagenen de detalle 4 esta vacía'); 
        f.imgDetalle4.focus(); 
        return false; 
    }
        if (f.descripcionInmueble.value  == '') { 
        alert ('La descripcion esta vacia'); 
        f.descripcionInmueble.focus(); 
        return false; 
    }
   
    return confirm ('¿Confirma que desea crear este inmueble?'); 
}

function formularioEditInm (f){
    
    if (f.direccionInmueble.value  == '') { 
        alert ('La direccion esta vacía'); 
        f.direccionInmueble.focus(); 
        return false; 
    }        
    if (f.precioInmueble.value  == '') { 
        alert ('El precio esta vacío'); 
        f.precioInmueble.focus(); 
        return false; 
    }
    if (isNaN(f.precioInmueble.value)){
        alert ('El precio debe contener unicamente numeros'); 
        f.precioInmueble.focus(); 
        return false; 
    }
    if (f.barrio.options[f.barrio.selectedIndex].value == "vacio") { 
        alert ('El barrio esta vacío'); 
        f.barrio.focus(); 
        return false; 
    }

    if (f.tipoInmueble.options[f.tipoInmueble.selectedIndex].value == "vacio") { 
        alert ('El tipo del inmueble esta vacío'); 
        f.tipoInmueble.focus(); 
        return false; 
    }
    if (f.operacionInmueble.options[f.operacionInmueble.selectedIndex].value == "vacio") { 
        alert ('La operacion del inmueble esta vacía'); 
        f.operacionInmueble.focus(); 
        return false; 
    }
    if (f.disponibilidadInmueble.options[f.disponibilidadInmueble.selectedIndex].value == "vacio") { 
        alert ('No se ha establecido si el inmueble esta disponible o no'); 
        f.disponibilidadInmueble.focus(); 
        return false; 
    }
    if (f.descripcionInmueble.value  == '') { 
        alert ('La descripcion esta vacia'); 
        f.descripcionInmueble.focus(); 
        return false; 
    }
   
    return confirm ('¿Confirma que desea modificar este inmueble?'); 
}


function formularioGar (f){
    if (f.GaranteAlquiler.value == "vacio") { 
        alert ('Debe seleccionar un garante.'); 
        f.GaranteAlquiler.focus(); 
        return false; 
    }  
        return confirm ('¿Confirma que desea concretar esta solicitud?');
    }
    

function formularioConfiguracionBase (f){
    if (f.usu.value == '') { 
        alert ('Debe ingresar un usuario.'); 
        f.usu.focus(); 
        return false; 
    }  
    if (f.contr.value == '') { 
        alert ('Debe ingresar una contraseña.'); 
        f.contr.focus(); 
        return false; 
    }
        return confirm ('¿Ha ingresado los datos correctamente?');
}
          