<%@page import="java.util.Date"%>
<%@page import="Entidad.Garante"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de un nuevo garante y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        String flag=(String)request.getParameter("bandera");
        String nombre=(String)request.getParameter("nombre");
        String apellido=(String)request.getParameter("apellido");
        String dni=(String)request.getParameter("dni");
        String direccion=(String)request.getParameter("direccion");
        String email=(String)request.getParameter("mail");
        String telFijo=(String)request.getParameter("telFijo");
        String telMovil=(String)request.getParameter("telMovil");
        String localidad =(String)request.getParameter("localidad");
        String fechaNac=(String)request.getParameter("fechaNac");
        String profesion=(String)request.getParameter("profesion");
        String lugarTrabajo=(String)request.getParameter("lugarTrabajo");
        String nacionalidad=(String)request.getParameter("nacionalidad");
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
        Garante a= new Garante (email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, f, profesion, lugarTrabajo, nacionalidad);
        abd.hacerPersistente(a);
        if(flag.equals("alq")){
            response.sendRedirect("GestionarAltaAlq.jsp");
        }
        if(!flag.equals("alq")){
            response.sendRedirect("GestionarGarante.jsp");
        }
        abd.concretarTransaccion();
        }catch(Exception e){
            //DeshaceLosCambiosEnLaBD
            abd.rollbackTransaccion();
            e.printStackTrace();
        } 
%>