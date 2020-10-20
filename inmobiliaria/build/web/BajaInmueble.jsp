<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Inmueble"%>
<%@page import="Persistencia.AccesoBD"%>
<%    
    //Se elimina un inmueble de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idInm = Long.parseLong(request.getParameter("eliminarInmueble"));
        Inmueble inm = (Inmueble) abd.buscarPorId(new Inmueble(), idInm);
        abd.eliminar(inm);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("Admin.jsp");
%>