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
       GenerarHTMLGesVenta html=new GenerarHTMLGesVenta();
       GestionarVenta html2=new GestionarVenta();
       out.print(html.generarHTMLHead("Gestionar Venta"));
       out.print(html.generarHTMLMenu(username));
       out.print(html.generarHTMLMainContent());
       out.print(html2.altaVen(abd));
       out.print(html.generarHTMLFooter());
       out.print(html.generarHTMLFinal()); 
       abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>