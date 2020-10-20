<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
   //Generador de la secci&oacute;n de c&oacute;mo es el mercado inmobiliario que se viene
   Sesion s = new Sesion ();
   String username = s.chequeoSesion(session);
    GenerarHTMLInmoFuturo html=new GenerarHTMLInmoFuturo();
    out.print(html.generarHTMLHeadUno("Futuro del mercado Inmobiliario"));
    out.print(html.generarHTMLMenu(username));
    out.print(html.generarHTMLMainContent());
    out.print(html.generarHTMLFooterIn());
    out.print(html.generarHTMLFinal());
%>