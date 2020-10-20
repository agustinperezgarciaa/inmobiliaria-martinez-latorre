<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n nosotros
    Sesion cs = new Sesion ();
    String username = cs.chequeoSesion(session);
    GenerarHTMLNosotros html=new GenerarHTMLNosotros();
    out.print(html.generarHTMLHeadUno("Nosotros"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFinal());
    out.print(html.generarHTMLFooterCont());
%>