<%@page import="Vista.*"%>
<%@page import="Entidad.Inmueble"%>
<%@page import="Entidad.Imagen"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de secci&oacute;n administrador
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    try{
        //Inicializaci&oacute;nDeLaTransacci&oacute;n;
        abd.iniciarTransaccion();
        Long AG= Long.parseLong(request.getParameter("agregarSolicitud"));//request de GestionarListasInmueble
        GenerarHTMLAltaSolicitud html = new GenerarHTMLAltaSolicitud();
        out.print(html.generarHTMLHead("Detalles Solicitud"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTMLAddTab(AG,abd));
        out.print(html.generarHTMLFinal());
        out.print(html.generarHTMLFooterIn());
        //ConcretaLaTransacci&oacute;n;
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>