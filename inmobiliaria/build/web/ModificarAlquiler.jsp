<%@page import="Vista.*"%>
<%@page import="Entidad.Alquileres"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar alquiler
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        Long idAlq = Long.parseLong(request.getParameter("editarAlquiler"));
        Alquileres alq = (Alquileres) abd.buscarPorId(new Alquileres(), idAlq);
        GenerarHTMLGesEditorAlquiler html=new GenerarHTMLGesEditorAlquiler();
        out.print(html.generarHTMLHead("Gestionar Alquiler"));
        out.print(html.generarHTMLMenu(username));
        //out.print(html.generarHTMLMainContent());
        out.print(html.generarHTMLMainContent(alq,abd));
        out.print(html.generarHTMLFooter());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    // response.sendRedirect("GestionarAdministrador.jsp");
%>
