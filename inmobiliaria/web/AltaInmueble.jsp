<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de un nuevo inmueble y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        //if(request.getParameter("inmuebleNuevo")!=null){
        String flag=(String)request.getParameter("bandera");//request que  viene de gestionarAltaInmueble
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
        if(p!=null){
            //Barrio(String nombre,String ubicacion)
            Barrio b= new Barrio(barrio,ubicacion);
            //inmueble(String operacion,Propietario posee,String tipo,int precio,String descr,Barrio tiene,String dire,String disponibilidad)
            Inmueble inm = new Inmueble(operacion,p,tipo,precio,descripcion,b,direccion,disponibilidad);
            String rutaPortadaAd = "images/portadaAdministracion/"+imgAdmin;
            String rutaPortada = "images/portadaBuscador/"+imgBuscador;
            String rutaDetalleGrande = "images/interiorCasas/"+imgDetalleGrande;
            String rutaDetalle1= "images/interiorCasas/"+imgDetalle1;
            String rutaDetalle2= "images/interiorCasas/"+imgDetalle2;
            String rutaDetalle3= "images/interiorCasas/"+imgDetalle3;
            String rutaDetalle4= "images/interiorCasas/"+imgDetalle4;
            //Imagen(String path,Inmueble inm,String tipo)
            Imagen img1 = new Imagen(rutaPortadaAd,inm,"partadaAd");
            Imagen img2 = new Imagen(rutaPortada,inm,"portada");
            Imagen img3 = new Imagen(rutaDetalleGrande,inm,"imgDetalleGrande");
            Imagen img4 = new Imagen(rutaDetalle1,inm,"imgDetalle1");
            Imagen img5 = new Imagen(rutaDetalle2,inm,"imgDetalle2");
            Imagen img6 = new Imagen(rutaDetalle3,inm,"imgDetalle3");
            Imagen img7 = new Imagen(rutaDetalle4,inm,"imgDetalle4");
            abd.hacerPersistente(inm);
            abd.hacerPersistente(img1);
            abd.hacerPersistente(img2);
            abd.hacerPersistente(img3);
            abd.hacerPersistente(img4);
            abd.hacerPersistente(img5);
            abd.hacerPersistente(img6);
            abd.hacerPersistente(img7);
            if(flag.equals("alq")){
                response.sendRedirect("GestionarAltaAlq.jsp");
            }
            if(flag.equals("ven")){
                response.sendRedirect("GestionarAltaVenta.jsp");
            }
            if(!flag.equals("alq") && (!flag.equals("ven"))){
                response.sendRedirect("Admin.jsp");
            }
            abd.concretarTransaccion();
        }
    }catch(Exception e){
        //DeshaceLosCambiosEnLaBD
        abd.rollbackTransaccion();
        e.printStackTrace();
    }     
%>