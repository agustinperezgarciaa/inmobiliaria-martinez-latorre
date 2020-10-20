7<%@page import="Persistencia.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Vista.*"%>
<%@page import="Util.*"%> 

<%
    //Generador de secci&oacute;n administrador
    //Obtenci&oacute;nBaseDatos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    String flagLogin = (String)session.getAttribute("flagLogin");//request que viene de LoginCheck(TRUE;FALSE);
    if (flagLogin.compareTo("true")==0){
        try{
            String flag= (String) request.getParameter("flagg");
            //Inicializaci&oacute;nDeLaTransacci&oacute;n;
            abd.iniciarTransaccion();
            GenerarHTMLAdmin html=new GenerarHTMLAdmin(flag);
            out.print(html.generarHTMLHead("Admin. de Propiedades"));
            out.print(html.generarHTMLMenu(username));
            out.print(html.GenerarMainConten(request,abd,username));
            out.print(html.GenerarAdminHeaderBorder(request,abd,username));
            out.print(html.generarHTMLFooter());
            out.print(html.generarHTMLFinal());        
            //ConcretaLaTransacci&oacute;n;
            abd.concretarTransaccion();
        }
        catch(Exception e){
            //DeshaceLosCambiosEnLaBD
            abd.rollbackTransaccion();
            e.printStackTrace();
        }
    }else  if (flagLogin.compareTo(null)==0){
        response.sendRedirect("Login.jsp");
    }
%>