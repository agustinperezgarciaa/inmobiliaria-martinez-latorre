<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%>
<%
    GenerarHTMLClientePosible html=new GenerarHTMLClientePosible();
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    out.print(html.generarHTMLHead("Cliente Posible"));
    out.print(html.generarHTMLMenu(username));
    //out.print(html.GenerarHTMLGenerarColumn1());
    //out.print(html.GenerarHTMLGenerarColumn8());
    out.print(html.generarHTMLFooter());
    out.print(html.generarHTMLFinal());        

%>