<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
    //Generador de la secci&oacute;n de gestionar cliente
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        String flag= (String) request.getParameter("opt");//Reques ==alq ssi viene de GestionarAlquiler.jsp, ven si viene de GestionarVenta.jsp
        String valorSelect=(String) request.getParameter("selecCliente");//Reques ==(AC;LC) ssi viene de GestionarAlquiler.jsp 
        
        abd.iniciarTransaccion();
        GenerarHTMLGesCliente html = new GenerarHTMLGesCliente(flag,valorSelect);
        out.print(html.generarHTMLHead("Gestionar Cliente"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent());
        out.print(html.generarHTML_ABM_Clien(abd,request));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
   }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>