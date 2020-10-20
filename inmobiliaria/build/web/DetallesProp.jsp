<%@page import="Entidad.*"%>
<%@page import="Vista.*"%>
<%@page import="Persistencia.AccesoBD" %>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de detalles de propiedades en la cual el cliente ingresa cuando quiere ampliar la informaci&oacute;n de un inmueble buscado
    GenerarHTMLDetallesProp html=new GenerarHTMLDetallesProp();
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    Sesion s = new Sesion();
    String username = s.getNombreUsuario(session);
    long idInmu=Long.parseLong(request.getParameter("idInm"));
    try{
        //InicializacionDeLaTransaccion;
        abd.iniciarTransaccion();
        out.print(html.generarHTMLHeadUno("Detalles de la Prop."));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTLMColumnaUno());
        out.print(html.generarHTMLColumnaCuatro(idInmu));
        out.print(html.generarHTMLColumnaDos(idInmu,abd));
        out.print(html.generarHTMLColumnaTres(idInmu,abd));
        out.print(html.generarHTMLFooterIn());
        //ConcretaLaTransaccion;
        abd.concretarTransaccion();
   }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
   }
%>