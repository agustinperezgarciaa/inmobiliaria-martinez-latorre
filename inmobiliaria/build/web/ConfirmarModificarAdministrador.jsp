<%@page import="java.util.Date"%>
<%@page import=" Seguridad.MD5" %>
<%@page import="Entidad.Administrador"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se recuperan los datos de un administrador, se modifican y se guardan en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    MD5 l = new MD5();
    try{
        abd.iniciarTransaccion();
        Long idAdmin = Long.parseLong(request.getParameter("id"));
        String nombre=(String)request.getParameter("nombre");
        String apellido=(String)request.getParameter("apellido");
        String dni=(String)request.getParameter("dni");
        String direccion=(String)request.getParameter("direccion");
        String paginaWeb=(String)request.getParameter("paginaWeb");
        String user=(String)request.getParameter("usuario");
        //String passUno= (l.md5((String)request.getParameter("passUno")));
        //String passUno= (String)request.getParameter("passUno");
        String email=(String)request.getParameter("mail");
        String telFijo=(String)request.getParameter("telFijo");
        String telMovil=(String)request.getParameter("telMovil");
        String localidad =(String)request.getParameter("localidad");
        String fechaNac=(String)request.getParameter("fechaNac");
        Modificar m = new Modificar();
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
        Administrador ad = (Administrador) abd.buscarPorId(new Administrador(), idAdmin);
        m.ModAdminSinPass(ad, email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, f, paginaWeb, user);
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 

    response.sendRedirect("Salir.jsp");
 %>