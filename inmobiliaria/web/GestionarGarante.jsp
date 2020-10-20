<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
    //Generador de la secci&oacute;n de gestionar garante
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        String flag= (String) request.getParameter("opt");//request(true,false) que viene de gestionarAltaAlquiler.jsp
        String valorSelect=(String) request.getParameter("selecGarante");//request que viene de gestionarAltaAlquier.jsp
        abd.iniciarTransaccion();
        GenerarHTMLGesGarante html=new GenerarHTMLGesGarante(flag,valorSelect);
        out.print(html.generarHTMLHead("Gestionar Garante"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTML_ABM_Gar(abd,request,session));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>