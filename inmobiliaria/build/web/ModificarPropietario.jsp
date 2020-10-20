<%@page import="Vista.*"%>
<%@page import="Entidad.Propietario"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar propietario
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        Long idProp = Long.parseLong(request.getParameter("editarPropietario"));
        Propietario prop = (Propietario) abd.buscarPorId(new Propietario(), idProp);
        GenerarHTMLGesEditorPropietario html=new GenerarHTMLGesEditorPropietario();
        out.print(html.generarHTMLHead("Gestionar Propietario"));
        out.print(html.generarHTMLMenu(username));
        //out.print(html.generarHTMLMainContent());
        out.print(html.generarHTMLMainContent(prop));
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
