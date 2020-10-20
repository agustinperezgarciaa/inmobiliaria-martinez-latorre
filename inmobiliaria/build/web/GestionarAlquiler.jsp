<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
   //Generador de la secci&oacute;n de gestionar alquiler
   AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
   abd.sesionIniciada(session);
   Sesion s = new Sesion ();
   String username = s.getNombreUsuario(session);
   try{
       abd.iniciarTransaccion();
       GenerarHTMLGesAlquiler html=new GenerarHTMLGesAlquiler();
       out.print(html.generarHTMLHead("Gestionar Alquiler"));
       out.print(html.generarHTMLMenu(username));
       out.print(html.generarHTMLMainContent());
       out.print(html.generarHTML_ABM_Alq(abd,request));
       out.print(html.generarHTMLFooter());
       out.print(html.generarHTMLFinal()); 
       abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>