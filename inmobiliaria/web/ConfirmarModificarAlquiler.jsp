<%@page import="java.util.Date"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se recuperan los datos de un alquiler, se modifican y se guardan en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        Long idAlq = Long.parseLong(request.getParameter("id"));
        String username= (String)session.getAttribute("username");
        String fecha=(String)request.getParameter("fecha");
        Long monto=Long.parseLong(request.getParameter("monto"));
        Long  clienteAlq= Long.parseLong(request.getParameter("ClienteAlquiler"));
        Long  InmuebleAlq= Long.parseLong(request.getParameter("InmuebleAlquiler"));
        Long GaranteAlq= Long.parseLong(request.getParameter("GaranteAlquiler"));
        String condicion = "id == "+clienteAlq;
        Cliente c =(Cliente)abd.buscarPorCond(new Cliente(), condicion);

        String condicion1 = "id == "+InmuebleAlq; 
        Inmueble i =(Inmueble)abd.buscarPorCond(new Inmueble(), condicion1);

        String condicion2 = "id== "+GaranteAlq;
        Garante g =(Garante)abd.buscarPorCond(new Garante(), condicion2);
        String condicion3= "usuario == '"+username+"'";
        Administrador a =(Administrador)abd.buscarPorCond(new Administrador(),condicion3);

        String diaArray[] = fecha.split("/");
        Date f = new Date();
        int dia = Integer.parseInt(diaArray[0]);
        int mes = Integer.parseInt(diaArray[1]);
        int anio = Integer.parseInt(diaArray[2]);
        f.setDate(dia);
        f.setMonth(mes-1);
        f.setYear(anio-1900);
        Modificar m = new Modificar();
        Alquileres alq = (Alquileres) abd.buscarPorId(new Alquileres(), idAlq);
        m.ModAlquiler(alq, f, c, i, a, g, monto);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarAlquiler.jsp");
%>