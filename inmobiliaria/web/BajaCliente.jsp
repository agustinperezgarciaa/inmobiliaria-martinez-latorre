<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se elimina un cliente de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idClie = Long.parseLong(request.getParameter("eliminarCliente"));
        Cliente clie = (Cliente) abd.buscarPorId(new Cliente(), idClie);
        abd.eliminar(clie);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarCliente.jsp");         
%>