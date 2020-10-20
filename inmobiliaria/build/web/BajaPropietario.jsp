<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Propietario"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se elimina un propietario de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idProp = Long.parseLong(request.getParameter("eliminarPropietario"));
        Propietario prop = (Propietario) abd.buscarPorId(new Propietario(), idProp);
        abd.eliminar(prop);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarPropietario.jsp");
%>