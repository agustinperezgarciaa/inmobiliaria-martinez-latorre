package Vista;

//Vista de la secci&oacute;n de cambiar contraseña


import Entidad.Administrador;
import Persistencia.AccesoBD;

public class GenerarHTMLModificarContra extends GenerarHTMLGeneral{

    public GenerarHTMLModificarContra(){

    }
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Ingrese su nueva contraseña</div>\n";
        html+=      "<div id=\"admin_header_border\"></div>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTMLAddTab(AccesoBD abd){
        String html="";
        html+="<div class=\"add_tab\">\n";
                        html+=  "<p>&nbsp;</p><p>&nbsp;</p>\n";

        html+=  "<div class=\"form_contact\">\n";
        html+=      "<form  id=\"formularioAltaInmueble \"name=\"inmuebleNuevo\"  method=\"post\" action=\"ConfirmarModificarContra.jsp\" onsubmit=\"return formularioCambiaContra(this)\">";
        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Contraseña:&nbsp;&nbsp;<span>(*) </span> </label><input name=\"passUno\"  type=\"password\" value=\"\" class=\"form_input_contact\"/></div><p>&nbsp;</p>\n";
                html+=  "<p>&nbsp;</p>\n";

        html+=          "<div class=\"adminform_row_contact\"><label class=\"adminleft\">Reenscribir&nbsp;&nbsp;&nbsp;<span>(*) </span>  </br>contraseña:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name=\"passDos\" type=\"password\" value=\"\" class=\"form_input_contact\"/></div><p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=      "<div style=\"float:right; padding:10px 25px 0 0;\">\n";

        html+=              "<div class=\"right_button\"><input onclick=\"return formularioAdmin(this)\"type=image value = sumit alt = sumit Button src=\"images/aceptar.png\"onMouseOver=this.src=\"images/aceptar.png\" style=\"width:20px;\"></div>\n"; 
        html+=              "<div class=\"right_button\"><a href=\"ModificarAdministrador.jsp\" onclick=\"return confirm('Operacion Cancelada,los datos no seran modificados');\"><img src=\"images/cancelar.png\"style=\"width:20px\"> </a></div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";

        html+=    "</form>\n";
        html+=  "</div>\n";//EndFormContact
        html+=  "<p>&nbsp;</p><p>&nbsp;</p>\n";
                html+=  "<p>&nbsp;</p>\n";

        html+=  "<div class=\"admin_footer_help\">\n";

        
        html+=      "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;(*)</span> Campos requeridos para cambiar la contraseña.</p>";
        
        html+=  "</div>\n";//EndAdmin_footer_help   
                html+=  "<p>&nbsp;</p><p>&nbsp;</p>\n";
                        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";


        html+= "</div>\n";//EndAdd_tab
        html+="</div>\n";//endOfMain_content
        return html;
    }
    

}



