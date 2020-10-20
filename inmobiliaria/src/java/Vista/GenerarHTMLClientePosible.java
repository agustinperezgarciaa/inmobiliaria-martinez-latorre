package Vista;
//Vista de ingreso de datos de un cliente interesado
public class GenerarHTMLClientePosible extends GenerarHTMLGeneral{

    public GenerarHTMLClientePosible(){
        
    }
    public String generarHTMLMainContent (long id){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Por favor,llene el siguiente formulario:</div>\n";
        html+=  "</div>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        html+=      "<div class=\"add_tab\">\n";
        html+=          "<div class=\"form_contact\">\n";
        html+=              "<form name=\"formAltaProp\" id=\"formIDAltaProp\" method=\"post\" action=\"AltaClientePosible.jsp\" onsubmit=\"return formularioCliePos(this)\" >\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span> </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\"\"/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\"\"/><br/><p>&nbsp;</p></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\"\"/><br/></div>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<input type=\"hidden\" id=\"idInmueble\" name=\"id\" value=\""+id+"\">\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioCliePos(this)\" type=image value = sumit alt = sumit Button src=\"images/aceptar.png;\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"Buscador.jsp\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=          "</div>\n";
        html+=      "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<div class=\"admin_footer_help\">\n";
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para enviar la solicitud.</p>\n";
        html+=  "</div>\n";//EndAdmin_footer_help    
        html+= "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
   
    }
}

