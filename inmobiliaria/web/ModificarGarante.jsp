<%@page import="Vista.*"%>
<%@page import="Entidad.Garante"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar garante
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);       
    try{
        abd.iniciarTransaccion();
        Long idGar = Long.parseLong(request.getParameter("editarGarante"));
        Garante gar = (Garante) abd.buscarPorId(new Garante(), idGar);
        GenerarHTMLGesEditorGarante html=new GenerarHTMLGesEditorGarante();
        out.print(html.generarHTMLHead("Gestionar Garante"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(gar));
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
