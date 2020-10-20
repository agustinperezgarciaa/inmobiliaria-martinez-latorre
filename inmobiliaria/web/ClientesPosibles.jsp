<%@page import="Persistencia.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 
<%
    //Generador del formulario en la cual el cliente debe ingresar sus datos luego de interesarse en un inmueble buscado 
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        long idInmu=Long.parseLong(request.getParameter("idInm"));//Request de GenerarHTMLDetallesProp.java
        GenerarHTMLClientePosible html=new GenerarHTMLClientePosible();
        out.print(html.generarHTMLHead("Clientes Posibles"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(idInmu));
        out.print(html.generarHTMLFinal()); 
        out.print(html.generarHTMLFooterIn());
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>