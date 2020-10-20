<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de Siete pasos imprescindibles antes de comprar una casa usada
    Sesion cs = new Sesion ();
    String username = cs.chequeoSesion(session);
    GenerarHTMLCasaUsada html=new GenerarHTMLCasaUsada();
    out.print(html.generarHTMLHeadUno("Casa Usada"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());
%>