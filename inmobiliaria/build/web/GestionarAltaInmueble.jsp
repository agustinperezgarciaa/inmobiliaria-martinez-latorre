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
        String verdadero= (String) request.getParameter("opt");//request==true sii viene GestionarAlquiler.java
        String valorSelect=(String) request.getParameter("selecInmueble");
        GenerarHTMLNuevaPropiedad html=new GenerarHTMLNuevaPropiedad(verdadero);
        out.print(html.generarHTMLHead("Nueva Propiedad"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTMLAddTab(abd));
        out.print(html.generarHTMLFooterIn());
        out.print(html.generarHTMLFinal());
        abd.concretarTransaccion();
   }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>