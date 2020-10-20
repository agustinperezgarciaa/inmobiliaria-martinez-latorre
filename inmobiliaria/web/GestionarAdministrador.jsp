<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
   //Generador de la secci&oacute;n de gestionar administrador
   AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
   abd.sesionIniciada(session);
   Sesion s = new Sesion ();
   String username = s.getNombreUsuario(session);
   try{
        abd.iniciarTransaccion();
        GenerarHTMLGesAdministrador html=new GenerarHTMLGesAdministrador();
        out.print(html.generarHTMLHead("Gestionar Administrador"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTML_ABM_Admin(abd,request,session));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>