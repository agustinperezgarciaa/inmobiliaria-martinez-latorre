<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se recuperan los datos de un inmueble, se modifican y se guardan en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        //if(request.getParameter("inmuebleNuevo")!=null){
        Long idIm1 = Long.parseLong(request.getParameter("idI1"));
        Long idIm2 = Long.parseLong(request.getParameter("idI2"));
        Long idIm3 = Long.parseLong(request.getParameter("idI3"));
        Long idIm4 = Long.parseLong(request.getParameter("idI4"));
        Long idIm5 = Long.parseLong(request.getParameter("idI5"));
        Long idIm6 = Long.parseLong(request.getParameter("idI6"));
        Long idIm7 = Long.parseLong(request.getParameter("idI7"));
        Long idInm = Long.parseLong(request.getParameter("id"));
        String direccion= request.getParameter("direccionInmueble");
        int precio=  Integer.parseInt(request.getParameter("precioInmueble"));
        String barrio= request.getParameter("barrio");
        String ubicacion=request.getParameter("ubicacionInmueble");
        String tipo= request.getParameter("tipoInmueble");
        String disponibilidad= request.getParameter("disponibilidadInmueble");
        String operacion=request.getParameter("operacionInmueble");
        String descripcion=request.getParameter("descripcionInmueble");
        String imgAdmin= request.getParameter("imgAdministracion");
        String imgBuscador= request.getParameter("imgBuscador");
        String imgDetalleGrande= request.getParameter("imgDetalleGrande");
        String imgDetalle1 =request.getParameter("imgDetalle1");
        String imgDetalle2 =request.getParameter("imgDetalle2");
        String imgDetalle3 =request.getParameter("imgDetalle3");
        String imgDetalle4 =request.getParameter("imgDetalle4");
        Long  idProp= Long.parseLong(request.getParameter("propietarioInmueble"));
        String condicion = "id == "+idProp;
        Propietario p =(Propietario)abd.buscarPorCond(new Propietario(), condicion);
        //Barrio(String nombre,String ubicacion)
        Barrio b= new Barrio(barrio,ubicacion);
        //inmueble(String operacion,Propietario posee,String tipo,int precio,String descr,Barrio tiene,String dire,String disponibilidad)
        Modificar m = new Modificar();
        Inmueble inm = (Inmueble) abd.buscarPorId(new Inmueble(), idInm);
        m.ModInmueble(inm,operacion,p,tipo,precio,descripcion,b,direccion,disponibilidad);
        String rutaPortadaAd = "images/portadaAdministracion/"+imgAdmin;
        String rutaPortada = "images/portadaBuscador/"+imgBuscador;
        String rutaDetalleGrande = "images/interiorCasas/"+imgDetalleGrande;
        String rutaDetalle1= "images/interiorCasas/"+imgDetalle1;
        String rutaDetalle2= "images/interiorCasas/"+imgDetalle2;
        String rutaDetalle3= "images/interiorCasas/"+imgDetalle3;
        String rutaDetalle4= "images/interiorCasas/"+imgDetalle4;
        Imagen img1 = (Imagen) abd.buscarPorId(new Imagen(), idIm1);
        if (imgAdmin != null){
        m.ModImagen(img1, rutaPortadaAd, inm, "partadaAd");
        }
        Imagen img2 = (Imagen) abd.buscarPorId(new Imagen(), idIm2);
        if (imgBuscador != null){
        m.ModImagen(img2, rutaPortada, inm, "portada");
        }
        Imagen img3 = (Imagen) abd.buscarPorId(new Imagen(), idIm3);
        if (imgDetalleGrande != null){
        m.ModImagen(img3, rutaDetalleGrande, inm, "imgDetalleGrande");
        }
        Imagen img4 = (Imagen) abd.buscarPorId(new Imagen(), idIm4);
        if (imgDetalle1 != null){
        m.ModImagen(img4, rutaDetalle1, inm, "imgDetalle1");
        }
        Imagen img5 = (Imagen) abd.buscarPorId(new Imagen(), idIm5);
        if (imgDetalle2 != null){
        m.ModImagen(img5, rutaDetalle2, inm, "imgDetalle2");
        }
        Imagen img6 = (Imagen) abd.buscarPorId(new Imagen(), idIm6);
        if (imgDetalle3 != null){
        m.ModImagen(img6, rutaDetalle3, inm, "imgDetalle3");
        }
        Imagen img7 = (Imagen) abd.buscarPorId(new Imagen(), idIm7);
        if (imgDetalle4 != null){
        m.ModImagen(img7, rutaDetalle4, inm, "imgDetalle4");
        }
        abd.concretarTransaccion();
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }     
    response.sendRedirect("Admin.jsp");
%>