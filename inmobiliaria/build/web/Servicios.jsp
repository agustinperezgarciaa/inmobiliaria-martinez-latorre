<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n servicios
    Sesion cs = new Sesion ();
    String username = cs.chequeoSesion(session);
    GenerarHTMLServicios html=new GenerarHTMLServicios();
    out.print(html.generarHTMLHeadUno("Servicios"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());
%>