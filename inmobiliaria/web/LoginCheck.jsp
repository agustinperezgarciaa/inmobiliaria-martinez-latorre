<%@page import="com.mysql.jdbc.Security"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Entidad.*"%>
<%@page import=" Seguridad.MD5" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Recupera ususario y contraseña ingresados en el loguin y verifica su autenticidad
    AccesoBD abd=(AccesoBD)session.getAttribute("conex");
    String layer="hidden";
    MD5 f= new MD5();
    
    String username=request.getParameter("user");
    String password=request.getParameter("pass");
    String condicion= "usuario=='"+username+"'";
    String flag="false";
    try{
        abd.iniciarTransaccion();
        LinkedList <Administrador> a= new LinkedList();
        a=abd.listar(new Administrador(),condicion);
        //Usuario no Logueado
        if((a.size()==0)||(a.getFirst().getUsuario().compareTo(username)==0)&&(a.getFirst().getPassword().compareTo(f.md5(password))!=0)){
            layer="visible";
            session.setAttribute("div",layer);
            session.setAttribute("flagLogin",flag);
            response.sendRedirect("Login.jsp");
        }
        //Usuario Logueado
        if((a.getFirst().getPassword().compareTo(f.md5(password))==0)){
            session.setAttribute("username", username );
            flag="true";
            session.setAttribute("flagLogin",flag);
            response.sendRedirect("Admin.jsp");
        }
        abd.concretarTransaccion();
    }catch (Exception e){
        e.printStackTrace();
        abd.rollbackTransaccion();               
    }
%>
