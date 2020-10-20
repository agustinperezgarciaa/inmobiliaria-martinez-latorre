package Vista;
import javax.servlet.http.HttpServletRequest;

//Vista de la secci&oacute;n de loguin
public class GenerarHTMLLoginCambioContra extends GenerarHTMLGeneral {
    public GenerarHTMLLoginCambioContra(){}
    
    public String generarHTMLMain_content(HttpServletRequest request,String a){
        String visibility=a;
        String html="";
        html+="<div id=\"main_content_loguin\">\n"; 
        html+=  "<div class=\"admin_login\">\n";
        html+=      "<div class=\"left_box\">\n";
        html+=          "<div class=\"top_left_box\"></div>\n";
        html+=          "<div class=\"center_left_box\">\n";
        html+=              "<div class=\"box_title\">Ingrese sus datos</div>\n";
        html+=                  "<div class=\"form\">\n";
        html+=                      "<form name=\"login\" method=\"post\" action= \"LoginCheckCambioContra.jsp\">\n";                 
        html+=                          "<div class=\"form_row\"><label class=\"left\">Usuario: </label><input name=\"user\" type=\"text\" class=\"form_input\"/></div> \n";
        html+=                          "<div class=\"form_row\"><label class=\"left\">Contraseña: </label><input name=\"pass\" type=\"password\" class=\"form_input\"/></div>\n";
        html+=                          "<div style=\"float:right; padding:10px 25px 0 0\">\n";
        html+=                          "<input type=image value = sumit alt = sumit Button name=\"formListar\" src=\"images/login.gif\"onMouseOver=this.src=\"images/login.gif\" style=\"width:65px;\">";         
        html+=                       "</form>\n";
        html+=                    "</div>\n";
        html+=                "</div>\n";
        html+=             "</div>\n";
        html+=             "<div class=\"bottom_left_box\">\n";
        html+=       "</div>\n";
        html+=    "</div> \n";
        html+=    "<div class=\"login_help\" style=\"visibility:"+visibility+"\">\n";
        html+=      "<span><p>Error:Datos Inv&aacute;lidos<br />";
    //  html+=      "<a href=\"#\" style=\"text-decoration:none\">¿Has olvidado tu contraseña?</a></p></span>";
        html+=    "</div>\n";
        html+=  "</div>\n";
        html+="</div>\n";
        return html;
    }    
}
