package Vista;

import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;
import javax.servlet.http.HttpSession;

//Vista de la secci&oacute;n de gestionar garante
public class GenerarHTMLGesGarante extends GenerarHTMLGeneral{
    GestionarGarante TGG= new GestionarGarante();
    String flag;//Variable para saber si se llega a GestionarGarante desde altaGarante.jsp
    String titulo;
    String hidden="hidden";
    public GenerarHTMLGesGarante(String flag,String VS){
        this.flag=flag;
        if(flag==null){
            titulo="Gestionar Garante:";
            hidden="";
        }
        else if(flag.equals("alq")&&(VS.equals("LG"))){
            //disabled="disabled";
            titulo="Elija ID:";
        }else if(flag.equals("alq")&&(VS.equals("AG"))){
            titulo="Cree un nuevo Garante \n (luego de crearlo, debe rellenar los campos que habia ingresado anteriormente)";
        }
    }    
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">"+titulo+"</div>\n";
        html+=      "<form name=\"formGarante\" method=\"post\" action=\"GestionarGarante.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\""+hidden+" style=\"padding-top:0px;\""+hidden+">Seleccionar:  </label>\n";
        html+=          "<select "+hidden+" name=\"selecGarante\" class=\"form_select\" style=\"width:150px\">\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\"></div>\n";
        html+=              "<option value=\"LG\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LG\">Listar Garante</option>\n";
        html+=              "<option value=\"AG\">Alta Garante</option>\n";
        html+=          "</select>\n";
        html+=          "<input "+hidden+" type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=      "</form>\n";
        html+=  "</div>\n";
        html+=  "<p "+hidden+">&nbsp;</p>\n";
        html+=  "<p "+hidden+">&nbsp;</p>\n";
        html+=  "<p>&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Gar(AccesoBD abd,HttpServletRequest request,HttpSession session) throws Exception{
        String html = "";
        html=TGG.TablaGestionarGarante(abd,request,session,flag);
        html+="</div>\n";//endOfMain_content
        return html;
    }
}

