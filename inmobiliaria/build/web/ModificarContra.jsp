<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Persistencia.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de gestion un nuevo inmueble
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);

    try{
        abd.iniciarTransaccion();
        GenerarHTMLModificarContra html=new GenerarHTMLModificarContra();
        out.print(html.generarHTMLHead("Mofificar contraseña"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTMLAddTab(abd));
        out.print(html.generarHTMLFooterCont());
        out.print(html.generarHTMLFinal());
        abd.concretarTransaccion();
   }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>