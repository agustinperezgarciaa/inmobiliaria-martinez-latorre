<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%>
<%@page import ="Persistencia.*"%>
<%@page import ="Util.*"%>
<%
    //Generador de la p&aacute;gina principal
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    GenerarHTMLIndex html= new GenerarHTMLIndex();
    out.print(html.generarHTLMHeadDos("Inmobiliaria Latorre & Asoc."));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLColumnOne());
    out.print(html.genererHTMLSlider());
    out.print(html.generearHTMLColumnfour(abd));
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());
%>