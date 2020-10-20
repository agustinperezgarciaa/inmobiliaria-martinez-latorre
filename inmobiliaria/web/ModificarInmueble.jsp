<%@page import="Vista.*"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.*"%>
<%
    //Generador de la secci&oacute;n de modificar inmueble
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    Sesion s = new Sesion ();
    String username = s.getNombreUsuario(session);    
    try{
        abd.iniciarTransaccion();
        Long idInm = Long.parseLong(request.getParameter("editarInmueble"));
        String condicion="inm.id=="+idInm+" && tipo=='partadaAd'";
        Imagen imag = (Imagen) abd.buscarPorCond(new Imagen(), condicion);
        String condicion2="inm.id=="+idInm+" && tipo=='portada'";
        Imagen imag2 = (Imagen) abd.buscarPorCond(new Imagen(), condicion2);
        String condicion3="inm.id=="+idInm+" && tipo=='imgDetalleGrande'";
        Imagen imag3 = (Imagen) abd.buscarPorCond(new Imagen(), condicion3);
        String condicion4="inm.id=="+idInm+" && tipo=='imgDetalle1'";
        Imagen imag4 = (Imagen) abd.buscarPorCond(new Imagen(), condicion4);
        String condicion5="inm.id=="+idInm+" && tipo=='imgDetalle2'";
        Imagen imag5 = (Imagen) abd.buscarPorCond(new Imagen(), condicion5);
        String condicion6="inm.id=="+idInm+" && tipo=='imgDetalle3'";
        Imagen imag6 = (Imagen) abd.buscarPorCond(new Imagen(), condicion6);
        String condicion7="inm.id=="+idInm+" && tipo=='imgDetalle4'";
        Imagen imag7 = (Imagen) abd.buscarPorCond(new Imagen(), condicion7);
        Inmueble inm = (Inmueble) abd.buscarPorId(new Inmueble(), idInm);
        GenerarHTMLGesEditorInmueble html=new GenerarHTMLGesEditorInmueble();
        out.print(html.generarHTMLHead("Modificar Inmueble"));
        out.print(html.generarHTMLMenu(username));
        out.print(html.generarHTMLMainContent(inm,imag,imag2,imag3,imag4,imag5,imag6,imag7,abd));
        out.print(html.generarHTMLFooterIn());
        out.print(html.generarHTMLFinal()); 
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    } 
    // response.sendRedirect("GestionarAdministrador.jsp");
%>
