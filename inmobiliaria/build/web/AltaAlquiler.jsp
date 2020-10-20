<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>


<%
        //Se recuperan los datos de un nuevo alquiler y se guarda en la base de datos
        AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
        abd.sesionIniciada(session);
        try{
            abd.iniciarTransaccion();
            String username= (String)session.getAttribute("username");
            String fecha=(String)request.getParameter("fecha");
            out.println(fecha);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //surround below line with try catch block as below code throws checked exception
            Date startDate = sdf.parse(fecha);
            //do further processing with Date object
            
            Long monto=Long.parseLong(request.getParameter("monto"));
            Long  clienteAlq= Long.parseLong(request.getParameter("ClienteAlquiler"));
            Long  InmuebleAlq= Long.parseLong(request.getParameter("InmuebleAlquiler"));
            Long GaranteAlq= Long.parseLong(request.getParameter("GaranteAlquiler"));

            String condicion = "id == "+clienteAlq;
            Cliente c =(Cliente)abd.buscarPorCond(new Cliente(), condicion);

            String condicion1 = "id == "+InmuebleAlq; 
            Inmueble i =(Inmueble)abd.buscarPorCond(new Inmueble(), condicion1);

            String condicion2 = "id== "+GaranteAlq;
            Garante g =(Garante)abd.buscarPorCond(new Garante(), condicion2);
            String condicion3= "usuario == '"+username+"'";
            Administrador a =(Administrador)abd.buscarPorCond(new Administrador(),condicion3);
            i.setDisp("No disponible");
            out.println(sdf.format(startDate)); 
            if (g == null){
                String mensaje="<script language='javascript'>alert('No existe el ID del Garante, debes corregirlo');</script>"; 
                out.println(mensaje);
                String atras="<script language='javascript'> history.back();</script>"; 
                out.println(atras);
            }else if (i == null){    
                String mensaje3="<script language='javascript'>alert('No existe el ID del Inmueble, debes corregirlo');</script>"; 
                out.println(mensaje3);
                String atras3="<script language='javascript'> history.back();</script>"; 
                out.println(atras3);
            }
            if((c!=null)&&(g!=null)&&(i!=null)){        
                String diaArray[] = fecha.split("/");
                Date f = new Date();
                int dia = Integer.parseInt(diaArray[0]);
                int mes = Integer.parseInt(diaArray[1]);
                int anio = Integer.parseInt(diaArray[2]);
                f.setDate(dia);
                f.setMonth(mes-1);
                f.setYear(anio-1900);
                Alquileres alq = new Alquileres(f,c,i,a,g,monto);    
                abd.hacerPersistente(alq);
                response.sendRedirect("GestionarAlquiler.jsp");
            }
            abd.concretarTransaccion();
            }catch(Exception e){
                //DeshaceLosCambiosEnLaBD
                abd.rollbackTransaccion();
                e.printStackTrace();
            }
%>