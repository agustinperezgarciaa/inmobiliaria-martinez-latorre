package Vista;
//Vista de la secci&oacute;n de editor de cliente
import Entidad.Cliente;

public class GenerarHTMLGesEditorCliente extends GenerarHTMLGeneral{
    GestionarCliente TGC= new GestionarCliente();
    public GenerarHTMLGesEditorCliente(){}
    
    public String generarHTMLMainContent (Cliente clie){
        String html = "";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=    "<div class=\"admin_editoffer_title\">Gestionar Cliente:</div>\n";
        html+=      "<form name=\"formCliente\" method=\"post\" action=\"GestionarCliente.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecCliente\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LC\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LC\">Listar Cliente</option>\n";
        html+=              "<option value=\"AC\">Alta Cliente</option>\n";
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
        html+=          "<form name=\"formModCliente\" method=\"post\" id=\"formModCliente\" action=\"ConfirmarModificarCliente.jsp\" onsubmit=\"return formularioEditClie(this)\" >\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\""+clie.getNombre()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getApellido()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getDni()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getDirecc()+"\"/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getEmail()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getTelFijo()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getTelMovil()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\""+clie.getFechaNac().getDate()+"/"+(clie.getFechaNac().getMonth()+1)+"/"+(clie.getFechaNac().getYear()+1900)+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\""+clie.getLoc()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"style= margin-left:100px;><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+clie.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioClie(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarCliente.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a><p>&nbsp;</p></div>\n";
        html+=          "</div>\n";
        html+=       "</form>\n";
        html+=     "</div>\n";//EndFormContact
        html+=     "<div class=\"admin_footer_help\" >\n";
        html+=          "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Reemplace en los campos que desea modificar los datos</p>\n";
        html+=   "</div>\n";//EndAdmin_footer_help    
        html+=  "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
}