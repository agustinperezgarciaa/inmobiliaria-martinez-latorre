package Vista;
//Vista de la secci&oacute;n de gestionar alquiler
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

public class GenerarHTMLGesAlquiler extends GenerarHTMLGeneral{
    GestionarAlquiler TGA= new GestionarAlquiler();
    String html="";
    String valorForm="";
    
    public GenerarHTMLGesAlquiler(){}
    
    public String generarHTMLMainContent (){
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
        html+=    "</div>\n";
        html+=    "<p>&nbsp;</p>\n";
        html+=    "<p>&nbsp;</p>\n";
        html+=    "<p>&nbsp;</p>\n";
        html+=    "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Alq(AccesoBD abd,HttpServletRequest request) throws Exception{
        html=TGA.TablaGestionarAlq(abd,request);
        html+="</div>\n";//endOfMain_content
        return html;
    }
}

