<%@page import="Vista.*"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar cliente
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        Long idClie = Long.parseLong(request.getParameter("editarCliente"));
        Cliente clie = (Cliente) abd.buscarPorId(new Cliente(), idClie);
        GenerarHTMLGesEditorCliente html=new GenerarHTMLGesEditorCliente();
        out.print(html.generarHTMLHead("Gestionar Cliente"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(clie));
        out.print(html.generarHTMLFooterIn());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    // response.sendRedirect("GestionarAdministrador.jsp");
%>
