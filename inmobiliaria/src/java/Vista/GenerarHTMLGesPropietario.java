package Vista;

import javax.servlet.http.HttpServletRequest;
import Persistencia.AccesoBD;

//Vista de la secci&oacute;n de gestionar propietario
public class GenerarHTMLGesPropietario extends GenerarHTMLGeneral{
    GestionarPropietario TGA= new GestionarPropietario();
    String flag="false";//Variable para saber si se llega a GestionarPropietario desde altaInmueble.jsp
    String titulo;
    String hidden="hidden";
    public GenerarHTMLGesPropietario(String flag,String VS){
        this.flag=flag;        
        if(flag==null){
            titulo="Gestionar Propietario:";
            hidden="";
        }
        else if(flag.equals("verdadero")&&(VS.equals("LP"))){
            titulo="Elija ID:";
        }else if(flag.equals("verdadero")&&(VS.equals("AP"))){
            titulo="Cree un nuevo Propietario (luego de crearlo, debe rellenar los campos que habia ingresado anteriormente";
        }
    }
    
    public String generarHTMLMainContent (){
        String html="";
        html+="<div id=\"main_content\">\n";
        html+=  "<div id=\"admin_header\">\n";
        html+=      "<div class=\"admin_editoffer_title\">"+titulo+"</div>\n";
        html+=      "<form name=\"formPropietario\" method=\"post\" action=\"GestionarPropietario.jsp\" >\n";        	
        html+=          "<div id=\"admin_header_border\"></div><p>&nbsp;</p><p>&nbsp;</p>\n<p>&nbsp;</p>\n";
        html+=          "<label class=\"search\""+hidden+" style=\"padding-top:0px;\""+hidden+">Seleccionar:  </label>\n";
        html+=          "<select "+hidden+" name=\"selecPropietario\" class=\"form_select\" style=\"width:150px\"><p>&nbsp;</p><p>&nbsp;</p>\n";
        html+=              "<div id=\"admin_header_border\" ></div>\n";
        html+=              "<option value=\"LP\" select>-----------------------------------</option>\n";
        html+=              "<option value=\"LP\">Listar Propietario</option>\n";
        html+=              "<option value=\"AP\">Alta Propietario</option>\n";
        html+=          "</select>\n";
        html+=          "<input "+hidden+" type=image value = sumit alt = sumit Button src=\"images/adminicons/search.png\"onMouseOver=this.src=\"images/adminicons/search.png\" style=\"width:20px;\">"; 
        html+=       "</form>\n";
        html+=   "</div> <p>&nbsp;</p><p>&nbsp;</p>\n<p>&nbsp;</p>\n";;
        html+="<div id=\"admin_header_border\"></div>\n";
        return html;
    }

    public String generarHTML_ABM_Prop(AccesoBD abd,HttpServletRequest request) throws Exception{
        String html="";
        html=TGA.TablaGestionarPropietario(abd,request,flag);
        html+="</div>\n";//endOfMain_content
        return html;
    }

}


