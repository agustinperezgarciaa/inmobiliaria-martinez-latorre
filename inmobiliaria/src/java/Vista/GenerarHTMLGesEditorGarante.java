package Vista;
//Vista de la secci&oacute;n de editor de garante
import Entidad.Garante;


public class GenerarHTMLGesEditorGarante extends GenerarHTMLGeneral{
    GestionarGarante TGG= new GestionarGarante();
    public GenerarHTMLGesEditorGarante(){}
    
    public String generarHTMLMainContent (Garante gar){
        String html = "";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Gestionar Garante:</div>\n";
        html+=      "<form name=\"formGarante\" method=\"post\" action=\"GestionarGarante.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecGarante\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LG\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LG\">Listar Garante</option>\n";
        html+=              "<option value=\"AG\">Alta Garante</option>\n";
        html+=          "</select>\n";
        html+=              "<input type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        html+=  "<div class=\"add_tab\">\n";
        html+=      "<div class=\"form_contact\">\n";
        html+=          "<form name=\"formModGar\" method=\"post\" id=\"formModGar\" action=\"ConfirmarModificarGarante.jsp\" onsubmit=\"return formularioEditGara(this)\">\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\""+gar.getNombre()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getApellido()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getDni()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getDirecc()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getEmail()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getTelFijo()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getTelMovil()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp;   </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\""+gar.getFechaNac().getDate()+"/"+(gar.getFechaNac().getMonth()+1)+"/"+(gar.getFechaNac().getYear()+1900)+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\""+gar.getLoc()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Profesion:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"profesion\" type=\"text\" class=\"form_input_contact\" value=\""+gar.getProfesion()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Trabaja&nbsp;en:&nbsp;&nbsp;&nbsp;<span>(*) </span></label><input name=\"lugarTrabajo\" type=\"text\" class=\"form_input_contact\" value=\""+gar.getLugarTrabajo()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nacionalidad:&nbsp;<span>(*) </span> </label><input name=\"nacionalidad\" type=\"text\" class=\"form_input_contact\" value=\""+gar.getNacionalidad()+"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+gar.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioProp(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"GestionarPropietario.jsp\" onclick=\"return confirm('Operacion Cancelada');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=          "</div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=       "</form>\n";
        html+=     "</div>\n";//EndFormContact
        html+=    "<div class=\"admin_footer_help\">\n";
        html+=          "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Reemplace en los campos que desea modificar los datos</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+= "</div>\n";//EndAdd_tab
        html+= "<p>&nbsp;</p>\n";
        html+= "<p>&nbsp;</p>\n";
        html+= "<p>&nbsp;</p>\n";
        html+="</div>\n";//endOfMain_content
        return html;
    }
}