<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de 8 pasos para una mudanza organizada
    Sesion cs = new Sesion ();
    String username = cs.chequeoSesion(session);
    GenerarHTMLMudanza html=new GenerarHTMLMudanza();
    out.print(html.generarHTMLHeadUno("Mudanza"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());
%>