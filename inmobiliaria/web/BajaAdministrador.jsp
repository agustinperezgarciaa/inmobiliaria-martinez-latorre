<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Administrador"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se elimina un administrador de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idAdmin = Long.parseLong(request.getParameter("eliminarAdministrador"));
        Administrador admin = (Administrador) abd.buscarPorId(new Administrador(), idAdmin);
        abd.eliminar(admin);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarAdministrador.jsp"); 
%>