<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n tasaciones
    Sesion cs = new Sesion ();
    String username = cs.chequeoSesion(session);
    GenerarHTMLTasaciones html=new GenerarHTMLTasaciones();
    out.print(html.generarHTMLHeadUno("Tasaciones de Prop."));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFooterIn());
%>