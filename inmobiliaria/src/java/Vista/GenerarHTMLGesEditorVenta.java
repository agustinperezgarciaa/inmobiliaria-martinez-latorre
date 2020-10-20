package Vista;
import Entidad.Cliente;
import Entidad.Inmueble;
import Entidad.Venta;
import Persistencia.AccesoBD;
import java.util.LinkedList;
//Vista de la secci&oacute;n de editor de venta

public class GenerarHTMLGesEditorVenta extends GenerarHTMLGeneral{
    GestionarVenta TGV= new GestionarVenta();
    private LinkedList<Cliente> lisClie;
    private LinkedList<Inmueble> lisInm;
  
    public GenerarHTMLGesEditorVenta(){}
    public String generarHTMLMainContent (Venta ven,AccesoBD abd){
        String html = "";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Gestionar Venta:</div>\n";
        html+=      "<form name=\"formVenta\" method=\"post\" action=\"GestionarVenta.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";        
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecVenta\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LV\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LV\">Listar Venta</option>\n";
        html+=              "<option value=\"AV\">Alta Venta</option>\n";
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
        html+=          "<form name=\"formAltaVen\" method=\"post\" id=\"formModVen\" action=\"ConfirmarModificarVenta.jsp\" onsubmit=\"return formularioEditVen(this)\" >\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span></b>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp;  </label><input name=\"fecha\" type=\"text\" class=\"form_input_contact\" value=\""+ven.getFecha().getDate()+"/"+(ven.getFecha().getMonth()+1)+"/"+(ven.getFecha().getYear()+1900)+"\"/><br/></div>\n";
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Monto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"monto\"  type=\"text\" class=\"form_input_contact\" value=\""+ven.getMonto()+"\"/><br/></div>\n";
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Inmueble:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>\n";
        html+=                  "<select id=\"selecInmueble\" class=\"form_select\"  name=\"InmuebleVenta\" onChange=\"selecInmueblee()\">\n";
        html+=                      "<option select value=\""+ven.getVendido().getId()+"\">"+ven.getVendido().getDireccion()+"\", \""+ven.getVendido().getDescripcion()+"</option>\n";
        lisInm=abd.listar(new Inmueble(),"");
        for(int i=0;i<=lisInm.size()-1;i++){ 
            if (lisInm.get(i).getDisp().equals("Disponible") ){
                html+=              "<option value=\""+lisInm.get(i).getId()+"\">"+lisInm.get(i).getDireccion()+", "+lisInm.get(i).getDescripcion()+"</option>\n";
            }
        }
        html+=                  "</select>\n";
        html+=              "</div>\n";//endAdminform_row_contact(Inmueble)
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Cliente:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>\n";
        html+=                  "<select id=\"selecCliente\" class=\"form_select\"  name=\"ClienteVenta\" onChange=\"selecClientee()\">\n";
        html+=                      "<option select value=\""+ven.getVende().getId()+"\">"+ven.getVende().getApellido()+", "+ven.getVende().getNombre()+"</option>\n";
        lisClie=abd.listar(new Cliente(),"");
        for(int i=0;i<=lisClie.size()-1;i++){        
        html+=                      "<option value=\""+lisClie.get(i).getId()+"\">"+lisClie.get(i).getApellido()+", "+lisClie.get(i).getNombre()+"</option>\n";
        }
        html+=                  "</select>\n"; 
        html+=              "</div>\n";//endAdminform_row_contact(Cliente)
        html+=              "<br>&nbsp;</br>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+ven.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\return formularioVen(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarVenta.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=       "</div>\n";
        html+=    "</div>\n";
        html+=    "<br>&nbsp;</br>\n";
        html+=  "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\" >\n";
        html+=      "<p><span>&nbsp;(*)</span>Reemplace en los campos que desea modificar los datos.\n";
        html+=  "</div>\n";//EndAdmin_footer_help 
        html+=  "<br>&nbsp;</br>\n";
        html+= "</div>\n";//EndAdd_tab
        html+= "<br>&nbsp;</br>\n";
        html+= "<br>&nbsp;</br>\n";
        return html;
    }
}