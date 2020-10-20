<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.ClientePosible"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se elimina una solicitud de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idClieP = Long.parseLong(request.getParameter("eliminarSolicitud"));
        ClientePosible clieP = (ClientePosible) abd.buscarPorId(new ClientePosible(), idClieP);
        abd.eliminar(clieP);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("Admin.jsp");
%>