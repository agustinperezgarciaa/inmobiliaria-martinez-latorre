<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
    //Generador de la secci&oacute;n de gestionar propietario
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        String flag= (String) request.getParameter("verdadero");//request(true,false) que viene de gestionarAltaInmueble.jsp
        String valorSelect=(String) request.getParameter("selecPropietario");//request que viene de gestionarAltaInmueble.jsp
        abd.iniciarTransaccion();
        GenerarHTMLGesPropietario html=new GenerarHTMLGesPropietario(flag,valorSelect);
        out.print(html.generarHTMLHead("Gestionar Propietario"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTML_ABM_Prop(abd,request));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
   }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>