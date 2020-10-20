package Vista;

import Entidad.Alquileres;
import Entidad.Barrio;
import Entidad.ClientePosible;
import Entidad.Inmueble;
import Entidad.Imagen;
import Entidad.Venta;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n de listas de inmueble
public class GestionarListasInmueble {
    private LinkedList<Inmueble> lisInm;
    private String html="";
    private String nameClass="even";
    private LinkedList<Imagen> picc;

    public String tablasListarAdmin(AccesoBD abd,String val,String VF, HttpServletRequest request){
        if("Solicitudes: ".equals(request.getParameter("flagSolicitud"))){
            html=tablaSolicitudes(abd);        
            }else 
                if(VF == null){
                    html=tablaDisponible(abd); 
                }else
                if (("Nada".equals(val))||("Propiedades disponibles".equals(val))){
                    html=tablaDisponible(abd);
                }else 
                    if("Ordenacion por ubicacion".equals(val)){
                        html=tablaOrdenarUbicacion(abd);
                    }else 
                        if ("Ordenacion por precio".equals(val)){
                            html=tablaOrdenarPrecio(abd);
                        }else
                            if ("Inmuebles alquilados".equals(val)){
                                html=tablaAlquilados(abd);
                            }else 
                                if ("Inmuebles vendidos".equals(val)){
                                    html=tablaVendidos(abd);
                                }else 
                                    if ("Inmuebles para alquilar".equals(val)){
                                        html=tablaParaAlquilar(abd);
                                    }else 
                                         if ("Inmuebles para vender".equals(val)){
                                            html=tablaParaVender(abd);
                                         }else
                                            if ("Todos".equals(val)){
                                                html=tablaTodos(abd);
                                            }else
                                                if ("Venta de administradores".equals(val)){
                                                    html=tablaVentaUsuario(abd);
                                                }else
                                                    if ("Alquiler de administradores".equals(val)){
                                                        html=tablaAlquilerUsuario(abd);
                                                    }else
                                                        if (("------------------------------------------".equals(val))){
                                                            html=tablaTodos(abd);
                                                        }
    return html;
    }
    
    public int getNumberSolicitud(AccesoBD abd){
        String condicion="estado=='Nueva'";
        LinkedList<ClientePosible> SN =abd.listar(new ClientePosible(),condicion);
        return SN.size();
    }
    
