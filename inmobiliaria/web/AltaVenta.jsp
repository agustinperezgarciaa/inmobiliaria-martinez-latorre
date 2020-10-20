<%@page import="java.util.Date"%>
<%@page import="Entidad.*"%>
<%@page import="Persistencia.AccesoBD"%>
<%
    //Se recuperan los datos de una nueva venta y se guarda en la base de datos
    AccesoBD abd =((AccesoBD)session.getAttribute("conex"));
    abd.sesionIniciada(session);
    try{
        abd.iniciarTransaccion();
        String username= (String)session.getAttribute("username");
        String fecha=(String)request.getParameter("fecha");
        Long monto=Long.parseLong(request.getParameter("monto"));
        Long  idClie= Long.parseLong(request.getParameter("ClienteVenta"));
        Long  idInm= Long.parseLong(request.getParameter("InmuebleVenta"));
        String condicion = "id == "+idClie;
        out.println(username);
        Cliente c =(Cliente)abd.buscarPorCond(new Cliente(), condicion);
        String condicion2 = "id == "+idInm;
        Inmueble i =(Inmueble)abd.buscarPorCond(new Inmueble(), condicion2);
        //String nombAdmin = session.getAttribute("username").toString();
        String condicion1= "usuario == '"+username+"'";
        Administrador a =(Administrador)abd.buscarPorCond(new Administrador(),condicion1);
        i.setDisp("No disponible");
        if (c == null){
            String mensaje2="<script language='javascript'>alert('No existe el ID del Cliente, debes corregirlo');</script>"; 
            out.println(mensaje2);
            String atras2="<script language='javascript'> history.back();</script>"; 
            out.println(atras2);
        }else
            if (i == null){
                String mensaje3="<script language='javascript'>alert('No existe el ID del Inmueble, debes corregirlo');</script>"; 
                out.println(mensaje3);
                String atras3="<script language='javascript'> history.back();</script>"; 
                out.println(atras3);
            }
            if((c!=null)&&(i!=null)){
                String diaArray[] = fecha.split("/");
                Date f = new Date();
                int dia = Integer.parseInt(diaArray[0]);
                int mes = Integer.parseInt(diaArray[1]);
                int anio = Integer.parseInt(diaArray[2]);
                f.setDate(dia);
                f.setMonth(mes-1);
                f.setYear(anio-1900);
                //public Venta(String fecha,Cliente vende,Inmueble vendido,Administrador administra, int monto){   
                Venta v = new Venta(f, c, i, a, monto);
                abd.hacerPersistente(v);
                response.sendRedirect("GestionarVenta.jsp");
            }
            abd.concretarTransaccion();
            }catch(Exception e){
                //DeshaceLosCambiosEnLaBD
                abd.rollbackTransaccion();
                e.printStackTrace();
            }  
%>