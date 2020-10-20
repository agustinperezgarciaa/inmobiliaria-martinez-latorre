<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.Alquileres"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Entidad.Inmueble"%>
<%
    //Se elimina un alquiler de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idAlq = Long.parseLong(request.getParameter("eliminarAlquiler"));
        Alquileres alq = (Alquileres) abd.buscarPorId(new Alquileres(), idAlq);
        Inmueble in = alq.getAlquilado();
        String disp = "Disponible";
        in.setDisp(disp);
        abd.eliminar(alq);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarAlquiler.jsp");
%>