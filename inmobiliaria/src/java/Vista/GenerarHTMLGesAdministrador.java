package Vista;
//Vista de la secci&oacute;n de gestionar administrador
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;
import javax.servlet.http.HttpSession;

public class GenerarHTMLGesAdministrador extends GenerarHTMLGeneral{
    GestionarAdministrador TGA= new GestionarAdministrador();
    
    public GenerarHTMLGesAdministrador(){}
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">Gestionar Administrador:</div>\n";
        html+=      "<form name=\"formAdministrador\" method=\"post\" action=\"GestionarAdministrador.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\" style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=          "<select name=\"selecAdministrador\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";       
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LA\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LA\">Listar Admin.</option>\n";
        html+=              "<option value=\"AA\">Alta Admin.</option>\n";
        html+=          "</select>\n";
        html+=          "<input type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+="<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Admin(AccesoBD abd,HttpServletRequest request,HttpSession session) throws Exception{
        String html="";
        html=TGA.GestionarAdministrador(abd,request,session);
        html+="</div>\n";//endOfMain_content
        return html;
    }

}

