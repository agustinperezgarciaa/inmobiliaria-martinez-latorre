package Vista;

import Entidad.Garante;
import Entidad.Alquileres;
import Entidad.Cliente;
import Entidad.Administrador;
import Entidad.Inmueble;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;
import java.util.Date;


//Vista de la secci&oacute;n gestionar alquiler
public class GestionarAlquiler {
    String html="";
    String nameClass="even";
    private LinkedList<Alquileres> lisAlq;
    private LinkedList<Cliente> lisClie;
    private LinkedList<Inmueble> lisInm;
    private LinkedList<Garante> lisGar;
      
    public String TablaGestionarAlq(AccesoBD abd,HttpServletRequest request) throws Exception{
       String html= "";
       html = listarTablaAlq(abd,request);
       String  valorSelect=(String)request.getParameter("selecAlquiler");
        if("AAl".equals(valorSelect)){
            html=altaAlq(abd); 
        }
        if ("LAl".equals(valorSelect)){
            html=listarTablaAlq(abd,request);
        }
        return html;
    }
    
    private  String listarTablaAlq(AccesoBD abd,HttpServletRequest request){
        String html="";
        try{ 
            html+="<form  name=\"FormularioEditarAlquiler\" id=\"FormAlqEdit\" method=\"post\" action=\"ModificarAlquiler.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"editAlq\" name=\"editarAlquiler\" value=\"\">\n";                           //Input para el Editar
            html+="</form>\n";
            html+="<form  name=\"FormularioEliminarAlquiler\" id=\"FormAlqElim\" method=\"post\" action=\"BajaAlquiler.jsp\">\n";
            html+=  "<input type=\"hidden\" id=\"elimAlq\" name=\"eliminarAlquiler\" value=\"\">\n";                         //Input para el Eliminar
            html+="</form>\n";   
            lisAlq=abd.listar(new Alquileres(),"");
        }catch(Exception e){
            e.printStackTrace();
        }
        html+=  "<div class=\"table_grid\">\n";
        html+=      "<table  cellspacing=\"0\"   cellpadding=\"0\">\n";
        html+=          "<tr>\n";
        html+=              "<th style=\"width:20px;\">ID</th>\n";
        html+=              "<th style=\"width:100px;\">Fecha</th>\n";
        html+=              "<th style=\"width:50;\">Monto</th>\n";
        html+=              "<th style=\"width:100;\">ID, nombre y apellido del Cliente</th>\n";
        html+=              "<th style=\"width:100;\">ID y direcci&oacute;n del Inmueble</th>\n";
        html+=              "<th style=\"width:100;\">ID, nombre y apellido del Garante</th>\n";
        html+=              "<th style=\"width:100;\">ID, nombre y apellido del Administrador</th>\n";
        html+=              "<th style=\"width:1;\">Editar</th>\n";
	html+=              "<th style=\"width:1;\">Eliminar</th>\n";
        html+=          "</tr>\n";
        for (int i=0;i<=lisAlq.size()-1;i++){
            Cliente cli = lisAlq.get(i).getAlquila();
            Inmueble in = lisAlq.get(i).getAlquilado();
            Administrador adm = lisAlq.get(i).getAdministra();
            Garante gar = lisAlq.get(i).getGarantiza();
            html+=          "<tr class= "+nameClass+">\n";
            html+=              "<td><center> "+lisAlq.get(i).getId()+" </center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getFecha().getDate()+"/"+(lisAlq.get(i).getFecha().getMonth()+1)+"/"+(lisAlq.get(i).getFecha().getYear()+1900)+"</center></td>\n";
            html+=              "<td><center>"+lisAlq.get(i).getMonto()+"</center></td>\n";
            html+=              "<td><center>"+cli.getId()+" - "+cli.getNombre()+" "+cli.getApellido()+"</center></td>\n";
            html+=              "<td><center>"+in.getId()+" - "+in.getDireccion()+"</center></td>\n";
            html+=              "<td><center>"+gar.getId()+" - "+gar.getNombre()+" "+gar.getApellido()+"</center></td>\n";
            html+=              "<td><center>"+adm.getId()+" - "+adm.getNombre()+" "+adm.getApellido()+"</center></td>\n";
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/edit.png\" onMouseOver=this.src=\"images/adminicons/edit.png\" onclick=\"editAlquiler("+lisAlq.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=              "<td><center><input type=image value = sumit alt = sumit Button src=\"images/adminicons/delete.png\" onMouseOver=this.src=\"images/adminicons/delete.png\" onclick=\"elimAlquiler("+lisAlq.get(i).getId()+");\" width=\"22\" height=\"22\" border=\"0\"></center></td>\n"; 
            html+=          "</tr>\n";
            if(nameClass.compareTo("even")==0){
                nameClass="odd";
            }else if(nameClass.compareTo("odd")==0){
                nameClass="even";
            }
        }//endFor
        html+=      "</table>\n";//line49
        html+=          "</form>\n";            
        html+=  "</div>\n";//endTable_grid
        return html;
    } 
    
