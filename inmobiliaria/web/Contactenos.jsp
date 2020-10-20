<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%@page import="Util.*"%> 

<%
    //Generador de la secci&oacute;n de contacto
    GenerarHTMLContacto html=new GenerarHTMLContacto();
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    out.print(html.generarHTMLHead("Cont&aacute;ctenos"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.GenerarHTMLGenerarColumn1());
    out.print(html.GenerarHTMLGenerarColumn8());
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());        

%>