<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Persistencia.AccesoBD" %>
<%@page import="Util.*" %>
<%
    //Generador de la secci&oacute;n buscador
    GenerarHTMLBuscador html=new GenerarHTMLBuscador();
    //obtenci&oacute;nBaseDatos
    AccesoBD abd = new AccesoBD ();
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);        
    try{
        //InicializacionDeLaTransacci&oacute;n;
        abd.iniciarTransaccion();
        out.print(html.generarHTMLHeadUno("Buscador de Prop."));
        out.print(html.generarHTMLMenu(username));
        //request:filtro solicitado
        out.print(html.generarHTLMColumnOne(request,abd));
        out.print(html.generarHTMLColumnFour(abd));
        out.print(html.generarHTMLFooterIndex());
        out.print(html.generarHTMLFinal());
        //ConcretaLaTransaccion;
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }
%>