    public String altaAlq(AccesoBD abd){
        html+="<div class=\"add_tab\">\n";
        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form name=\"formAltaAlq\" method=\"post\" action=\"AltaAlquiler.jsp\"   onsubmit=\"return formularioAlq(this)\" >\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></b>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fecha\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=          "<br>&nbsp;</br>\n";
        html+=      "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Monto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span>  </label><input name=\"monto\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=          "<br>&nbsp;</br>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Inmueble:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecInmueble\" class=\"form_select\"  name=\"InmuebleAlquiler\" onChange=\"selecInmuebleeDeAlq()\">\n";
        html+=                      "<option select value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<optgroup label=\" Asignar nuevo inmueble:\">\n";
        html+=                          "<option value=\"nuevo\">Crear</option>\n";
        html+=                      "</optgroup>";
        html+=                          "<optgroup label=\" Seleccionar existente:\">\n";
        html+=                      "</optgroup>";

        lisInm=abd.listar(new Inmueble(),"");
        for(int i=0;i<=lisInm.size()-1;i++){ 
            if (lisInm.get(i).getDisp().equals("Disponible") ){
                html+=              "<option value=\""+lisInm.get(i).getId()+"\">"+lisInm.get(i).getDireccion()+", "+lisInm.get(i).getDescripcion()+"</option>\n";
            }
        }
        html+=                  "</select>\n";
        html+=          "</div>";//endAdminform_row_contact(Inmueble)
        html+=          "<br>&nbsp;</br>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Cliente:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecCliente\" class=\"form_select\"  name=\"ClienteAlquiler\" onChange=\"selecClienteeDeAlq()\">\n";
        html+=                      "<option select value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<optgroup label=\" Asignar nuevo cliente:\">\n";
        html+=                          "<option value=\"nuevo\">Crear</option>\n";
        html+=                      "</optgroup>";
        html+=                          "<optgroup label=\" Seleccionar existente:\">\n";
        html+=                      "</optgroup>";
        lisClie=abd.listar(new Cliente(),"");
        for(int i=0;i<=lisClie.size()-1;i++){        
            html+=                      "<option value=\""+lisClie.get(i).getId()+"\">"+lisClie.get(i).getApellido()+", "+lisClie.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(Cliente)
        html+=          "<br>&nbsp;</br>\n";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Garante:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecGarante\" class=\"form_select\"  name=\"GaranteAlquiler\" onChange=\"selecGarantee()\">\n";
        html+=                      "<option select value=\"vacio\">--------------------------------------------------------</option>\n";
        html+=                      "<optgroup label=\" Asignar nuevo garante:\">\n";
        html+=                          "<option value=\"nuevo\">Crear</option>\n";
        html+=                      "</optgroup>";
        html+=                          "<optgroup label=\" Seleccionar existente:\">\n";
        html+=                      "</optgroup>";
        lisGar=abd.listar(new Garante(),"");
        for(int i=0;i<=lisGar.size()-1;i++){        
            html+=                      "<option value=\""+lisGar.get(i).getId()+"\">"+lisGar.get(i).getApellido()+", "+lisGar.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=          "</div>\n";//endAdminform_row_contact(Garante)        
        html+=          "<br>&nbsp;</br>\n";
        html+=      "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=          "<br>&nbsp;</br>\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioAlq(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarAlquiler.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=      "</div>\n";
        html+=              "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para crear y/o modificar un alquiler.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="<br>&nbsp;</br>\n";
        html+="<br>&nbsp;</br>\n";
        return html;
    }
}
