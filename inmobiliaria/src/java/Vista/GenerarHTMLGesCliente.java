package Vista;
//Vista de la secci&oacute;n de gestionar cliente
import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

public class GenerarHTMLGesCliente extends GenerarHTMLGeneral{
    GestionarCliente TGA= new GestionarCliente();
    String flag;
    String titulo;
    String hidden="hidden";
    public GenerarHTMLGesCliente(String flag,String VS){
        this.flag=flag;
        if(flag==null){
            titulo="Gestionar Cliente: ";
            hidden="";
        }
        else 
            if(flag.equals("alq")&&(VS.equals("LC"))){
                titulo="Elija ID:";
        }else 
            if(flag.equals("alq") || (flag.equals("ven")) &&(VS.equals("AC"))){
                titulo="Cree un nuevo Cliente (luego de crearlo, debe rellenar los campos que habia ingresado anteriormente)";
        }
    }
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">"+titulo+"</div>\n";
        html+=              "<form name=\"formCliente\" method=\"post\" action=\"GestionarCliente.jsp\" >\n";        	
        html+=                  "<div id=\"admin_header_border\"></div>\n";
        html+=                  "<p>&nbsp;</p>\n";
        html+=                  "<p>&nbsp;</p>\n";
        html+=                  "<p>&nbsp;</p>\n";
        html+=                  "<label class=\"search\""+hidden+"  style=\"padding-top:0px;\">Seleccionar:  </label>\n";
        html+=                  "<select "+hidden+" name=\"selecCliente\" class=\"form_select\" style=\"width:150px\"><p>&nbsp;</p><p>&nbsp;</p>\n";
        html+=                      "<div id=\"admin_header_border\" ></div>\n";
        html+=                      "<option value=\"LC\" select>-----------------------------------</option>\n";
        html+=                      "<option value=\"LC\">Listar Cliente</option>\n";
        html+=                      "<option value=\"AC\">Alta Cliente</option>\n";
        html+=                  "</select>\n";
        html+=                  "<input "+hidden+" type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=               "</form>\n";
        html+=      "</div>\n";
        html+=      "<p>&nbsp;</p>\n";
        html+=      "<p "+hidden+">&nbsp;</p>\n";
        html+=      "<p "+hidden+">&nbsp;</p>\n";
        html+=  "<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Clien(AccesoBD abd,HttpServletRequest request) throws Exception{
        String html="";
        html=TGA.TablaGestionarCliente(abd,request,flag);
        html+="</div>\n";//endOfMain_content
        return html;
    }
}

