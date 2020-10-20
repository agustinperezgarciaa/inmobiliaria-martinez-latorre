package Vista;
//Vista de la secci&oacute;n de editor de alquiler
import Entidad.*;
import Persistencia.AccesoBD;
import java.util.Date;
import java.util.LinkedList;

public class GenerarHTMLGesEditorAlquiler extends GenerarHTMLGeneral{
    GestionarAlquiler TGI = new GestionarAlquiler();
    private LinkedList<Cliente> lisClie;
    private LinkedList<Inmueble> lisInm;
    private LinkedList<Garante> lisGar;
    Date c1;
    int dia,mes,año;
    
    public GenerarHTMLGesEditorAlquiler(){}    
    
    public String generarHTMLMainContent (Alquileres alq, AccesoBD abd){
        String html = "";
       
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Gestionar Alquiler:</div>\n";
        html+=      "<form name=\"formAlquiler\" method=\"post\" action=\"GestionarAlquiler.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecAlquiler\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LAl\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LAl\">Listar Alquiler</option>\n";
        html+=              "<option value=\"AAl\">Alta Alquiler</option>\n";
        html+=          "</select>\n";
        html+=          "<input type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";        
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        html+=  "<div class=\"add_tab\">\n";
        html+=      "<div class=\"form_contact\">\n";
        html+=          "<form name=\"formAltaAlq\" method=\"post\" action=\"ConfirmarModificarAlquiler.jsp\" onsubmit=\"return formularioEditAlq(this)\" >\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></b>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp;  </label><input name=\"fecha\" type=\"text\" class=\"form_input_contact\" value=\""+alq.getFecha().getDate()+"/"+(alq.getFecha().getMonth()+1)+"/"+(alq.getFecha().getYear()+1900)+"\"/><br/></div>\n";
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Monto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span>  </label><input name=\"monto\"  type=\"text\" class=\"form_input_contact\" value=\""+alq.getMonto()+"\"/><br/></div>\n";
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Inmueble:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></label>\n";
        html+=                  "<select id=\"selecInmueble\" class=\"form_select\"  name=\"InmuebleAlquiler\" >\n";        
        html+=                      "<option select value=\""+alq.getAlquilado().getId()+"\">"+alq.getAlquilado().getDireccion()+"\", \""+alq.getAlquilado().getDescripcion()+"</option>\n";
        lisInm=abd.listar(new Inmueble(),"");
        for(int i=0;i<=lisInm.size()-1;i++){ 
            if (lisInm.get(i).getDisp().equals("Disponible") ){
                html+=              "<option value=\""+lisInm.get(i).getId()+"\">"+lisInm.get(i).getDireccion()+", "+lisInm.get(i).getDescripcion()+"</option>\n";
            }
        }
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(Inmueble)
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Cliente:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecCliente\" class=\"form_select\"  name=\"ClienteAlquiler\">\n";
        html+=                      "<option select value=\""+alq.getAlquila().getId()+"\">"+alq.getAlquila().getApellido()+", "+alq.getAlquila().getNombre()+"</option>\n";
        lisClie=abd.listar(new Cliente(),"");
        for(int i=0;i<=lisClie.size()-1;i++){        
        html+=                      "<option value=\""+lisClie.get(i).getId()+"\">"+lisClie.get(i).getApellido()+", "+lisClie.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n"; html+=              "</div>\n";//endAdminform_row_contact(Cliente)
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Garante:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label>\n";
        html+=                  "<select id=\"selecGarante\" class=\"form_select\"  name=\"GaranteAlquiler\" >\n";
        html+=                      "<option select value=\""+alq.getGarantiza().getId()+"\">"+alq.getGarantiza().getApellido()+", "+alq.getGarantiza().getNombre()+"</option>\n";
        lisGar=abd.listar(new Garante(),"");
        for(int i=0;i<=lisGar.size()-1;i++){ 
                html+=              "<option value=\""+lisGar.get(i).getId()+"\">"+lisGar.get(i).getApellido()+", "+lisGar.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(Garante)        
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+alq.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\" return formularioEditAlq(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarAlquiler.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=      "</div>\n";
        html+=    "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\" style=width: 908px;>\n";
        html+=      "<p><span>&nbsp;(*)</span>Reemplace en los campos que desea modificar los datos.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+="</div>\n";//EndAdd_tab
        html+="<br>&nbsp;</br>\n";
        html+="<br>&nbsp;</br>\n";
        return html;
    }
}