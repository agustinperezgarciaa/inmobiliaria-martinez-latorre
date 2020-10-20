<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se elimina una venta de la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idVen = Long.parseLong(request.getParameter("eliminarVenta"));
        Venta ven = (Venta) abd.buscarPorId(new Venta(), idVen);
        Inmueble in = ven.getVendido();
        String disp = "Disponible";
        in.setDisp(disp);
        abd.eliminar(ven);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarVenta.jsp");
%>