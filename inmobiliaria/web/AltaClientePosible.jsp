<%@page import="java.util.Date"%>
<%@page import="Entidad.Inmueble"%>
<%@page import="Entidad.ClientePosible"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de un nuevo cliente posible y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        String nombre=(String)request.getParameter("nombre");
        String apellido=(String)request.getParameter("apellido");
        String dni=(String)request.getParameter("dni");
        String direccion=(String)request.getParameter("direccion");
        String email=(String)request.getParameter("mail");
        String telFijo=(String)request.getParameter("telFijo");
        String telMovil=(String)request.getParameter("telMovil");
        String localidad =(String)request.getParameter("localidad");
        String fechaNac=(String)request.getParameter("fechaNac");
        long idInmueble= Long.parseLong(request.getParameter("id"));//Request que viene de GenererHTMLClientePosible.java
        String condicion = "id == "+idInmueble;
        Inmueble inm = (Inmueble)abd.buscarPorCond(new Inmueble(), condicion);
        String nueva="Nueva";
        String diaArray[] = fechaNac.split("/");
        Date f = new Date();
        int dia = Integer.parseInt(diaArray[0]);
        int mes = Integer.parseInt(diaArray[1]);
        int anio = Integer.parseInt(diaArray[2]);
        f.setDate(dia);
        f.setMonth(mes-1);
        f.setYear(anio-1900);
        if (telFijo.equals("")){
            telFijo = ("No tiene");
        }
        ClientePosible c =new ClientePosible(email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, f,inm.getOperacion(), idInmueble,nueva);
        abd.hacerPersistente(c);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("Buscador.jsp");
%>