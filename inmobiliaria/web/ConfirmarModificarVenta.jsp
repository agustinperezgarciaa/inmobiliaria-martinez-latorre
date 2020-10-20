<%@page import="java.util.Date"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se recuperan los datos de una venta, se modifican y se guardan en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idVen = Long.parseLong(request.getParameter("id"));
        String username= (String)session.getAttribute("username");
        String fecha=(String)request.getParameter("fecha");
        Long monto=Long.parseLong(request.getParameter("monto"));
        Long  idClie= Long.parseLong(request.getParameter("ClienteVenta"));
        Long  idInm= Long.parseLong(request.getParameter("InmuebleVenta"));
        String condicion = "id == "+idClie;
        out.println(username);
        Cliente c =(Cliente)abd.buscarPorCond(new Cliente(), condicion);
        String condicion2 = "id == "+idInm;
        Inmueble i =(Inmueble)abd.buscarPorCond(new Inmueble(), condicion2);
        String condicion1= "usuario == '"+username+"'";
        Administrador a =(Administrador)abd.buscarPorCond(new Administrador(),condicion1);
        Modificar m = new Modificar();
        String diaArray[] = fecha.split("/");
        Date f = new Date();
        int dia = Integer.parseInt(diaArray[0]);
        int mes = Integer.parseInt(diaArray[1]);
        int anio = Integer.parseInt(diaArray[2]);
        f.setDate(dia);
        f.setMonth(mes-1);
        f.setYear(anio-1900);
        Venta ven = (Venta) abd.buscarPorId(new Venta(), idVen);
        m.ModVenta(ven, f, c, i, a, monto);
         abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarVenta.jsp");     
%>