    private String tablaSolicitudes(AccesoBD abd){
        LinkedList<ClientePosible>CP=abd.listar(new ClientePosible(),"");
        try{
            html+="<form  name=\"FormularioEliminarSolicitud\" id=\"FormSolElim\" method=\"post\" action=\"BajaSolicitud.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimSol\" name=\"eliminarSolicitud\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";        
            html+="<form id=\"FormAltSol\" name=\"FormularioAltaSolicitud\" method=\"post\" action=\"AltaSolicitud.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"agregSol\" name=\"agregarSolicitud\">";
            html+="</form> \n";
        }catch(Exception e){
            e.printStackTrace();
        }
            html+=  "<div class=\"table_grid\">\n";
            html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
            html+=          "<tr>\n";
            html+=              "<th style=\"width:50;\">Apellido</th>\n";
            html+=              "<th style=\"width:50;\">Nombre</th>\n";
            html+=              "<th style=\"width:100;\">ID del inm. y direccion</th>\n";
            html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
            html+=              "<th style=\"width:50;\">Estado</th>\n";
            html+=              "<th style=\"width:50;\">Detalles</th>\n";//Se abre una pantalla con todos los detalles de solicitudes
            html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
            html+=          "</tr>\n";
            for (int i=0;i<=CP.size()-1;i++){             
                String condicion = "id == "+CP.get(i).getLeInteresa();
                Inmueble in =(Inmueble)abd.buscarPorCond(new Inmueble(), condicion);
                html+=          "<tr class= "+nameClass+">\n";
                html+=              "<td><center>"+CP.get(i).getApellido()+"</center></td>\n";
                html+=              "<td><center>"+CP.get(i).getNombre()+"</center> </td>\n";
                html+=              "<td><center>"+CP.get(i).getLeInteresa()+" - "+in.getDireccion()+"</center></td>\n";
                html+=              "<td><center>"+CP.get(i).getOperacion()+"</center></td>\n";
                html+=              "<td><justify>"+CP.get(i).getEstado()+"</justify></td>\n";
                html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/details.png\" onMouseOver=this.src=\"images/adminicons/details.png\" onclick=\"altaSolicitud("+CP.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\" /></center></td>\n";
                html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimSolicitud("+CP.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
                html+=          "</tr>\n";
                if(nameClass.compareTo("even")==0){
                    nameClass="odd";
                }else if(nameClass.compareTo("odd")==0){
                    nameClass="even";
                }
            }//endFor
        html+=      "</table>\n";//line49
        html+=  "</div>\n";//endTable_grid
        return html;
    }    
    
    private  String tablaDisponible(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="Disponible";
            String condicion= "disponibilidad=='"+nombre+"'";
            lisInm=abd.listar(new Inmueble(),condicion);
        }catch(Exception e){
                e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
	html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
	html+=              "<th style=\"width:10;\">Precio</th>\n";
	html+=              "<th style=\"width:1;\">Editar</th>\n";
	html+=              "<th style=\"width:1;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }    
    
    private String tablaAlquilados(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String dis="No Disponible";
            String oper="Alquilar";
            String condicion= "disponibilidad=='"+dis+"' && operacion=='"+oper+"'";
            lisInm=abd.listar(new Inmueble(),condicion);
        }catch(Exception e){
                e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
	html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10;\">Precio</th>\n";
	html+=              "<th style=\"width:1;\">Editar</th>\n";
	html+=              "<th style=\"width:1;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+=  "</div>\n";//endTable_grid
        
        return html;
    }
    
    private String tablaVendidos(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="No Disponible";
            String oper="Comprar";
            String condicion= "disponibilidad=='"+nombre+"' && operacion=='"+oper+"'";
            lisInm=abd.listar(new Inmueble(),condicion);
        }catch(Exception e){
                e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
	html+=              "<th style=\"width:1px;\">Editar</th>\n";
	html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }    
    private String tablaParaAlquilar(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="Disponible";
            String oper="Alquilar";
            String condicion= "disponibilidad=='"+nombre+"' && operacion=='"+oper+"'";
            lisInm=abd.listar(new Inmueble(),condicion);
        }catch(Exception e){
                e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
	html+=              "<th style=\"width:1px;\">Editar</th>\n";
	html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        
        return html;
    }
    private String tablaParaVender(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="Disponible";
            String oper="Comprar";
            String condicion= "disponibilidad=='"+nombre+"' && operacion=='"+oper+"'";
            lisInm=abd.listar(new Inmueble(),condicion);
        }catch(Exception e){
                e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
	html+=              "<th style=\"width:1px;\">Editar</th>\n";
	html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=              "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }   
    
    private String tablaOrdenarUbicacion(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="Disponible";
            String condicion= "disponibilidad=='"+nombre+"'";           
            lisInm=abd.getObjectsOrdered(new Inmueble().getClass(),condicion,"tiene descending");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Imagen</th>\n";
	html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
	html+=              "<th style=\"width:1px;\">Editar</th>\n";
	html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=              "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }
    
    private String tablaOrdenarPrecio(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String nombre="Disponible";
            String condicion= "disponibilidad=='"+nombre+"'";              
            lisInm=abd.getObjectsOrdered(new Inmueble().getClass(),condicion,"precio descending");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
        html+=              "<th style=\"width:20px;\">ID</th>\n";
        html+=              "<th style=\"width:50px;\">Imagen</th>\n";
        html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
        html+=              "<th style=\"width:1px;\">Editar</th>\n";
        html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=              "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }
    private String tablaTodos(AccesoBD abd){
        try{
            html+="<form  name=\"FormularioEditarInmueble\" id=\"FormInmEdit\" method=\"post\" action=\"ModificarInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editInm\" name=\"editarInmueble\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarInmueble\" id=\"FormInmElim\" method=\"post\" action=\"BajaInmueble.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimInm\" name=\"eliminarInmueble\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";  
            //lista todos los inmuebles
            String condicion= "";
            lisInm=abd.getObjectsOrdered(new Inmueble().getClass(),condicion,"id ascending");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
        html+=              "<th style=\"width:20px;\">ID</th>\n";
        html+=              "<th style=\"width:50px;\">Imagen</th>\n";
        html+=              "<th style=\"width:50;\">Operaci&oacute;n</th>\n";
        html+=              "<th style=\"width:70;\">Ubicaci&oacute;n</th>\n";
        html+=              "<th style=\"width:50;\">Estado</th>\n";
	html+=              "<th style=\"width:270;\">Descripci&oacute;n</th>\n";
        html+=              "<th style=\"width:30;\">Tipo</th>\n";
        html+=              "<th style=\"width:10px;\">Precio</th>\n";
        html+=              "<th style=\"width:1px;\">Editar</th>\n";
        html+=              "<th style=\"width:1px;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisInm.size()-1;i++){
            Inmueble in = lisInm.get(i);
            Barrio bar = in.getBarrio();
            String condicionn="inm.id=="+lisInm.get(i).getId()+" && tipo=='partadaAd'";
            picc=abd.listar(new Imagen(),condicionn);
            html+=              "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+in.getId()+" </center></td>\n";
            html+=              "<td><center><img src="+picc.getFirst().getPath()+" width=\"53\" height=\"39\" border=\"0\" /></center></td>\n";
            html+=              "<td><center>"+in.getOperacion()+"</center> </td>\n";
            html+=              "<td><center>"+bar.getNombre()+"</center></td>\n";
            html+=              "<td><center>"+in.getDisp()+"</center></td>\n";
            html+=              "<td><justify>"+in.getDescripcion()+"</justify></td>\n";
            html+=              "<td><justify>"+in.getTipo()+"</justify></td>\n";
            html+=              "<td><center>"+in.getPrecio()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimInmueble("+lisInm.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }
    
    private String tablaVentaUsuario(AccesoBD abd){
        String condicion="";
        LinkedList<Venta> lisVent=abd.listar(new Venta(),condicion);
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Nombre</th>\n";
	html+=              "<th style=\"width:auto;\">Nombre e ID del Cliente</th>\n";
	html+=              "<th style=\"width:auto;\">ID del Inmueble</th>\n";
	html+=              "<th style=\"width:100px;\">Fecha</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisVent.size()-1;i++){
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisVent.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisVent.get(i).getAdministra().getNombre()+"</center></td>\n";
            html+=              "<td><center>"+lisVent.get(i).getVende().getNombre()+ "-"+ lisVent.get(i).getVende().getId()+ "</center> </td>\n";
            html+=              "<td><center>"+lisVent.get(i).getVendido().getId()+"</center></td>\n";
            html+=              "<td><center>"+lisVent.get(i).getFecha()+"</center></td>\n";
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        
        return html;
    }
    private String tablaAlquilerUsuario(AccesoBD abd){
        String condicion="";
        LinkedList<Alquileres> lisAlq=abd.listar(new Alquileres(),condicion);
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
	html+=              "<th style=\"width:20px;\">ID</th>\n";
	html+=              "<th style=\"width:50px;\">Nombre</th>\n";
	html+=              "<th style=\"width:auto;\">Nombre e ID del Cliente</th>\n";
	html+=              "<th style=\"width:auto;\">ID del Inmueble</th>\n";
	html+=              "<th style=\"width:50px;\">Garante</th>\n";
        html+=              "<th style=\"width:100px;\">Fecha</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisAlq.size()-1;i++){
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisAlq.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getAdministra().getNombre()+"</center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getAlquila().getNombre()+ "-"+ lisAlq.get(i).getAlquila().getId()+ " </center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getAlquilado().getId()+"</center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getGarantiza().getNombre()+"</center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getFecha()+"</center></td>\n";
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+="	  <p>&nbsp;</p>\n";
        html+=  "</div>\n";//endTable_grid
        return html;
    }
}
