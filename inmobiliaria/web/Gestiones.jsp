<%@page import="Util.Sesion"%>
<%@page import="Persistencia.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%> 
<%
    //Ingresa en una opci&oacute;n para ingresar a las distintas secciones
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    try{      
       String opGes=(String)request.getParameter("gestionar");
       if (opGes.compareTo("-----------------------------------")==0)
          response.sendRedirect("GestionarCliente.jsp");
       if (opGes.compareTo("Cliente")==0)
          response.sendRedirect("GestionarCliente.jsp");
       if (opGes.compareTo("Garante")==0)
          response.sendRedirect("GestionarGarante.jsp");
       if (opGes.compareTo("Administrador")==0)
          response.sendRedirect("GestionarAdministrador.jsp");
       if (opGes.compareTo("Propietario")==0)
          response.sendRedirect("GestionarPropietario.jsp");
       if (opGes.compareTo("Alquilar")==0)
          response.sendRedirect("GestionarAlquiler.jsp");
       if (opGes.compareTo("Comprar")==0)
          response.sendRedirect("GestionarVenta.jsp");
    }catch(Exception e){
       //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>
    