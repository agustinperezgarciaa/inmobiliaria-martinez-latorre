<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Garante"%>
<%@page import="Persistencia.AccesoBD"%>
<%  
    //Se elimina un garante de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idGar = Long.parseLong(request.getParameter("eliminarGarante"));
        Garante Gar = (Garante) abd.buscarPorId(new Garante(), idGar);
        abd.eliminar(Gar);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarGarante.jsp");         
%>