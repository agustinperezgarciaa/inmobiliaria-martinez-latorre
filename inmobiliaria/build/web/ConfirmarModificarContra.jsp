<%@page import="Util.Sesion"%>
<%@page import=" Seguridad.MD5" %>
<%@page import="Entidad.Administrador"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se modifica la contraseña de un adminsitrador
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    MD5 l = new MD5();
    String username = s.getNombreUsuario(session);
    String user = (String)session.getAttribute("usernameParaContra");
    
    try{
        abd.iniciarTransaccion();
        String passUno= (String)request.getParameter("passUno");
        Modificar m = new Modificar();
        String condicion= "usuario == '"+user+"'";
        passUno= (l.md5((String)request.getParameter("passUno")));
        
        Administrador a =(Administrador)abd.buscarPorCond(new Administrador(),condicion);       
        m.modContra(a, passUno);

        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 

    response.sendRedirect("Salir.jsp");
 %>