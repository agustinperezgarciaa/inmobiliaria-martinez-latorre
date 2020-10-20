<%@page import="Vista.*"%>
<%@page import="Entidad.Administrador"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar administrador
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);
    try{
        abd.iniciarTransaccion();
        Long idAdmin = Long.parseLong(request.getParameter("editarAdministrador"));
        Administrador admin = (Administrador) abd.buscarPorId(new Administrador(), idAdmin);
        GenerarHTMLGesEditorAdministrador html=new GenerarHTMLGesEditorAdministrador();
        out.print(html.generarHTMLHead("Gestionar Administrador"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(admin));
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
