package Vista;
//Vista de la secci&oacute;n de editor de propietario
import Entidad.Propietario;

public class GenerarHTMLGesEditorPropietario extends GenerarHTMLGeneral{
    GestionarPropietario TGP= new GestionarPropietario();
    public GenerarHTMLGesEditorPropietario(){}
    
    public String generarHTMLMainContent (Propietario prop){
        String html = "";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=     "<div class=\"admin_editoffer_title\">Gestionar Propietario:</div>\n";
        html+=     "<form name=\"formPropietario\" method=\"post\" action=\"GestionarPropietario.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecPropietario\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LP\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LP\">Listar Propietario</option>\n";
        html+=              "<option value=\"AP\">Alta Propietario</option>\n";
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
        html+=          "<form name=\"formModProp\" method=\"post\" id=\"formModProp\" action=\"ConfirmarModificarPropietario.jsp\" onsubmit=\"return formularioEditProp(this)\" >\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\""+prop.getNombre()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getApellido()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getDni()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getDirecc()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getEmail()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getTelFijo()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getTelMovil()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\""+prop.getFechaNac().getDate()+"/"+(prop.getFechaNac().getMonth()+1)+"/"+(prop.getFechaNac().getYear()+1900)+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\""+prop.getLoc()+"\"/><br/></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+prop.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioProp(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarPropietario.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=          "</div>\n";
        html+=     "</form>\n";
        html+=    "</div>\n";//EndFormContact
        html+=   "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Reemplace en los campos que desea modificar los datos.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+= "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
}