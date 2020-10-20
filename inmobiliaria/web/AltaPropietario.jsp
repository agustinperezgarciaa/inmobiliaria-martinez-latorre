<%@page import="java.util.Date"%>
<%@page import="Entidad.Propietario"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de un nuevo propietario y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        String flag=(String)request.getParameter("bandera");//request ssi=true--> viene de gestionarAltaInmueble.jsp
        String nombre=(String)request.getParameter("nombre");
        String apellido=(String)request.getParameter("apellido");
        String dni=(String)request.getParameter("dni");
        String direccion=(String)request.getParameter("direccion");
        String email=(String)request.getParameter("mail");
        String telFijo=(String)request.getParameter("telFijo");
        String telMovil=(String)request.getParameter("telMovil");
        String localidad =(String)request.getParameter("localidad");
        String fechaNac=(String)request.getParameter("fechaNac");
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
        Propietario p= new Propietario(email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, f);
        abd.hacerPersistente(p);
        if(flag.equals("verdadero")){
            response.sendRedirect("GestionarAltaInmueble.jsp");
        }
        if(!(flag.equals("verdadero"))){
            response.sendRedirect("GestionarPropietario.jsp");
        }
        abd.concretarTransaccion();
        }catch(Exception e){
            //DeshaceLosCambiosEnLaBD
            abd.rollbackTransaccion();
            e.printStackTrace();
        }     
%>