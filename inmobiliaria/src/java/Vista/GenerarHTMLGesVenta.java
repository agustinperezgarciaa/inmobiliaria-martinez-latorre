package Vista;

import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n de gestionar venta
public class GenerarHTMLGesVenta extends GenerarHTMLGeneral{
    GestionarVenta TGV= new GestionarVenta();
    String html="";
    String valorForm="";

    public GenerarHTMLGesVenta(){}
    
    public String generarHTMLMainContent (){
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
        html+=       "</form>\n";
        html+=   "</div>\n";
        html+=   "<p>&nbsp;</p>\n";
        html+=   "<p>&nbsp;</p>\n";
        html+=   "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Ven(AccesoBD abd,HttpServletRequest request ) throws Exception{
        html=TGV.TablaGestionarVenta(abd, request);
        html+="</div>\n";//endOfMain_content
        return html;
    }
}

