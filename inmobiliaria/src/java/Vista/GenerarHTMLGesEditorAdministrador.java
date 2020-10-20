package Vista;
//Vista de la secci&oacute;n de editor de administrador
import Entidad.Administrador;

public class GenerarHTMLGesEditorAdministrador extends GenerarHTMLGeneral{
    GestionarAdministrador TGA= new GestionarAdministrador();
    String hidden="hidden";
    public GenerarHTMLGesEditorAdministrador(){}
    
    public String generarHTMLMainContent (Administrador admin){
        String html="";
        if (admin.getUsuario().equals("superusuario")){
            hidden = "";
        }
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        if (admin.getUsuario().equals("superusuario")){
            html+=      "<div class=\"admin_editoffer_title\">Gestionar Administrador:</div>\n";
        }else{
            html+=      "<div class=\"admin_editoffer_title\">Modificar Administrador</div>\n";
        }
        html+=      "<form name=\"formAdministrador\" method=\"post\" action=\"GestionarAdministrador.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label "+hidden+" class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select "+hidden+" name=\"selecAdministrador\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LA\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LA\">Listar Admin.</option>\n";
        html+=              "<option value=\"AA\">Alta Admin.</option>\n";
        html+=          "</select>\n";
        html+=          "<input "+hidden+" type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";        
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        //-------------------------------------------------//
        html+=  "<div class=\"add_tab\">\n";//MODIFICAR ADMIN
        html+=      "<div class=\"form_contact\">\n";
        html+=          "<form name=\"formAltaAdministrador\" method=\"post\" id=\"formAltaAdministrador\" action=\"ConfirmarModificarAdministrador.jsp\" onsubmit=\"return formularioEditAdmin(this)\">\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"nombre\" type=\"text\" class=\"form_input_contact\" value=\""+admin.getNombre()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Apellido:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"apellido\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getApellido()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">D.N.I:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"dni\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getDni()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp<span>(*) </span>  </label><input name=\"direccion\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getDirecc()+"\"/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Pag.Web:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"paginaWeb\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getPagWeb()+"\"/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Usuario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"usuario\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getUsuario()+"\"/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span> </label><input name=\"mail\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getEmail()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.Fijo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input name=\"telFijo\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getTelFijo()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Tel.M&oacute;vil:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span>  </label><input name=\"telMovil\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getTelMovil()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Fecha.Nac:&nbsp;&nbsp;<span>(*) </span> </br>(dd/mm/aaaa)&nbsp;&nbsp;&nbsp; </label><input name=\"fechaNac\"  type=\"text\" class=\"form_input_contact\" value=\""+admin.getFechaNac().getDate()+"/"+(admin.getFechaNac().getMonth()+1)+"/"+(admin.getFechaNac().getYear()+1900)+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Localidad:&nbsp;&nbsp;&nbsp;&nbsp;<span>(*) </span>  </label><input name=\"localidad\" type=\"text\" class=\"form_input_contact\" value=\""+admin.getLoc()+"\"/><br/></div><p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";

        //html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Contraseña:&nbsp;&nbsp;<span>(*) </span>  </label><input name=\"passUno\"  type=\"password\" value=\""+admin.getPassword()+"\" class=\"form_input_contact\"/></div><p>&nbsp;</p>\n";
        //html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Reenscribir&nbsp;&nbsp;&nbsp;<span>(*) </span>  </br>contraseña:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label><input name=\"passDos\" type=\"password\" value=\""+admin.getPassword()+"\" class=\"form_input_contact\"/></div>\n";
        html+= "<div class=\"right_button\" style=\"margin-left: 0px\";\"text-align: left;\"><a href=\"LoginCambioContra.jsp\">Modificar contraseña&nbsp;&nbsp;&nbsp; </a></div>\n";

        html+=              "<div class=\"adminform_row_contact\"><label class=\"adminleft\"></label><input name=\"id\" type=\"hidden\" class=\"form_input_contact\" value=\""+admin.getId()+"\"/><br/></div>\n";
        html+=              "<div style=\"float:right; padding:10px 25px 0 0;\">\n";
        html+=              "<div class=\"right_button\"><input onclick=\"return formularioAdmin(this)\"type=image value = sumit alt = sumit Button src=\"images/aceptar.png\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"Admin.jsp\" onclick=\"return confirm('Operacion Cancelada,los datos no seran modificados');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=         "</div>\n";
        html+=         "</form>\n";
        html+=      "</div>\n";//EndFormContact
        html+=    "<div class=\"admin_footer_help\">\n";
        html+=    "<p><span>&nbsp;&nbsp;&nbsp;(*)</span> Reemplace en los campos que desea modificar los datos</p> <span>&nbsp;&nbsp;&nbsp;(**)</span> Por su seguridad, en el caso de no modificar la contraseña, la tiene que ingresar nuevamente\n";
        html+=   "</div>\n";//EndAdmin_footer_help    
        html+=  "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
}

