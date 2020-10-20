<%@page import="Vista.*"%>
<%@page import="Entidad.Venta"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar venta
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        Long idVen = Long.parseLong(request.getParameter("editarVenta"));
        Venta ven= (Venta) abd.buscarPorId(new Venta(), idVen);
        GenerarHTMLGesEditorVenta html=new GenerarHTMLGesEditorVenta();
        out.print(html.generarHTMLHead("Gestionar Venta"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(ven,abd));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
%>
