<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%@page import="Util.Modificar"%>
<%
    //Se recuperan los datos de un nuevo cliente que proviene de una solicitud y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        //Fecha Actual
        Calendar d = Calendar.getInstance();;
        String dia1 = Integer.toString(d.get(Calendar.DATE));
        String es = Integer.toString(d.get(Calendar.MONTH));
        String annio = Integer.toString(d.get(Calendar.YEAR));
        String fecha = dia1+ "/"+ es +"/"+ annio;
        abd.iniciarTransaccion();
        //Datos del cliente
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String dni =request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("mail");
        String telFijo = request.getParameter("telFijo");
        String telMovil =request.getParameter("telMovil");
        String fechaNacimiento = request.getParameter("fechaNac");
        String localidad = request.getParameter("localidad");
        String diaArray[] = fecha.split("/");
        Date fv = new Date();
        int diav = Integer.parseInt(diaArray[0]);
        int mesv = Integer.parseInt(diaArray[1]);
        int aniov = Integer.parseInt(diaArray[2]);
        fv.setDate(diav);
        fv.setMonth(mesv-1);
        fv.setYear(aniov-1900);
        
        String diaArrayV[] = fechaNacimiento.split("/");
        Date fc = new Date();
        int diac = Integer.parseInt(diaArrayV[0]);
        int mesc = Integer.parseInt(diaArrayV[1]);
        int anioc = Integer.parseInt(diaArrayV[2]);
        fc.setDate(diac);
        fc.setMonth(mesc-1);
        fc.setYear(anioc-1900);
        if (telFijo.equals("")){
            telFijo = ("No tiene");
        }
        Cliente c = new Cliente(email, nombre, apellido, dni, direccion, telFijo, telMovil, localidad, fc);
        abd.hacerPersistente(c);
        //Datos del inmueble
        long idInmueble= Long.parseLong(request.getParameter("idInm"));
        String condicionInm="id=="+idInmueble;
        Inmueble inm = (Inmueble)abd.buscarPorCond(new Inmueble(), condicionInm);
        Modificar m = new Modificar();
        m.ModInm(inm,"No Disponible");
        String ad = (String)session.getAttribute("username");
        String condicionAd= "usuario=='"+ad+"'";
        Administrador admin = (Administrador)abd.buscarPorCond(new Administrador(),condicionAd);
        String operacion = request.getParameter("operacionInmueble");
        //Gestionar Alquiler
        if(operacion.equals("Alquilar")){
            //Datos del garante
            long idGarante = Long.parseLong(request.getParameter("GaranteAlquiler"));
            String condicionUno = "id=="+idGarante;
            Garante g = (Garante)abd.buscarPorCond(new Garante(), condicionUno);
            if (g == null){
                String mensaje="<script language='javascript'>alert('No existe el ID del Garante, debes corregirlo');</script>"; 
                out.println(mensaje);
                String atras="<script language='javascript'> history.back();</script>"; 
                out.println(atras);
            }
            if(g!=null){
                Alquileres a =new Alquileres(fv, c, inm, admin, g,inm.getPrecio());
                abd.hacerPersistente(a);
                response.sendRedirect("Admin.jsp?flagSolicitud=Solicitudes: ");
            }
            //Alquileres(String fecha,Cliente alquila,Inmueble alquilado,Administrador administra,Garante garantiza, long monto)
        }else 
            //Gestionar Venta
            if(operacion.equals("Comprar")){
            //Venta(String fecha,Cliente vende,Inmueble vendido,Administrador administra, long monto)
                Venta v= new Venta(fv,c,inm,admin,inm.getPrecio());
                abd.hacerPersistente(v);
                response.sendRedirect("Admin.jsp?flagSolicitud=Solicitudes: ");
            }
            long idClientePosible=Long.parseLong(request.getParameter("idCP"));
            String condicion="id=="+idClientePosible;
            ClientePosible CP =(ClientePosible)abd.buscarPorCond(new ClientePosible(),condicion);      
            String estado = "Antigua";
            CP.setEstado(estado);
            //que modifique
            abd.concretarTransaccion();
        }catch(Exception e){
            //DeshaceLosCambiosEnLaBD
            abd.rollbackTransaccion();
            e.printStackTrace();
        } 
%>
        
