<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.Administrador"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de un nuevo administrador y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        String nombre=(String)request.getParameter("nombre");
        String apellido=(String)request.getParameter("apellido");
        String dni=(String)request.getParameter("dni");
        String direccion=(String)request.getParameter("direccion");
        String paginaWeb=(String)request.getParameter("paginaWeb");
        String user=(String)request.getParameter("usuario");
        String passUno=(String)request.getParameter("passUno");
        String passDos=(String)request.getParameter("passDos");
        String email=(String)request.getParameter("mail");
        String telFijo=(String)request.getParameter("telFijo");
        String telMovil=(String)request.getParameter("telMovil");
        String localidad =(String)request.getParameter("localidad");
        String fechaNac=(String)request.getParameter("fechaNac");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(fechaNac);
        if (telFijo.equals("")){
            telFijo = ("No tiene");
        }
        String diaArray[] = fechaNac.split("/");
        Date f = new Date();
        int dia = Integer.parseInt(diaArray[0]);
        int mes = Integer.parseInt(diaArray[1]);
        int anio = Integer.parseInt(diaArray[2]);
        f.setDate(dia);
        f.setMonth(mes-1);
        f.setYear(anio-1900);
        Administrador a= new Administrador(email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, f, paginaWeb, user, passUno);
        abd.hacerPersistente(a);
        abd.concretarTransaccion();
    }
    catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    response.sendRedirect("GestionarAdministrador.jsp");
%>