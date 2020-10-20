<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Persistencia.*"%>
<%@page import="Util.*"%>
<%
   //Generador de la secci&oacute;n de loguin
   AccesoBD abd = new AccesoBD();
   abd.sesionIniciada(session);
   Sesion s = new Sesion ();
   String visibility = s.visCartel(session);
   String username = s.getNombreUsuario(session);
   GenerarHTMLLogin html=new GenerarHTMLLogin();
   out.print(html.generarHTMLHead("Login"));
   out.print(html.generarHTMLMenu(username));
   out.print(html.generarHTMLMain_content(request,visibility));
   out.print(html.generarHTMLFooter2());
   out.print(html.generarHTMLFinal());    
%>